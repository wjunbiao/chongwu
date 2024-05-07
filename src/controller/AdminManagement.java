package controller;

import data.Admin;
import data.Doctor;
import service.AdminService;
import service.DoctorOfPetService;

import java.util.Scanner;

public class AdminManagement {
    public static void mainMenu() {
        boolean loop = true;
        do {

            Scanner in = new Scanner(System.in);
            System.out.println(" ---------------助手信息维护--------------");
            System.out.println(" ---------------1、助手数据遍历--------------");
            System.out.println(" ---------------2、助手数据添加--------------");
            System.out.println(" ---------------3、助手数据更新--------------");
            System.out.println(" ---------------4、助手数据删除--------------");
            System.out.println(" ---------------5、查找助手信息--------------");
            System.out.println(" ---------------6、退出--------------");
            System.out.println("请选择（1-5）");
            int key = in.nextInt();
            switch (key) {
                case 1:
                    AdminService.adminErgodic();
                    // System.out.println("用户数据遍历");
                    break;

                case 2:
                    AdminService.adminAdd();
                    // System.out.println("用户数据添加");
                    break;
                case 3:
                    System.out.print("请输入要修改的id:");
                    String updateId = in.next();
                    AdminService.adminUpdate(updateId);
                    // System.out.println("用户数据更新");
                    break;
                case 4:
                    System.out.print("请输入要删除的id:");
                    String delId = in.next();
                    AdminService.adminDel(delId);
                    //System.out.println("用户数据删除");
                    break;
                case 5:
                    System.out.print("请输入要查找的id:");
                    String findId = in.next();
                    Admin newAdmin=AdminService.adminFind(findId);
                    if(newAdmin!=null){
                        System.out.println(newAdmin);
                        System.out.println("===============查找成功===============");
                    }else{
                        System.out.println("===============查找失败，未找到要删除的id===============");
                    }
                    //System.out.println("查找用户信息");
                    break;
                case 6:
                    loop = false;
            }

        } while (loop);
    }
}
