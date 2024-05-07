package service;

import data.*;

import javax.print.Doc;
import java.io.*;
import java.util.ArrayList;

public class ControllerService {
    public static ArrayList<Admin> admins = new ArrayList<>();
    public static ArrayList<Doctor> doctors = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Dog> dogs = new ArrayList<>();
    public static ArrayList<Bird> birds = new ArrayList<>();
    public static int messageId=0;
    public static ArrayList<Message> messages = new ArrayList<>();
    public static String ss1;
    //admins读
    public static boolean adminLoadData(String f) {//n：读几个数据。csv是文本文件
        FileReader fp = null;
        BufferedReader bfp = null;//加缓冲区
        try {
            fp = new FileReader(f);
            bfp = new BufferedReader(fp);
            String s;
            s = bfp.readLine();
            s = bfp.readLine();
            while (s != null) {//如果不知道几行
                //for(int i =0;i<n;i++) {
                String[] ss = new String[3];
                ss = s.split(",");
                Admin admin2 = new Admin(ss[0], ss[1], ss[2]);
                admins.add(admin2);
                //System.out.println(admin2);
                s = bfp.readLine();
            }
            bfp.close();
            fp.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean doctorLoadData(String f) {//n：读几个数据。csv是文本文件
        FileReader fp = null;
        BufferedReader bfp = null;//加缓冲区
        try {
            fp = new FileReader(f);
            bfp = new BufferedReader(fp);
            String s;
            s = bfp.readLine();
            s = bfp.readLine();
            while (s != null) {//如果不知道几行
                //for(int i =0;i<n;i++) {

                String[] ss = new String[10];

                //System.out.println(lp);
                ss = s.split(",");
                ArrayList<String> lp = new ArrayList<>();
                for (int i = 4; i < ss.length; i++) {

                    //System.out.println(ss[i]);
                    //System.out.println(i);
                    if (ss[i] != null) {

                        lp.add(ss[i]);
                    }
                    //System.out.println(lp);
                }
                Doctor doctor2 = new Doctor(ss[0], ss[1], ss[2], ss[3], lp);
                doctors.add(doctor2);
                //System.out.println(admin2);
                s = bfp.readLine();
            }
            bfp.close();
            fp.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean userLoadData(String f) {//n：读几个数据。csv是文本文件
        FileReader fp = null;
        BufferedReader bfp = null;//加缓冲区
        try {
            fp = new FileReader(f);
            bfp = new BufferedReader(fp);
            String s;
            s = bfp.readLine();
            s = bfp.readLine();
            while (s != null) {//如果不知道几行
                //for(int i =0;i<n;i++) {

                String[] ss = new String[10];

                //System.out.println(lp);
                ss = s.split(",");
                ArrayList<String> lp = new ArrayList<>();
                for (int i = 3; i < ss.length; i++) {

                    //System.out.println(ss[i]);
                    //System.out.println(i);
                    if (ss[i] != null) {

                        lp.add(ss[i]);
                    }
                    //System.out.println(lp);
                }
                User user2 = new User(ss[0], ss[1], ss[2], lp);
                users.add(user2);
                //System.out.println(admin2);
                s = bfp.readLine();
            }
            bfp.close();
            fp.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean dogLoadData(String f) {//n：读几个数据。csv是文本文件
        FileReader fp = null;
        BufferedReader bfp = null;//加缓冲区
        try {
            fp = new FileReader(f);
            bfp = new BufferedReader(fp);
            String s;
            s = bfp.readLine();
            s = bfp.readLine();
            while (s != null) {//如果不知道几行
                //for(int i =0;i<n;i++) {

                String[] ss = new String[3];

                ss = s.split(",");
                Dog dog2 = new Dog(ss[0], ss[1], ss[2],ss[3],ss[4],ss[5]);
                dogs.add(dog2);
                //System.out.println(dog2);
                s = bfp.readLine();
            }
            bfp.close();
            fp.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean birdLoadData(String f) {//n：读几个数据。csv是文本文件
        FileReader fp = null;
        BufferedReader bfp = null;//加缓冲区
        try {
            fp = new FileReader(f);
            bfp = new BufferedReader(fp);
            String s;
            s = bfp.readLine();
            s = bfp.readLine();
            while (s != null) {//如果不知道几行
                //for(int i =0;i<n;i++) {

                String[] ss = new String[3];

                ss = s.split(",");
                Bird bird2 = new Bird(ss[0], ss[1], ss[2],ss[3],ss[4]);
                birds.add(bird2);
                //System.out.println(dog2);
                s = bfp.readLine();
            }
            bfp.close();
            fp.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean messageLoadData(String f) {//n：读几个数据。csv是文本文件
        FileReader fp = null;
        BufferedReader bfp = null;//加缓冲区
        try {
            fp = new FileReader(f);
            bfp = new BufferedReader(fp);
            String s;
            s = bfp.readLine();
            s = bfp.readLine();
            while (s != null) {//如果不知道几行
                //for(int i =0;i<n;i++) {
                String[] ss = new String[3];
                ss = s.split(",");
                Message message2 = new Message("-1",ss[1]);
                message2.setId(String.valueOf(++messageId));
                messages.add(message2);
                //System.out.println(message2);
                s = bfp.readLine();
                //System.out.println(s);
            }
            bfp.close();
            fp.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //2、保存数据
    public static boolean messagesChun(String f) throws IOException {
        FileWriter fw = new FileWriter(f);
        BufferedWriter fb = new BufferedWriter(fw);
        Message [] mg = new Message[messages.size()];
        messages.toArray(mg);
        fb.write("id"+",information");
        fb.newLine();
        for(int i=0;i<messages.size();i++) {
            fb.write(mg[i].toString());
            fb.newLine();
        }
        fb.flush();
        fb.close();
        fw.close();

        return true;
    }

    public static boolean adminChun(String f) throws IOException {
        FileWriter fw = new FileWriter(f);
        BufferedWriter fb = new BufferedWriter(fw);
        Admin [] mg = new Admin[admins.size()];
        admins.toArray(mg);
        fb.write("id"+""+",name"+",password");
        fb.newLine();
        for(int i=0;i<admins.size();i++) {
            fb.write(mg[i].chunToString());
            fb.newLine();
        }
        fb.flush();
        fb.close();
        fw.close();
        return true;
    }

    public static boolean doctorChun(String f) throws IOException {
        FileWriter fw = new FileWriter(f);
        BufferedWriter fb = new BufferedWriter(fw);
        Doctor[] mg = new Doctor[doctors.size()];
        doctors.toArray(mg);
        fb.write("id,name,password,pos,ListOfPetid");
        fb.newLine();
        for(int i=0;i<doctors.size();i++) {
            fb.write(mg[i].chunToString());
            fb.newLine();
        }
        fb.flush();
        fb.close();
        fw.close();
        return true;
    }

    public static boolean userChun(String f) throws IOException {
        FileWriter fw = new FileWriter(f);
        BufferedWriter fb = new BufferedWriter(fw);
        User[] mg = new User[users.size()];
        users.toArray(mg);
        fb.write("id,name,password,ListOfPetid");
        fb.newLine();
        for(int i=0;i<users.size();i++) {
            fb.write(mg[i].chunToString());
            fb.newLine();
        }
        fb.flush();
        fb.close();
        fw.close();
        return true;
    }

    public static boolean dogChun(String f) throws IOException {
        FileWriter fw = new FileWriter(f);
        BufferedWriter fb = new BufferedWriter(fw);
        Dog[] mg = new Dog[dogs.size()];
        dogs.toArray(mg);
        fb.write("id,name,health,masterid,strain,isNeutering");
        fb.newLine();
        for(int i=0;i<dogs.size();i++) {
            fb.write(mg[i].chunToString());
            fb.newLine();
        }
        fb.flush();
        fb.close();
        fw.close();
        return true;
    }

    public static boolean birdChun(String f) throws IOException {
        FileWriter fw = new FileWriter(f);
        BufferedWriter fb = new BufferedWriter(fw);
        Bird[] mg = new Bird[birds.size()];
        birds.toArray(mg);
        fb.write("id,name,health,masterid,sex");
        fb.newLine();
        for(int i=0;i<birds.size();i++) {
            fb.write(mg[i].chunToString());
            fb.newLine();
        }
        fb.flush();
        fb.close();
        fw.close();
        return true;
    }



    public static void chunAll() throws IOException {
        adminChun(ss1+"src\\csv\\assistant.csv");
        doctorChun(ss1+"src\\csv\\doctorOfPets.csv");
        userChun(ss1+"src\\csv\\user.csv");
        dogChun(ss1+"src\\csv\\dog.csv");
        birdChun(ss1+"src\\csv\\bird.csv");
    }
    public ControllerService() {
        File file = new File(".");
        //System.out.println(file.getAbsoluteFile());
        String s=file.getAbsolutePath();
        String ss=null;
         ss1=s.substring(0,s.length()-1);
        //System.out.println(ss1);
        this.adminLoadData(ss1+"src\\csv\\assistant.csv");
        this.doctorLoadData(ss1+"src\\csv\\doctorOfPets.csv");
        this.userLoadData(ss1+"src\\csv\\user.csv");
        this.dogLoadData(ss1+"src\\csv\\dog.csv");
        this.birdLoadData(ss1+"src\\csv\\bird.csv");
        this.messageLoadData(ss1+"src\\csv\\message.csv");
    }


    public static void main(String[] args) {
        ControllerService c = new ControllerService();
        //ControllerService.adminLoadData("C:\\Users\\86187\\Desktop\\shuju\\assistant.csv");
        //ControllerService.doctorLoadData("C:\\Users\\86187\\Desktop\\shuju\\doctorOfPets.csv");
//        for(Doctor v :doctors){
//            System.out.println(v);
//        }
        //System.out.println(doctors);
//        Pat pat=dogs.get(0);
//        System.out.println(pat instanceof Bird);
       // System.out.println(messages);

        System.out.println(dogs);
    }
}
