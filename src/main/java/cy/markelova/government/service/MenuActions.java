package cy.markelova.government.service;

import cy.markelova.government.entity.Citizen;
import cy.markelova.government.entity.Government;
import cy.markelova.government.entity.Region;

import java.util.Scanner;

public class MenuActions {

    private static final Government GOVERNMENT = Government.getInstance();
    static Scanner scanner = new Scanner(System.in);

    public void runMenu() {
        showInstructions();
        boolean isRun = true;
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
                    printListOfRegionalCenters();
                    break;
                }
                case "5": {
                    printAverageAgeCitizens();
                    break;
                }
                case "6": {
                    printListCitizensNameStartsWithCertainLetter(inputFirstLetterOfCitizenName());
                    break;
                }
                case "7": {
                    printListCitizensThisLengthOfName(inputNumberOfLettersOfCitizenName());
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

    private void showInstructions() {
        String instruction = """
                Select an action (write a number or exit):
                0 - Show instructions
                1 - The capital of the state
                2 - Number of regions
                3 - Area of the state
                4 - List of regional centers
                5 - An average age of citizens
                6 - List of citizens whose name starts with a certain letter
                7 - List of citizens whose name consists of a certain number of letter
                exit - exit
                """;
        System.out.println(instruction);
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

    private void printListOfRegionalCenters() {
        System.out.println("There is a list of regional centers of the state: ");
        for (Region region : GOVERNMENT.getRegions()) {
            System.out.println(" -" + region.getRegionalCenter().getName());
        }
    }

    private void printAverageAgeCitizens() {
        System.out.printf("An average age of citizens is %d years.\n",
                GOVERNMENT.countAverageAgeCitizens());
    }

    private String inputFirstLetterOfCitizenName() {
        System.out.println("Input first letter of a name to find citizens: ");
        return (scanner.nextLine());
    }

    private void printListCitizensNameStartsWithCertainLetter(String letter) {
        System.out.printf("There are a list of citizens name starts with '%s':\n", letter);
        for (Citizen citizen : GOVERNMENT.getCitizens()) {
            if (citizen.getFirstName().startsWith(letter)) {
                System.out.println(" -" + citizen);
            }
        }
    }

    private String inputNumberOfLettersOfCitizenName() {
        System.out.println("Input number of letters of a name to find citizens: ");
        return scanner.nextLine();
    }

    private void printListCitizensThisLengthOfName(String lengthOfName) {
        int length = Integer.parseInt(lengthOfName);
        System.out.printf("There are a list of citizens whose name consists of %d letters:\n", length);
        for (Citizen citizen : GOVERNMENT.getCitizens()) {
            if (citizen.getFirstName().length() == length) {
                System.out.println(" -" + citizen);
            }
        }
    }
}