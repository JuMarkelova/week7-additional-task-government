package cy.markelova.government.entity;

import static cy.markelova.government.util.Helper.generateRandomSequence;

public class Citizen {

    static int count = 0;
    final int ID;
    String firstName;
    String lastName;
    int age;
    Government government;

    public Citizen() {
        this.ID = count++;
        this.government = Government.getInstance();
        this.age = (int) (Math.random() * 95);
        this.firstName = generateRandomSequence(5, 10);
        this.lastName = generateRandomSequence(5, 10);
    }

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
}