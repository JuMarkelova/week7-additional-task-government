package cy.markelova.government.entity;

import java.util.ArrayList;
import java.util.List;

public class Government {

    private static Government instance;
    private String name;
    private List<Region> regions;
    private List<City> cities;
    private List<District> districts;

    private Government() {
        this.name = "Russia";
        this.regions = new ArrayList<>();
        this.cities = new ArrayList<>();
        this.districts = new ArrayList<>();
        regions.add(new Region("Moscow region"));
        regions.add(new Region("Novosibirsk region"));
        cities.add(new City("Moscow"));
        cities.add(new City("Novosibirsk"));
        districts.add(new District("Moscow district"));
        districts.add(new District("Novosibirsk district"));
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

    public void setName(String name) {
        this.name = name;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
}
