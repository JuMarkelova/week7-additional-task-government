package cy.markelova.government.entity;

public class Government {

    private Government() {
    }

    private static class SingletonHelper {
        private static final Government INSTANCE = new Government();
    }

    public static Government getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
