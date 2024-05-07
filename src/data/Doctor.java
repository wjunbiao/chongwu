package data;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Doctor {
    private String id;
    private String name;
    private String password;
    private String pos;
    private ArrayList<String> listOfPetid = new ArrayList<>();

    public Doctor(String id, String name, String password, String pos, ArrayList<String> listOfPetid) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.pos = pos;
        this.listOfPetid = listOfPetid;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", pos='" + pos + '\'' +
                ", listOfPetid=" + listOfPetid +
                '}';
    }
    public String chunToString() {
        String [] s=new String[listOfPetid.size()];
        listOfPetid.toArray(s);
        String ss="";
        for(int i=0;i<s.length;i++){
            ss+=s[i]+",";
        }
        String newSs=ss.substring(0,ss.length()-1);
        return id +","+name +","+ password+","+pos+","+newSs ;
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

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public ArrayList<String> getListOfPetid() {
        return listOfPetid;
    }

    public void setListOfPetid(ArrayList<String> listOfPetid) {
        this.listOfPetid = listOfPetid;
    }
}
