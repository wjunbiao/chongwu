package controller;

import data.Doctor;
import data.User;
import service.ControllerService;
import service.DoctorOfPetService;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Scanner;

public class DoctorManagement {



    public static void mainMenu() {
        boolean loop = true;
        do {

            Scanner in = new Scanner(System.in);
            System.out.println(" ---------------医生数据管理--------------");
            System.out.println(" ---------------1、医生数据遍历--------------");
            System.out.println(" ---------------2、医生数据更新--------------");
            System.out.println(" ---------------3、医生数据删除--------------");
            System.out.println(" ---------------4、查找医生信息--------------");
            System.out.println(" ---------------5、退出--------------");
            System.out.println("请选择（1-5）");
            int key = in.nextInt();
            switch (key) {
                case 1:
                    DoctorOfPetService.doctorErgodic();
                    // System.out.println("用户数据遍历");
                    break;
                case 2:
                    System.out.print("请输入要修改的id:");
                    String updateId = in.next();
                    DoctorOfPetService.doctorUpdate(updateId);
                    // System.out.println("用户数据更新");
                    break;
                case 3:
                    System.out.print("请输入要删除的id:");
                    String delId = in.next();
                    DoctorOfPetService.doctorDel(delId);
                    //System.out.println("用户数据删除");
                    break;
                case 4:
                    System.out.print("请输入要查找的id:");
                    String findId = in.next();
                    Doctor newDoctor=DoctorOfPetService.doctorFind(findId);
                    if(newDoctor!=null){
                        System.out.println(newDoctor);
                        System.out.println("===============查找成功===============");
                    }else{
                        System.out.println("===============查找失败，未找到要删除的id===============");
                    }
                    //System.out.println("查找用户信息");
                    break;
                case 5:
                    loop = false;
            }


        } while (loop);
    }
}

