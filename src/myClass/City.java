package myClass;

public class City {
    private String name;
    private String country; // 所属国家

    public City(String name, String country) {
        this.name=name;
        this.country=country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void getCity(){
        System.out.println("当前访问城市：\t国家: "+country+"\t城市:"+name);
    }
}
