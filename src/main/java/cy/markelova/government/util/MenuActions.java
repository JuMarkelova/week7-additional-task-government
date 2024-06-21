package cy.markelova.government.util;

import cy.markelova.government.entity.Citizen;
import cy.markelova.government.entity.Government;
import cy.markelova.government.entity.Region;

import java.util.Scanner;

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
    public static void printAverageAgeCitizens() {
        System.out.printf("An average age of citizens is %d years.\n", Government.getInstance().countAverageAgeCitizens());
    }

    public static String inputFirstLetterOfCitizenName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input first letter of a name to find citizens: ");
        return (scanner.nextLine());
    }

    public static void printListCitizensNameStartsWithCertainLetter(String letter) {
        System.out.printf("There are a list of citizens name starts with '%s':\n", letter);
        for (Citizen citizen : Government.getInstance().getCitizens()) {
            if (citizen.getFirstName().startsWith(String.valueOf(letter))) {
                System.out.println(" -" + citizen.toString());
            }
        }
    }

    public static int inputNumberOfLettersOfCitizenName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of letters of a name to find citizens: ");
        return (scanner.nextInt());
    }

    public static void printListCitizensThisLengthOfName(int lengthOfName) {
        System.out.printf("There are a list of citizens whose consists of %d letters:\n", lengthOfName);
        for (Citizen citizen : Government.getInstance().getCitizens()) {
            if (citizen.getFirstName().length() == lengthOfName) {
                System.out.println(" -" + citizen.toString());
            }
        }
    }
}
