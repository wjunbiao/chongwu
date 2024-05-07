package controller;

import data.Bird;
import data.Dog;
import data.Pat;
import data.User;
import service.ControllerService;
import service.PatService;

import java.util.ArrayList;
import java.util.Scanner;

public class PatManagement {

    public static void mainMenu() {
        boolean loop =true;
        Scanner in = new Scanner(System.in);
        do{
            System.out.println(" ---------------宠物数据管理--------------");
            System.out.println(" ---------------1、增加宠物--------------");
            System.out.println(" ---------------2、宠物数据遍历--------------");
            System.out.println(" ---------------3、宠物数据更新--------------");
            System.out.println(" ---------------4、宠物数据删除--------------");
            System.out.println(" ---------------5、查找宠物信息--------------");
            System.out.println(" ---------------6、退出--------------");
            System.out.println("请选择（1-5）");
            int key = in.nextInt();
            switch (key) {
                case 1:
                    PatService.patAdd();
                    break;
                case 2:
                    PatService.patErgodic();
                    break;
                case 3:
                    System.out.print("请输入要修改的id:");
                    String updateId = in.next();
                    PatService.patUpdate(updateId);
                    // System.out.println("用户数据更新");

                    break;
                case 4:
                    System.out.print("请输入要删除的id:");
                    String delId = in.next();
                    PatService.patDel(delId);
                    //System.out.println("用户数据删除");

                    break;
                case 5:
                    System.out.print("请输入要查找的id:");
                    String findId = in.next();
                    Pat newPat=PatService.patFind(findId);

                    if(newPat!=null){
                        System.out.println(newPat);
                        System.out.println("===============查找成功===============");
                    }else{
                        System.out.println("===============查找失败，未找到要删除的id===============");
                    }
                    //System.out.println("查找用户信息");

                    break;
                case 6:
                    loop=false;
            }
        }while(loop);
    }
}
