package service;

import data.Admin;
import data.User;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminService {

    public static  void adminAdd(){
        Scanner in = new Scanner(System.in);
        System.out.print("请输入id：");
        String id = in.next();
        System.out.print("请输入用户名：");
        String name = in.next();
        String password1 = null;
        while (true) {
            System.out.print("请输入密码：");
            password1 = in.next();
            System.out.println("请再一次输入密码：");
            String password2 = in.next();
            if (password1.equals(password2)) {
                break;
            }
            System.out.print("两次输入的密码不同，请重新输入");
        }
        ControllerService.admins.add(new Admin(id, name, password1));
        System.out.println("=================添加成功！=================");
    }
    public static void adminErgodic() {//遍历
        for (Admin v : ControllerService.admins) {
            System.out.println(v);
        }
    }
    public static boolean adminUpdate(String id) {//更新
        Scanner scanner = new Scanner(System.in);
        Admin newAdmin = null;
        System.out.println("===============修改客户===============");
        for (Admin v : ControllerService.admins) {
            if (v.getId().equals(id)) {
                newAdmin = v;
            }
        }
        if (newAdmin == null) {
            System.out.println("未找到要修改的客户");
            return false;
        }
        System.out.print("id (" + newAdmin.getId() + "):");
        String newId = scanner.nextLine();
        if (!("".equals(newId))) {
            //System.out.println("修改了");
            newAdmin.setId(newId);
        }
        System.out.print("name (" + newAdmin.getName() + "):");
        String newName = scanner.nextLine();
        if (!("".equals(newName))) {
            newAdmin.setName(newName);
        }

        System.out.print("password (" + newAdmin.getPassword() + ")(直接回车是恢复初始密码123456):");
        String newPassword = scanner.nextLine();
        if (!("".equals(newPassword))) {
            newAdmin.setPassword(newPassword);
        } else {
            newAdmin.setPassword("123456");
        }


        System.out.println("===============修改完成===============");
        return true;

    }
    public static boolean adminDel(String id){//删除
        for(Admin v:ControllerService.admins) {
            if(v.getId().equals(id)) {
                ControllerService.admins.remove(v);
                System.out.println("===============删除成功===============");
                return true;
            }
        }
        System.out.println("===============删除失败，未找到要删除的id===============");
        return false;
    }
    public static Admin adminFind(String id){//查找
        for(Admin v:ControllerService.admins) {
            if(v.getId().equals(id)) {
                return v;
            }
        }

        return null;
    }

}
