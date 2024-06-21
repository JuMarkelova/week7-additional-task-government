package cy.markelova.government._main;

import cy.markelova.government.entity.Citizen;
import cy.markelova.government.entity.Government;

public class _Main {

    public static void main(String[] args) {

        Government government = Government.getInstance();
        System.out.println(government.getName());


        //  MenuActions.printListCitizensNameStartsWithCertainLetter(MenuActions.inputFirstLetterOfCitizenName());
        Citizen one = new Citizen(government);
//        System.out.println(one.getGovernment().getName());
        System.out.println(one);
//        MenuActions.printCapital();
//        MenuActions.printCountRegions();
//        MenuActions.printGovernmentArea();
//        MenuActions.printListOfRegionalCenters();
//        MenuActions.printAverageAgeCitizens();
      //  MenuActions.printListCitizensThisLengthOfName(MenuActions.inputNumberOfLettersOfCitizenName());



//        Citizen two = new Citizen(government);
//        Citizen three = new Citizen(government);
//        Citizen four = new Citizen(government);

        System.out.println(government.getCitizens().size()); // 271

//        for (Region region : government.getRegions()) {
//            System.out.println(region.getName());
//        }
//        for (City city : government.getCities()) {
//            System.out.println(city.getName());
//        }
//
//        System.out.println(government.getCapital().getName());
    }
}
