package cy.markelova.government.entity;

import java.util.ArrayList;
import java.util.List;

public class Government {

    private static Government instance;
    private String name;
    private City capital;
    private static List<Region> regions;
    private static List<City> cities;
    private static List<District> districts;
    private static List<Citizen> citizens;

    private Government() {
        this.name = "Russia";
        regions = new ArrayList<>();
        cities = new ArrayList<>();
        districts = new ArrayList<>();
        citizens = new ArrayList<>();
        regions.add(new Region("Central", 650205));
        regions.add(new Region("Siberian", 4361727));
        regions.add(new Region("Ural", 1818497));
        for (Region region : regions) {
            cities.addAll(region.getCities());
        }
        for (City city : cities) {
            districts.addAll(city.getDistricts());
        }
        this.capital = cities.getFirst();
    }

    public static Government getInstance() {
        if (instance == null) {
            instance = new Government();
            generateCitizens(citizens, districts);
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public List<City> getCities() {
        return cities;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegions(Region regions) {
        regions = regions;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public static void generateCitizens(List<Citizen> citizens, List<District> districts) {
        for (District district : districts) {
            for (int i = 0; i < 10; i++) {
                Citizen citizen = new Citizen(instance);
                citizens.add(citizen);
                district.setCitizens(citizen);
            }
        }
    }

    public int countRegions() {
        return regions.size();
    }

    public int countGovernmentsArea() {
        int sumOfRegionsArea = 0;
        for (Region region : regions) {
            sumOfRegionsArea += region.getArea();
        }
        return sumOfRegionsArea;
    }

}
