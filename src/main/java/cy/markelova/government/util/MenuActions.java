package cy.markelova.government.util;

import cy.markelova.government.entity.Government;
import cy.markelova.government.entity.Region;

public class MenuActions {

    public static void printCapital() {
        System.out.printf("The capital of the state is %s.\n", Government.getInstance().getCapital().getName());
    }

    public static void printCountRegions() {
        System.out.printf("There are %d regions in the state.\n", Government.getInstance().countRegions());
    }

    public static void printGovernmentArea() {
        System.out.printf("The area of the state is %d km^2\n", Government.getInstance().countGovernmentsArea());
    }

    public static void printListOfRegionalCenters() {
        System.out.println("There is a list of regional centers of the state: ");
        for (Region region : Government.getInstance().getRegions()) {
            System.out.println(" -" + region.getRegionalCenter().getName());
        }
    }
}
