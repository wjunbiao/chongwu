package service;

import data.*;

import java.util.Scanner;

public class PatService {
    public static  void patAdd(){
        Scanner in = new Scanner(System.in);
        System.out.println("请选择你要增加的宠物类型 1、狗，2、鸟");
        int kind=in.nextInt();
        System.out.print("请输入id：");
        String id = in.next();
        System.out.print("请输入宠物名：");
        String name = in.next();
        System.out.print("请输入健康值：");
        String health = in.next();
        System.out.print("请输入主人id：");
        String masterid = in.next();
        if(kind==1){
            System.out.print("请输入性别：");
            String strain = in.next();
            System.out.print("请输入是否绝育：");
            String isNeutering = in.next();
            ControllerService.dogs.add(new Dog(id, name, health,masterid,strain,isNeutering));
        }else if(kind ==2){
            System.out.print("请输入性别：");
            String sex = in.next();

            ControllerService.birds.add(new Bird(id, name, health,masterid,sex));
        }else{
            System.out.println("输入错误，退出");
            return;
        }
        for(User v:ControllerService.users){//让用户的宠物加1个
            if(masterid.equals(v.getId())){
                v.setListOfPetidAdd(id);
            }
        }
        System.out.println("=================添加成功！=================");
    }


    public static void patErgodic() {//遍历
        for (Dog v : ControllerService.dogs) {
            System.out.println(v);
        }
        for (Bird v : ControllerService.birds) {
            System.out.println(v);
        }
    }
    public static boolean patUpdate(String id) {//更新
        Scanner scanner = new Scanner(System.in);
        Pat newUser = null;
        System.out.println("===============修改客户===============");
        for (Pat v : ControllerService.dogs) {
            if (v.getId().equals(id)) {
                newUser = v;
            }
        }
        for (Pat v : ControllerService.birds) {
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

        System.out.print("health (" + newUser.getHealth() + "):");
        String newHealth = scanner.nextLine();
        if (!("".equals(newHealth))) {
            newUser.setHealth(newHealth);
        }

        System.out.print("masterid (" + newUser.getMasterid() + "):");
        String newMasterid = scanner.nextLine();
        if (!("".equals(newMasterid))) {
            newUser.setMasterid(newMasterid);
        }
        if(newUser instanceof Dog){
            System.out.print("strain (" + ((Dog) newUser).getStrain() + "):");
            String newStrain = scanner.nextLine();
            if (!("".equals(newStrain))) {
                ((Dog) newUser).setStrain(newStrain);
            }

            System.out.print("isNeutering (" + ((Dog) newUser).getIsNeutering() + "):");
            String newIsNeutering = scanner.nextLine();
            if (!("".equals(newIsNeutering))) {
                ((Dog) newUser).setIsNeutering(newIsNeutering);
            }

        }else if(newUser instanceof Bird){
            System.out.print("sex (" + ((Bird) newUser).getSex() + "):");
            String newSex = scanner.nextLine();
            if (!("".equals(newSex))) {
                ((Bird) newUser).setSex(newSex);
            }
        }else{
            System.out.println("不是宠物，请检查！");
        }

        System.out.println("===============修改完成===============");
        return true;
    }
    public static boolean patDel(String id){//删除
        for(Dog v:ControllerService.dogs) {
            if(v.getId().equals(id)) {
                ControllerService.dogs.remove(v);
                System.out.println("===============删除成功===============");
                return true;
            }
        }

        for(Bird v:ControllerService.birds) {
            if(v.getId().equals(id)) {
                ControllerService.birds.remove(v);
                System.out.println("===============删除成功===============");
                return true;
            }
        }

        System.out.println("===============删除失败，未找到要删除的id===============");
        return false;
    }

    public static Pat patFind(String id){//查找
        for(Dog v: ControllerService.dogs) {
            if(v.getId().equals(id)) {
                //System.out.println(v);

                return v;
            }
        }

        for(Bird v: ControllerService.birds) {
            if(v.getId().equals(id)) {
                //System.out.println(v);

                return v;
            }
        }


        return null;
    }

}
