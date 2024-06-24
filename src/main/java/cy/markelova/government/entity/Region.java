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
    private Government government;

    public Region(String name, int area, Government government) {
        this.name = name;
        this.cities = new ArrayList<>();
        for (int i = 0; i < Math.random() * 5 + 1; i++) {
            City city = new City(generateRandomString(4, 12), government, this);
            this.cities.add(city);
        }
        this.area = area;
        this.regionalCenter = cities.get((int) (Math.random() * cities.size()));
        government.getRegions().add(this);
        this.government = government;
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

    public void setCities(City city) {
        cities.add(city);
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

    public Government getGovernment() {
        return government;
    }

    public void setGovernment(Government government) {
        this.government = government;
    }
}