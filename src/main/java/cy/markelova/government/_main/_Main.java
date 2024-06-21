package cy.markelova.government._main;

import cy.markelova.government.entity.Citizen;
import cy.markelova.government.entity.City;
import cy.markelova.government.entity.Government;
import cy.markelova.government.entity.Region;
import cy.markelova.government.util.MenuActions;

public class _Main {

    public static void main(String[] args) {

        Government government = Government.getInstance();
        System.out.println(government.getName());

        for (Citizen citizen : Government.getInstance().getCitizens()) {
            if (citizen.getFirstName().startsWith(String.valueOf('q'))) {
                System.out.println(" -" + citizen.toString());
            }
        }
        MenuActions.printListCitizensNameStartsWithCertainLetter(MenuActions.inputFirstLetterOfCitizenName());
        Citizen one = new Citizen(government);
        System.out.println(one.getGovernment().getName());
        System.out.println(one.toString());
        MenuActions.printCapital();
        MenuActions.printCountRegions();
        MenuActions.printGovernmentArea();
        MenuActions.printListOfRegionalCenters();
        MenuActions.printAverageAgeCitizens();
        MenuActions.printListCitizensThisLengthOfName(MenuActions.inputNumberOfLettersOfCitizenName());


        System.out.println(Citizen.getCount());

//        Citizen two = new Citizen(government);
//        Citizen three = new Citizen(government);
//        Citizen four = new Citizen(government);
        System.out.println(Citizen.getCount());
        System.out.println(Government.getInstance().getCitizens().size());

        for (Region region : government.getRegions()) {
            System.out.println(region.getName());
        }
        for (City city : government.getCities()) {
            System.out.println(city.getName());
        }

        System.out.println(government.getCapital().getName());
    }
}
