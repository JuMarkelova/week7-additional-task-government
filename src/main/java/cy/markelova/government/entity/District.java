package cy.markelova.government.entity;

import java.util.ArrayList;
import java.util.List;

public class District {

    private String name;
    private City city;
    private List<Citizen> citizens;

    public District(String name, Government government, City city) {
        this.name = name;
        this.city = city;
        citizens = new ArrayList<>();
        for (int i = 0; i < Math.random() * 20 + 10; i++) {
            Citizen citizen = new Citizen(government, this);
            this.citizens.add(citizen);
            government.setCitizens(citizen);
        }
        government.getDistricts().add(this);
        city.setDistricts(this);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(Citizen citizen) {
        this.citizens.add(citizen);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}