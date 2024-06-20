package cy.markelova.government._main;

import cy.markelova.government.entity.Citizen;
import cy.markelova.government.entity.City;
import cy.markelova.government.entity.Government;
import cy.markelova.government.entity.Region;

public class _Main {

    public static void main(String[] args) {

        Government government = Government.getInstance();
        System.out.println(government.getName());

        Citizen one = new Citizen();
        Citizen two = new Citizen();
        Citizen three = new Citizen();
        Citizen four = new Citizen();
        System.out.println(Citizen.getCount());

        for (Region region : government.getRegions()) {
            System.out.println(region.getName());
        }
        for (City city : government.getCities()) {
            System.out.println(city.getName());
        }
    }
}
