package controller;

import data.Doctor;
import service.DoctorOfPetService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DoctorAdmin {
    public static void Admin(ArrayList<Doctor> doctors) throws IOException {
        Scanner in = new Scanner(System.in);
        boolean loop=true;
        do {
            System.out.println("---------------我是医生----------");
            System.out.println(" ---------------1、登录--------------");
            System.out.println(" ---------------2、注册--------------");
            System.out.println(" ---------------3、退出--------------");
            System.out.println("请选择（1-3）");
            int key1 = in.nextInt();
            switch (key1) {
                case 1: {
                    String name;

                    System.out.print("请输入用户名：(默认用户名为张大夫)");
                    name = in.nextLine();
                    if("".equals(name)){
                        name="张大夫";
                    }
                    in.nextLine();
                    String password;

                    System.out.print("请输入密码：(默认密码123456)");
                    password = in.nextLine();
                    if("".equals(password)){
                        password="123456";
                    }
                    String yzm;
                    yzm =AssistantAdmin.yzm();
                    String yzm1=yzm;
                    System.out.print("请输入验证码("+yzm+"):(默认验证码"+yzm1+")");
                    yzm1 = in.nextLine();
                    if("".equals(yzm1)){
                        yzm1=yzm;
                    }
                    boolean flag = false;
                    String doctorId=null;
                    //System.out.println(doctors);
                    for (Doctor v : doctors) {
                        if (name.equals(v.getName()) && password.equals(v.getPassword())&& yzm.equals(yzm1)) {
                            doctorId=v.getId();
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                    }
                    if (flag) {
                        System.out.println("登录成功，可以进行如下操作");
                        DoctorController.mainMenu(doctorId);
                    } else {
                        if(!yzm.equals(yzm1)){
                            System.out.println("验证码错误");
                        }else{
                            System.out.println("用户名或密码错误");
                        }
                        System.out.println("请输入重新输入");

                    }
                }//登录
                break;
                case 2:
                    System.out.println("注册");
                    DoctorOfPetService.doctorAdd();//注册本质还是添加吧
                    System.out.println("注册成功！返回医生菜单");

                break;
                case 3:
                    loop=false;
                    System.out.println("退出");
            }
        }while (loop);
    }
}
