package cy.markelova.government.entity;

import java.util.ArrayList;
import java.util.List;

import static cy.markelova.government.util.StringHelper.generateRandomString;

public class Region {

    private String name;
    // area is in km^2
    private int area;
    private List<City> cities;
    private City regionalCenter;

    public Region(String name, int area) {
        this.name = name;
        this.cities = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.cities.add(new City(generateRandomString(5, 10)));
        }
        this.area = area;
        this.regionalCenter = cities.get((int) (Math.random() * cities.size()));
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public City getRegionalCenter() {
        return regionalCenter;
    }

    public void setRegionalCenter(City regionalCenter) {
        this.regionalCenter = regionalCenter;
    }
}