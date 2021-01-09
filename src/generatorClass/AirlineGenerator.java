package generatorClass;

import AirlineInstance.ChunQiuAirline;
import AirlineInstance.DongFangAirline;
import AirlineInstance.JiXiangAirline;
import AirlineInstance.NanFangAirline;
import myClass.Airline;

import java.util.ArrayList;

public class AirlineGenerator {
    public static ArrayList<Airline> initAirline() {
        ArrayList<Airline> airlines = new ArrayList<Airline>();
        airlines.add(new ChunQiuAirline());
        airlines.add(new DongFangAirline());
        airlines.add(new JiXiangAirline());
        airlines.add(new NanFangAirline());
//        for (Airline airline : airlines) airline.getAirline();
        return airlines;
    }
}
