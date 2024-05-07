package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Admin {
//    public Admin() {
//        this.loadData("C:\\Users\\86187\\Desktop\\shuju\\assistant.csv", 2);
//    }
//
//    public boolean loadData(String f,int n) {//n：读几个数据。csv是文本文件
//        FileReader fp = null;
//        BufferedReader bfp = null;//加缓冲区
//        try {
//            fp=new FileReader(f);
//            bfp = new BufferedReader(fp);
//            String s;
//            s=bfp.readLine();
//            while(s!=null){//如果不知道几行
//            //for(int i =0;i<n;i++) {
//                s=bfp.readLine();
//                String [] ss = new String[5];
//                ss=s.split(",");
//                int id = Integer.parseInt(ss[0]);
//                int age = Integer.parseInt(ss[2]);
//                double income = Double.parseDouble(ss[3]);
//                int spending = Integer.parseInt(ss[4]);
//                users.add(new Customer(id,ss[1],age,income,spending));
//
//            }
//            bfp.close();
//            fp.close();
//            return true;
//        }catch(IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
private String id;
private String name;
private String password;

    public Admin(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String chunToString() {
        return id +","+name +","+ password ;
    }
}
