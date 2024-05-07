package controller;

import data.Bird;
import data.Doctor;
import data.Message;
import data.Pat;
import service.ControllerService;
import service.DoctorOfPetService;
import service.PatService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DoctorController {
   // private static ControllerService controllerService1 = Controller.controllerService;

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
        System.out.println("请输入pos：");
        String pos = in.next();
        ArrayList<String> lp=new ArrayList<>();
        System.out.println("请输入接受治疗的宠物id：");
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
        ControllerService.doctors.add(new Doctor(id, name, password1,pos,lp));
        System.out.println("=========添加成功========");
    }
    public static void treatment(Pat newPat){
        int cost=-1;
        if (Integer.parseInt(newPat.getHealth())<60){
            int health=Integer.parseInt(newPat.getHealth())+20;
            if(health>40){//40到60之间花费500
                cost=500;
            }else if(health>20){
                cost=1000;
            }else{
                cost=1500;
            }
            newPat.setHealth(String.valueOf(health));
            System.out.println("宠物id为 "+newPat.getId()+"需要治疗,治疗完成后，宠物的健康值是"+newPat.getHealth()+"，共花费"+cost+"元");

        }else {
            System.out.println("宠物id为 "+newPat.getId()+" 宠物的健康值是"+newPat.getHealth()+"很健康不用治疗");
        }

    }
    public static void outPutInformation(String doctorId) throws IOException {
        Scanner in = new Scanner(System.in);
        Doctor newDoctor = DoctorOfPetService.doctorFind(doctorId);

        System.out.print("请输入要出院的宠物id：(目前该医生管理正在入院的宠物有"+
                newDoctor.getListOfPetid()+")");
        String s=in.nextLine();
        ArrayList <String> ls=newDoctor.getListOfPetid();
        for (int i =0;i<ls.size();i++){
            if(s.equals(ls.get(i))){
                ls.remove(i);//因为传的是地址，ls删了doctors里也删了
            }
        }
        //1、发出出院消息
        //2、出院后，医生的治疗宠物id也要减一个
        Message newMessage=new Message("-1",s+"已经出院");

        ControllerService.messageId=ControllerService.messages.size();

        newMessage.setId(String.valueOf(++ControllerService.messageId));
        System.out.println(newMessage);
        ControllerService.messages.add(newMessage);
        ControllerService.messagesChun(ControllerService.ss1+"src\\csv\\message.csv");
        System.out.println("======================发送成功======================");
    }


    public static void mainMenu(String doctorId) throws IOException {
        boolean loop =true;
        do{
        Scanner in = new Scanner(System.in);
        System.out.println("---------------医生主界面(Doctor)--------------");
        System.out.println("---------------1.添加医生信息--------------");
        System.out.println("---------------2.更新医生信息--------------");
        System.out.println("---------------3.查看医生信息--------------");
        System.out.println("---------------4.发出消息--------------");
        System.out.println("---------------5.治疗--------------");
        System.out.println("---------------6.退出--------------");
        System.out.println("请选择（1-4）");
        int key=in.nextInt();
        switch (key){
            case 1:
                DoctorController.add();
                //System.out.println("添加医生信息");
                break;
            case 2:
                DoctorOfPetService.doctorUpdate(doctorId);
                //System.out.println("更新医生信息");
                break;
            case 3:
                Doctor newDoctor1=DoctorOfPetService.doctorFind(doctorId);
                    //已经进来了肯定就能找到id对应的医生信息
                    System.out.println(newDoctor1);
                System.out.println("====================查找成功====================");
                //System.out.println("查看医生信息");
                break;
            case 4:
                DoctorController.outPutInformation(doctorId);
                //System.out.println("发出消息");
                break;
            case 5:
                Doctor newDoctor=DoctorOfPetService.doctorFind(doctorId);
                Object [] s= newDoctor.getListOfPetid().toArray();
                String ss=null;
                for (int i=0;i<s.length;i++){
                    ss=(String)s[i];
                    System.out.println(ss);
                    Pat newPat= PatService.patFind(ss);
                   System.out.println(newPat);
                    DoctorController.treatment(newPat);
                }
                break;
                //System.out.println("治疗");
            case 6:
                loop = false;
        }
        }while(loop);
    }
}
