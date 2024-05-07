package controller;

import data.Admin;
import data.Message;
import data.User;
import service.ControllerService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminController {

    public static void message() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("================以下是需要处理的信息================");
        for(Message v:ControllerService.messages){
            System.out.println(v);
        }
        if(ControllerService.messages.size()!=0){
            System.out.print("请输入已读的id(输入All全部已读):");
            String delId=in.next();
            if("All".equals(delId)){
                ControllerService.messages.removeAll(ControllerService.messages);
                ControllerService.messageId=0;
            }else{
                ControllerService.messages.remove(Integer.parseInt(delId)-1);
            }
        }else{
            System.out.println("没有要处理的消息！！！");
        }
        ControllerService.messagesChun(ControllerService.ss1+"src\\csv\\message.csv");
    }




    public static void mainMenu() throws IOException {
        boolean loop = true;
            ControllerService controllerService1 = Controller.controllerService;
            do{

                Scanner in = new Scanner(System.in);
                System.out.println(" ---------------宠物医生助手系统--------------");
                System.out.println(" ---------------6、用户数据管理--------------");
                System.out.println(" ---------------7、医生数据管理--------------");
                System.out.println(" ---------------8、宠物信息管理--------------");
                System.out.println(" ---------------9、消息处理--------------");
                System.out.println(" ---------------10、助手信息维护--------------");
                System.out.println(" ---------------11、退出--------------");
                System.out.println("请选择（6-10）");
                int key=in.nextInt();
                switch (key){
                    case 6:
                        UserManagement.mainMenu();
                        //System.out.println("用户数据管理");
                        break;
                    case 7:
                        DoctorManagement.mainMenu();
                        //System.out.println("医生数据管理");
                        //Assistant.mainMenu();
                        break;
                    case 8:
                        PatManagement.mainMenu();
                        //System.out.println("宠物信息管理");
                        break;
                    case 9:
                        AdminController.message();
                        //System.out.println("消息处理");
                        break;
                    case 10:
                        AdminManagement.mainMenu();
                        System.out.println("助手信息维护");
                        break;
                    case 11:
                        loop = false;
                }
            }while(loop);







    }
}
