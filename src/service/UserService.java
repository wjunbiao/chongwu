package service;

import data.Bird;
import data.Dog;
import data.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    Scanner scanner = new Scanner(System.in);

    public static void userAdd(){
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

        ArrayList<String> lp=new ArrayList<>();
        System.out.print("请输入您的宠物id：");
        String s = in.next();
        String ss[] =null;
        ss=s.split(",");

        for(int i =0;i< ss.length;i++)
        {
            for (Dog v : ControllerService.dogs) {
                if(v.getId().equals(ss[i])){
                    v.setMasterid(id);
                    break;
                }

            }
            for (Bird v : ControllerService.birds) {
                if(v.getId().equals(ss[i])){
                    v.setMasterid(id);
                    break;
                }
            }
            System.out.println(ss[i]);
            if(ss[i]!=null){

                lp.add(ss[i]);
            }
        }
        System.out.println(lp);
        ControllerService.users.add(new User(id, name, password1,lp));

    }
    public static void userErgodic() {//遍历
        for (User v : ControllerService.users) {
            System.out.println(v);
        }
    }
    public static boolean userUpdate(String id) {//更新
        Scanner scanner = new Scanner(System.in);
        User newUser = null;
        System.out.println("===============修改客户===============");
        for (User v : ControllerService.users) {
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
    public static boolean userDel(String id){//删除
        for(User v:ControllerService.users) {
            if(v.getId().equals(id)) {
                ControllerService.users.remove(v);
                System.out.println("===============删除成功===============");
                return true;
            }
        }
        System.out.println("===============删除失败，未找到要删除的id===============");
        return false;
    }
    public static User userFind(String id){//查找
        for(User v:ControllerService.users) {
            if(v.getId().equals(id)) {
                return v;
            }
        }

        return null;
    }

}
