package cy.markelova.government.entity;

import java.util.ArrayList;
import java.util.List;

import static cy.markelova.government.util.StringHelper.generateRandomString;

public class City {

    private String name;
    private List<District> districts;

    public City(String name) {
        this.name = name;
        this.districts = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.districts.add(new District(generateRandomString(10, 15)));
        }
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

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
}