package government;

import cy.markelova.government.entity.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GovernmentTests {

    @Test
    public void testCreationGovernment() {
        Government government = Government.getInstance();
        Assert.assertEquals(government.getRegions().size(), 3, "Incorrect number of regions");
        Assert.assertTrue(government.countCities() >= 3 && government.countCities() <= 16,
                "Incorrect number of cities");
        Assert.assertTrue(government.countDistricts() >= 6 && government.countDistricts() <= 96,
                "Incorrect number of districts");
        Assert.assertTrue(government.getCitizens().size() >= 60 && government.getCitizens().size() <= 2784,
                "Incorrect number of citizens");
    }

    @Test
    public void testAddingCitizen() {
        Government government = Government.getInstance();
        int countCitizensGovernment = government.getCitizens().size();
        District district = government.getRegions().getFirst().getCities().getLast().getDistricts().getFirst();
        int countCitizensDistrict = district.getCitizens().size();
        Citizen citizen = new Citizen(government, district);
        Assert.assertEquals(government.getCitizens().size(), countCitizensGovernment + 1,
                "Incorrect number of citizens in the government");
        Assert.assertEquals(district.getCitizens().size(), countCitizensDistrict + 1,
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
        int countDistrictsGovernment = government.countDistricts();
        City city = government.getRegions().getFirst().getCities().getFirst();
        int countDistrictsCity = city.getDistricts().size();

        District district = new District("testDistrict", government, city);

        Assert.assertEquals(government.countDistricts(), countDistrictsGovernment + 1,
                "Incorrect number of districts in the government");

        Assert.assertEquals(city.getDistricts().size(), countDistrictsCity + 1,
                "Incorrect number of districts in the city");
    }

    @Test
    public void testAddingCity() {
        Government government = Government.getInstance();
        int countCitiesGovernment = government.countCities();
        Region region = government.getRegions().getFirst();
        int countCitiesRegion = region.getCities().size();

        City city = new City("testCity", government, region);

        Assert.assertEquals(government.countCities(), countCitiesGovernment + 1,
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