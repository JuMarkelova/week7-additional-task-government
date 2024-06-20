package cy.markelova.government.entity;

import java.util.ArrayList;
import java.util.List;

import static cy.markelova.government.util.Helper.generateRandomSequence;


public class Region {

    private String name;
    private List<City> cities;

    public Region(String name) {
        this.name = name;
        this.cities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            this.cities.add(new City(generateRandomSequence(10, 15)));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return this.cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}