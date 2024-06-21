package cy.markelova.government.entity;

import static cy.markelova.government.util.Helper.generateRandomSequence;
//TODO resolve the problem of linking citizens and the state
public class Citizen {

    static int count = 1;
    final int ID;
    String firstName;

    String lastName;
    int age;
    Government government;

    public Citizen(Government government) {
        this.ID = count++;
        this.government = government;
        this.age = (int) (Math.random() * 95);
        this.firstName = generateRandomSequence(5, 10);
        this.lastName = generateRandomSequence(5, 10);
    }

//    public Citizen(Government government, boolean isAddedToGovernment) {
//        this.ID = count++;
//        this.government = government;
//        this.age = (int) (Math.random() * 95);
//        this.firstName = generateRandomSequence(5, 10);
//        this.lastName = generateRandomSequence(5, 10);
//        Government.getInstance().setCitizens(this);
//    }

    public static int getCount() {
        return count;
    }

    public int getID() {
        return ID;
    }

    public Government getGovernment() {
        return government;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Citizen firstName: %-12s lastName: %-12s age: %-4d government: %s",
                firstName, lastName, age, government.getName());
    }
}