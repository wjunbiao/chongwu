package controller;

import data.User;
import service.AdminService;
import service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserAdmin {
    public static void Admin(ArrayList<User> users) throws IOException {
        Scanner in = new Scanner(System.in);
        boolean loop=true;
        do {
            System.out.println("---------------我是用户----------");
            System.out.println(" ---------------1、登录--------------");
            System.out.println(" ---------------2、注册--------------");
            System.out.println(" ---------------3、退出--------------");
            System.out.println("请选择（1-3）");
            int key1 = in.nextInt();
            switch (key1) {
                case 1: {
                    String name;

                    System.out.print("请输入用户名：(默认用户名为老张)");
                    name = in.nextLine();
                    if("".equals(name)){
                        name="老张";
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
                    String id="-1";
                    //System.out.println(doctors);
                    for (User v : users) {
                        if (name.equals(v.getName()) && password.equals(v.getPassword())&& yzm.equals(yzm1)) {
                            flag = true;
                            id=v.getId();
                            break;
                        } else {

                            flag = false;
                        }
                    }
                    if (flag) {
                        System.out.println("登录成功，可以进行如下操作");
                        UserController.mainMenu(id);
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
                    UserService.userAdd();
                System.out.println("注册成功！返回用户菜单");
                break;
                case 3:
                    loop=false;
                    System.out.println("退出");
            }
        }while (loop);
    }
}
