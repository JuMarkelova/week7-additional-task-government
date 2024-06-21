package cy.markelova.government.entity;

import java.util.ArrayList;
import java.util.List;

public class District {

    private String name;
    private List<Citizen> citizens = new ArrayList<>();

    public District(String name) {
        this.name = name;
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
}