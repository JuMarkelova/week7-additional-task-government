package cy.markelova.government._main;

import cy.markelova.government.entity.Government;
import cy.markelova.government.service.MenuActions;

public class _Main {

    public static void main(String[] args) {

        Government government = Government.getInstance();
        MenuActions menu = new MenuActions();
        menu.runMenu();
    }
}