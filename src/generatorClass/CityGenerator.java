package generatorClass;

import myClass.City;

import java.util.ArrayList;

public class CityGenerator {
    public static ArrayList<City> initCity() {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(new City("上海", "中国"));
        cities.add(new City("北京", "中国"));
        cities.add(new City("广州", "中国"));
        cities.add(new City("江苏", "中国"));
        cities.add(new City("海南", "中国"));
//        for (City c : cities) c.getCity();
        return cities;
    }
}
