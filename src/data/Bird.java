package data;

public class Bird extends Pat{
    private String sex;

    public Bird(String id, String name, String health, String masterid, String sex) {
        super(id, name, health, masterid);
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Bird{" +super.toString()+
                "sex='" + sex + '\'' +
                '}';
    }
    public String chunToString() {
        return super.chunToString()+","+sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
