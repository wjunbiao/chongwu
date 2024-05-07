package controller;

import data.Admin;
import service.AdminService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AssistantAdmin {
    public static String yzm(){
        char [] code = new char[62];
        for ( int i = 0 ;i<10;i++) {
            code[i]=(char)(48+i);
        }
        for(int i =10;i<36;i++) {
            code[i]=(char)(55+i);
        }
        for(int i =36;i<62;i++) {
            code[i]=(char)(61+i);
        }
//        for(int i=0;i<code.length;i++) {
//            System.out.print(code[i]);
//        }
        String ss="";
        ss += code[(int) (Math.random() * 62)];//生成一个[0,62]的数
        ss += code[(int) (Math.random() * 62)];//生成一个[0,62]的数
        ss += code[(int) (Math.random() * 62)];//生成一个[0,62]的数
        ss += code[(int) (Math.random() * 62)];//生成一个[0,62]的数
        return ss;
    }

    public static void Admin(ArrayList<Admin> admins) throws IOException {
        Scanner in = new Scanner(System.in);
        boolean loop=true;
        do {
            System.out.println("---------------我是助手----------");
            System.out.println(" ---------------1、登录--------------");
            System.out.println(" ---------------2、注册--------------");
            System.out.println(" ---------------3、退出--------------");
            System.out.println("请选择（1-3）");
            int key1 = in.nextInt();
            switch (key1) {
                case 1: {
                    String name;

                    System.out.print("请输入用户名：(默认用户名为admin1)");
                    name = in.nextLine();
                    if("".equals(name)){
                        name="admin1";
                    }
                    in.nextLine();
                    String password;

                    System.out.print("请输入密码：(默认密码888888)");
                    password = in.nextLine();
                    if("".equals(password)){
                        password="888888";
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

                    for (Admin v : admins) {
                        if (name.equals(v.getName()) && password.equals(v.getPassword()) && yzm.equals(yzm1)) {
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                    }
                    if (flag) {
                        System.out.println("登录成功，可以进行如下操作");
                        AdminController.mainMenu();
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
                    AdminService.adminAdd();
                System.out.println("注册成功！返回助手菜单");
                break;
                case 3:
                    loop=false;
                    //System.out.println("退出");
            }
        }while (loop);
    }
}
