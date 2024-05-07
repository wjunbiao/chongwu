package data;

import java.util.ArrayList;

public class User {
    //id,name,password,ListOfPetid
    private String id;
    private String name;
    private String password;
    private ArrayList<String> listOfPetid = new ArrayList<>();

    public User(String id, String name, String password, ArrayList<String> listOfPetid) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.listOfPetid = listOfPetid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
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
        return id +","+name +","+ password+","+newSs ;
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

    public ArrayList<String> getListOfPetid() {
        return listOfPetid;
    }

    public void setListOfPetid(ArrayList<String> listOfPetid) {
        this.listOfPetid = listOfPetid;
    }
    public void setListOfPetidAdd(String listOfPetid) {
        this.listOfPetid.add(listOfPetid);
    }
}
