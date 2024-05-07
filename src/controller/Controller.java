package controller;

import data.Admin;
import service.ControllerService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private boolean loop=true;
    private int key;
    public static ControllerService controllerService = new ControllerService();
    private ArrayList<Admin> admin2 = new ArrayList<>();
    Scanner in = new Scanner(System.in);
        public void mainMenu() throws IOException {
            do{
            System.out.println(" ---------------宠物医生助手系统--------------");
            System.out.println(" ---------------1、 我是助手--------------");
            System.out.println(" ---------------2、 我是医生--------------");
            System.out.println(" ---------------3、 客户是上帝--------------");
            System.out.println(" ---------------4、 退出--------------");
            System.out.println("请选择（1-4）");
            key=in.nextInt();

            switch (key){
                case 1:
                    AssistantAdmin.Admin(controllerService.admins);
                    //System.out.println("我是助手");
                    break;
                case 2:
                    DoctorAdmin.Admin(controllerService.doctors);
                    //System.out.println("我是医生");
                    break;
                case 3:
                   // System.out.println(controllerService.users);
                    UserAdmin.Admin(controllerService.users);
                    //System.out.println("客户是上帝");
                    break;
                case 4:
                    loop=false;
            }
            }while(loop);
            ControllerService.chunAll();//保存一下
        }
}
