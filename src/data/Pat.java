package data;

public abstract class Pat {
    private String id;
    private String name;
    private String health;
    private String masterid;//宠物id

    public Pat(String id, String name, String health, String masterid) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.masterid = masterid;
    }

    @Override
    public String toString() {
        return
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", health='" + health + '\'' +
                ", masterid='" + masterid + '\''
                ;
    }
    public String chunToString() {
        return id +","+name +","+ health+","+masterid ;
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

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getMasterid() {
        return masterid;
    }

    public void setMasterid(String masterid) {
        this.masterid = masterid;
    }
}
