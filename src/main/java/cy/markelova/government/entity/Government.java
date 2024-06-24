package cy.markelova.government.entity;

import java.util.ArrayList;
import java.util.List;

public class Government {

    private static Government instance;
    private String name;
    private City capital;
    private List<Region> regions;
    private List<City> cities;
    private List<District> districts;
    private List<Citizen> citizens;

    private Government() {
        this.name = "Russia";
        this.regions = new ArrayList<>();
        this.cities = new ArrayList<>();
        this.districts = new ArrayList<>();
        this.citizens = new ArrayList<>();
        new Region("Central", 650205, this);
        new Region("Siberian", 4361727, this);
        new Region("Ural", 1818497, this);
        this.capital = this.cities.getFirst();
    }

    public static Government getInstance() {
        if (instance == null) {
            instance = new Government();
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

    public List<Citizen> getCitizens() {
        return this.citizens;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegions(Region region) {
        this.regions.add(region);
    }

    public void setCities(City city) {
        this.cities.add(city);
    }

    public void setDistricts(District district) {
        this.districts.add(district);
    }

    public void setCitizens(Citizen citizen) {
        this.citizens.add(citizen);
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
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

    public int countAverageAgeCitizens() {
        int sum = 0;
        for (Citizen citizen : citizens) {
            sum += citizen.getAge();
        }
        return sum / citizens.size();
    }
}