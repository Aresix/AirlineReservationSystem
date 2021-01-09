package myClass;

public class Airport {
    private String airportID;
    private String name;
    private City city;

    public Airport(String airportID, String name, City city) {
        this.airportID = airportID;
        this.name = name;
        this.city = city;
    }

    public void getAirport(){
        System.out.println(">>>机场： "+name+"\t所属地： "+city.getCountry()
                +" "+city.getName()+"\t编号： "+airportID+"<<<");
    }

    public String getAirportID() {
        return airportID;
    }

    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
