package government;

import cy.markelova.government.entity.*;
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
        int countCitizensGovernment = government.getCitizens().size();
        District randomDistrict = government.getDistricts().
                get((int) (Math.random() * government.getDistricts().size()));
        int countCitizensDistrict = randomDistrict.getCitizens().size();

        Citizen citizen = new Citizen(government, randomDistrict);

        Assert.assertEquals(government.getCitizens().size(), countCitizensGovernment + 1,
                "Incorrect number of citizens in the government");
        Assert.assertEquals(randomDistrict.getCitizens().size(), countCitizensDistrict + 1,
                "Incorrect number of citizens in the district");
    }

    @Test
    public void testAddingRegion() {
        Government government = Government.getInstance();
        int countRegions = government.getRegions().size();

        Region region = new Region("testRegion", 100000, government);

        Assert.assertEquals(government.getRegions().size(), countRegions + 1,
                "Incorrect number of regions");
    }

    @Test
    public void testAddingDistrict() {
        Government government = Government.getInstance();
        int countDistrictsGovernment = government.getDistricts().size();
        City city = government.getCities().getFirst();
        int countDistrictsCity = city.getDistricts().size();

        District district = new District("testDistrict", government, city);

        Assert.assertEquals(government.getDistricts().size(), countDistrictsGovernment + 1,
                "Incorrect number of districts in the government");

        Assert.assertEquals(city.getDistricts().size(), countDistrictsCity + 1,
                "Incorrect number of districts in the city");
    }

    @Test
    public void testAddingCity() {
        Government government = Government.getInstance();
        int countCitiesGovernment = government.getCities().size();
        Region region = government.getRegions().getFirst();
        int countCitiesRegion = region.getCities().size();

        City city = new City("testCity", government, region);

        Assert.assertEquals(government.getCities().size(), countCitiesGovernment + 1,
                "Incorrect number of cities in the government");

        Assert.assertEquals(region.getCities().size(), countCitiesRegion + 1,
                "Incorrect number of cities in the region");
    }

    @Test
    public void testCountAverageAgeCitizens() {
        Government government = Government.getInstance();
        int averageAgeCitizens = government.countAverageAgeCitizens();

        int sum = 0;
        for (Citizen citizen : government.getCitizens()) {
            sum += citizen.getAge();
        }
        int testAverageAgeCitizens = sum / government.getCitizens().size();
        Assert.assertEquals(averageAgeCitizens, testAverageAgeCitizens, "Incorrect average age");
    }
}