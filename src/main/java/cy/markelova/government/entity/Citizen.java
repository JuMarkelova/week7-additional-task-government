package cy.markelova.government.entity;

import static cy.markelova.government.util.StringHelper.generateRandomString;

public class Citizen {

    private int id = 0;
    String firstName;
    String lastName;
    int age;
    Government government;
    District district;

    public Citizen(Government government, District district) {
        this.id += 1;
        this.government = government;
        this.age = (int) (Math.random() * 95);
        this.firstName = generateRandomString(5, 10);
        this.lastName = generateRandomString(5, 10);
        this.government.setCitizens(this);
        this.district = district;
    }

    public int getID() {
        return id;
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