package cy.markelova.government.entity;

import java.util.ArrayList;
import java.util.List;

import static cy.markelova.government.util.DataGenerator.generateRandomString;

public class City {

    private String name;
    private List<District> districts;
    private Region region;

    public City(String name, Government government, Region region) {
        this.name = name;
        this.region = region;
        this.districts = new ArrayList<>();
        for (int i = 0; i < Math.random() * 5 + 2; i++) {
            District district = new District(generateRandomString(5, 15), government, this);
        }
        region.setCities(this);
    }

    public String getName() {
        return name;
    }

    public List<District> getDistricts() {
        return this.districts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistricts(District district) {
        districts.add(district);
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}