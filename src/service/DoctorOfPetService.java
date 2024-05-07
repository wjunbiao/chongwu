package service;

import data.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class DoctorOfPetService {
    public static void doctorAdd() {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入id：");
        String id = in.next();
        System.out.print("请输入用户名：");
        String name = in.next();
        String password1 = null;
        while (true) {
            System.out.print("请输入密码：");
            password1 = in.next();
            System.out.print("请再一次输入密码：");
            String password2 = in.next();
            if (password1.equals(password2)) {
                break;
            }
            System.out.println("两次输入的密码不同，请重新输入");
        }
        System.out.print("请输入pos：");
        String pos = in.next();
        ArrayList<String> lp=new ArrayList<>();
        System.out.print("请输入接受治疗的宠物id：");
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
    }

    public static void doctorErgodic() {//遍历
        System.out.println("2334234");
        for (Doctor v : ControllerService.doctors) {
            System.out.println(v);
        }
    }

    public static boolean doctorUpdate(String id) {//更新
        Scanner scanner = new Scanner(System.in);
        Doctor newUser = null;
        System.out.println("===============修改客户===============");
        for (Doctor v : ControllerService.doctors) {
            if (v.getId().equals(id)) {
                newUser = v;
            }
        }
        if (newUser == null) {
            System.out.println("未找到要修改的客户");
            return false;
        }
        System.out.print("id (" + newUser.getId() + "):");
        String newId = scanner.nextLine();
        if (!("".equals(newId))) {
            System.out.println("修改了");
            newUser.setId(newId);
        }
        System.out.print("name (" + newUser.getName() + "):");
        String newName = scanner.nextLine();
        if (!("".equals(newName))) {
            newUser.setName(newName);
        }

        System.out.print("password (" + newUser.getPassword() + ")(直接回车是恢复初始密码123456):");
        String newPassword = scanner.nextLine();
        if (!("".equals(newPassword))) {
            newUser.setPassword(newPassword);
        } else {
            newUser.setPassword("123456");
        }

        System.out.print("宠物列表 (" + newUser.getListOfPetid() + ")(输入宠物列表以逗号分隔):");
        // String newName = scanner.nextLine();
        ArrayList<String> lp = new ArrayList<>();
        String s = scanner.nextLine();
        if(!("".equals(s))){
            String ss[] = null;
            ss = s.split(",");
            for (int i = 0; i < ss.length; i++) {
                if (ss[i] != null) {
                    lp.add(ss[i]);
                }
            }
            if (lp != null) {
                newUser.setListOfPetid(lp);
            }
        }
        System.out.println("===============修改完成===============");
        return true;
    }

    public static boolean doctorDel(String id) {//删除
        for (Doctor v : ControllerService.doctors) {
            if (v.getId().equals(id)) {
                ControllerService.users.remove(v);
                System.out.println("===============删除成功===============");
                return true;
            }
        }
        System.out.println("===============删除失败，未找到要删除的id===============");
        return false;
    }

    public static Doctor doctorFind(String id) {//查找
        for (Doctor v : ControllerService.doctors) {
            if (v.getId().equals(id)) {
                // System.out.println(v);
                return v;
            }
        }

        return null;
    }

}
