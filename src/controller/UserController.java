package controller;

import data.Doctor;
import data.Message;
import data.Pat;
import data.User;
import service.ControllerService;
import service.DoctorOfPetService;
import service.PatService;
import service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserController {
    public static void add(){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入id：");
        String id = in.next();
        System.out.println("请输入用户名：");
        String name = in.next();
        String password1 = null;
        while (true) {
            System.out.println("请输入密码：");
            password1 = in.next();
            System.out.println("请再一次输入密码：");
            String password2 = in.next();
            if (password1.equals(password2)) {
                break;
            }
            System.out.println("两次输入的密码不同，请重新输入");
        }

        System.out.println("请输入用户宠物id：（多个宠物用逗号分隔）");
        ArrayList<String> lp=new ArrayList<>();
        String s = in.next();
        String ss[] =null;//一个医生最多治疗10个宠物
        ss=s.split(",");

        for(int i =0;i< ss.length;i++)
        {
            System.out.println(ss[i]);
            if(ss[i]!=null){

                lp.add(ss[i]);
            }
        }
        System.out.println(lp);
        ControllerService.users.add(new User(id, name, password1,lp));
        System.out.println("=========添加成功========");
    }

    public static void outPutyyInformation(String id) throws IOException {
        Scanner in = new Scanner(System.in);
        Message newMessage=new Message("-1","用户 "+id+" 发出预约消息！！！");
        newMessage.setId(String.valueOf(++ControllerService.messageId));
        //System.out.println(newMessage);
        ControllerService.messages.add(newMessage);
        ControllerService.messagesChun(ControllerService.ss1+"src\\csv\\message.csv");
        System.out.println("======================发送成功======================");
    }


    public static void mainMenu(String userId) throws IOException {
        boolean loop =true;
        do{
            Scanner in = new Scanner(System.in);
            System.out.println("-----------------用户主界面----------------");
            System.out.println("---------------1.添加用户信息--------------");
            System.out.println("---------------2.更新用户信息--------------");
            System.out.println("---------------3.查看用户信息--------------");
            System.out.println("---------------4.发出预约消息--------------");
            System.out.println("---------------5.退出--------------");
            System.out.println("请选择（1-4）");
            int key=in.nextInt();
            switch (key){
                case 1:
                    UserController.add();
                    //System.out.println("添加用户信息");
                    break;
                case 2:
                    UserService.userUpdate(userId);
                    //System.out.println("更新用户信息");
                    break;
                case 3:
                    User newUser1=UserService.userFind(userId);
                    //已经进来了肯定就能找到id对应的医生信息
                    System.out.println(newUser1);
                    System.out.println("====================查找成功====================");
                    //System.out.println("查看用户信息");
                    break;
                case 4:
                    User newUser =UserService.userFind(userId);
                    UserController.outPutyyInformation(newUser.getName());
                    //System.out.println("发出预约消息");
                    break;
                case 5:
                    loop = false;
            }
        }while(loop);
    }
}
