package cy.markelova.government.service;

import cy.markelova.government.entity.Citizen;
import cy.markelova.government.entity.Government;
import cy.markelova.government.entity.Region;

import java.util.Scanner;

import static cy.markelova.government.util.MenuMessages.instructionMessage;

public class MenuActions {

    private static final Government GOVERNMENT = Government.getInstance();

    public void runMenu() {
        showInstructions();
        boolean isRun = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (isRun) {
                String userChoice = scanner.nextLine();
                switch (userChoice) {
                    case "0": {
                        showInstructions();
                        break;
                    }
                    case "1": {
                        printCapital();
                        break;
                    }
                    case "2": {
                        printCountRegions();
                        break;
                    }
                    case "3": {
                        printGovernmentArea();
                        break;
                    }
                    case "4": {
                        printRegionalCenters();
                        break;
                    }
                    case "5": {
                        printAverageAgeCitizens();
                        break;
                    }
                    case "6": {
                        printNamesStartsWithLetter(inputFirstLetterName());
                        break;
                    }
                    case "7": {
                        printNamesGivenLength(inputLengthName());
                        break;
                    }
                    case "exit":
                        isRun = false;
                        break;
                    default:
                        System.out.println("There is no such option.");
                }
            }
        }
    }

    private void showInstructions() {
        System.out.println(instructionMessage);
    }

    private void printCapital() {
        System.out.printf("The capital of the state is %s.\n", GOVERNMENT.getCapital().getName());
    }

    private void printCountRegions() {
        System.out.printf("There are %d regions in the state.\n", GOVERNMENT.countRegions());
    }

    private void printGovernmentArea() {
        System.out.printf("The area of the state is %d km^2.\n", GOVERNMENT.countGovernmentsArea());
    }

    private void printRegionalCenters() {
        System.out.println("There is a list of regional centers of the state: ");
        for (Region region : GOVERNMENT.getRegions()) {
            System.out.println(" -" + region.getRegionalCenter().getName());
        }
    }

    private void printAverageAgeCitizens() {
        System.out.printf("An average age of citizens is %d years.\n",
                GOVERNMENT.countAverageAgeCitizens());
    }

    private String inputFirstLetterName() {
        System.out.println("Input first letter of a name to find citizens: ");
        try (Scanner scanner = new Scanner(System.in)) {
            return (scanner.nextLine());
        }
    }

    private void printNamesStartsWithLetter(String letter) {
        System.out.printf("There are a list of citizens name starts with '%s':\n", letter);
        for (Citizen citizen : GOVERNMENT.getCitizens()) {
            if (citizen.getFirstName().startsWith(letter)) {
                System.out.println(" -" + citizen);
            }
        }
    }

    private String inputLengthName() {
        System.out.println("Input number of letters of a name to find citizens: ");
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }

    private void printNamesGivenLength(String lengthOfName) {
        int length = Integer.parseInt(lengthOfName);
        System.out.printf("There are a list of citizens whose name consists of %d letters:\n", length);
        for (Citizen citizen : GOVERNMENT.getCitizens()) {
            if (citizen.getFirstName().length() == length) {
                System.out.println(" -" + citizen);
            }
        }
    }
}