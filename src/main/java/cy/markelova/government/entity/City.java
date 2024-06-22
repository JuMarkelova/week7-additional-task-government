package cy.markelova.government.entity;

import java.util.ArrayList;
import java.util.List;

import static cy.markelova.government.util.StringHelper.generateRandomString;

public class City {

    private String name;
    private List<District> districts;

    public City(String name, Government government) {
        this.name = name;
        this.districts = new ArrayList<>();
        for (int i = 0; i < Math.random() * 5 + 2; i++) {
            this.districts.add(new District(generateRandomString(5, 15), government));
        }
        government.getCities().add(this);
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