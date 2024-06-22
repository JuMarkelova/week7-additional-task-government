package government;

import cy.markelova.government.entity.Citizen;
import cy.markelova.government.entity.District;
import cy.markelova.government.entity.Government;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GovernmentTests {

    @Test
    public void testCreationGovernment() {
        Government government = Government.getInstance();
        Assert.assertEquals(government.getRegions().size(), 3, "Incorrect number of regions");
        Assert.assertTrue(government.getCities().size() >= 3 && government.getCities().size() <= 15,
                "Incorrect number of cities");
        Assert.assertTrue(government.getDistricts().size() >= 6 && government.getDistricts().size() <= 90,
                "Incorrect number of citizens");
        Assert.assertTrue(government.getCitizens().size() >= 60 && government.getCitizens().size() <= 2610,
                "Incorrect number of citizens");
    }

    @Test
    public void testAddingCitizen() {
        Government government = Government.getInstance();
        int countCitizens = government.getCitizens().size();
        District randomDistrict = government.getDistricts().
                get((int) (Math.random() * government.getDistricts().size()));
        Citizen citizen = new Citizen(government, randomDistrict);
        Assert.assertEquals(government.getCitizens().size(), countCitizens + 1,
                "Incorrect number of citizens");
    }
}