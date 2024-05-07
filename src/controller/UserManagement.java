package controller;

import data.User;
import service.ControllerService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManagement {
    Scanner scanner = new Scanner(System.in);
    public static void mainMenu() {
        boolean loop =true;
        Scanner in = new Scanner(System.in);
        do{
            System.out.println(" ---------------用户数据管理--------------");
            System.out.println(" ---------------1、用户数据遍历--------------");
            System.out.println(" ---------------2、用户数据更新--------------");
            System.out.println(" ---------------3、用户数据删除--------------");
            System.out.println(" ---------------4、查找用户信息--------------");
            System.out.println(" ---------------5、退出--------------");
            System.out.println("请选择（1-5）");
            int key = in.nextInt();
            switch (key) {
                case 1:
                    UserService.userErgodic();
                    // System.out.println("用户数据遍历");

                    break;
                case 2:
                    System.out.print("请输入要修改的id:");
                    String updateId = in.next();
                    UserService.userUpdate(updateId);
                    // System.out.println("用户数据更新");

                    break;
                case 3:
                    System.out.print("请输入要删除的id:");
                    String delId = in.next();
                    UserService.userDel(delId);
                    //System.out.println("用户数据删除");

                    break;
                case 4:
                    System.out.print("请输入要查找的id:");
                    String findId = in.next();
                    User newUser=UserService.userFind(findId);
                    if(newUser!=null){
                        System.out.println(newUser);
                        System.out.println("===============查找成功===============");
                    }else{
                        System.out.println("===============查找失败，未找到要删除的id===============");
                    }
                    //System.out.println("查找用户信息");

                    break;
                case 5:
                    loop=false;
            }
        }while(loop);
    }
}





