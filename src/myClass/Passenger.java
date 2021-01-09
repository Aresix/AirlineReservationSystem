package myClass;

public class Passenger {
    private String name;
    private String IDcard;
    private String telephone;

    public Passenger(String name, String IDcard, String telephone) {
        this.name = name;
        this.IDcard = IDcard;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
