package data;

public class Dog extends Pat{
    private String strain;//品种
    private String isNeutering;//是否绝育

    public Dog(String id, String name, String health, String masterid, String strain, String isNeutering) {
        super(id, name, health, masterid);
        this.strain = strain;
        this.isNeutering = isNeutering;
    }

    @Override
    public String toString() {
        return "Dog{" +super.toString()+
                "strain='" + strain + '\'' +
                ", isNeutering='" + isNeutering + '\'' +
                '}';
    }
    public String chunToString() {
        return super.chunToString()+","+strain+","+isNeutering;
    }
    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public String getIsNeutering() {
        return isNeutering;
    }

    public void setIsNeutering(String isNeutering) {
        this.isNeutering = isNeutering;
    }
}
