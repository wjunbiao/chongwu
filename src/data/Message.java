package data;

public class Message {

    private String id;
    private String information;

    public Message(String id, String information) {
        this.id = id;
        this.information = information;
    }

    @Override
    public String toString() {
        return  id+","+information;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
