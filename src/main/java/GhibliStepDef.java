import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.Film;
import model.Location;
import model.People;
import model.Species;
import org.testng.Assert;

import java.util.List;

public class GhibliStepDef {
    private Resources resources = new Resources();
    private Response response;
    private String url;
    private JsonPath jsonBody;    

    /* Film Step Definitions */
    @Given("^The films url$")
    public void userSetsTehBaseAPIRequestWithURL() {
        url = resources.getBaseUrl()+"/films";
    }

    @When("^User sends the API request to get all the films$")
    public void userSendsTheAPIRequestToGetAllTheFilms() {
        response = RestAssured.get(url);
    }

    @Then("^User validates the response status is 200$")
    public void userValidatesTheResponseStatusIsCode() {
        int responseCode = response.getStatusCode();
        Assert.assertEquals(200, responseCode);
    }

    @When("^User sends the API request with (.*)$")
    public void userSendsTheAPIRequestWithFilm(String name) {
        url = url + "?title=" + name;
        response = RestAssured.get(url);
        jsonBody = new JsonPath(response.getBody().asString());
    }

    @Then("^User validates the response with (.*)$")
    public void userValidatesTheResponseWithId(String input_id) {
//        String id = jsonBody.getString("id[0]");
//        Assert.assertEquals(id, input_id);
        List<Film> film = jsonBody.getList(".", Film.class);
        Assert.assertEquals(film.get(0).getId(), input_id);
    }

    @And("User receives empty response")
    public void userReceivesEmptyResponse() {
        Assert.assertEquals("[]", jsonBody.getString(""));
    }

    @Given("Incorrect films URI")
    public void incorrectFilmsURI() {
        url = resources.getBaseUrl()+"/film";
    }

    @Then("User receives status code of 404")
    public void userReceivesStatusCode() {
        int responseCode = response.getStatusCode();
        Assert.assertEquals(404, responseCode);
    }

    /* People Step Definitions */
    @Given("the people url")
    public void thePeopleUrl() {
        url = resources.getBaseUrl()+"/people";

    }

    @When("^I run the peopleEndpoint and search name with (.*)$")
    public void iRunThePeopleEndpointWithName(String name) {
        response=RestAssured.get(url+"?name="+name);
        System.out.println(url+"?name="+name);
    }

    @Then("^I should get the corresponding (.*)$")
    public void iShouldGetTheCorrespondingGender(String gender) {
        jsonBody = new JsonPath(response.getBody().asString());
        List<People> people = jsonBody.getList(".", People.class);
        for (People person : people) {
            Assert.assertEquals(person.getGender(), gender);
        }
    }

    @When("I run the peopleEndpoint with Female")
    public void iRunThePeopleEndpointWithFemale() {
        response=RestAssured.get(url+"?gender="+"Female");
    }

    @Then("I should get a list of all the Female characters")
    public void iShouldGetAListOfAllTheFemaleCharacters() {
        JsonPath jsonPath = new JsonPath(response.getBody().asString());
        List list = jsonPath.getList("");
        int numberOfPeople = list.size();
        Assert.assertEquals(numberOfPeople,17);
    }

    /* Vehicle Step Definitions */
    @Given("The vehicles url")
    public void theVehiclesUrl() {
        url = resources.getBaseUrl()+"/vehicles";
    }

    @When("^User sends the API request to get all vehicles$")
    public void userSendsTheAPIRequestToGetAllVehicles() {
        response = RestAssured.get(url);
    }

    @Then("^User receives the correct response code$")
    public void userReceivesTheCorrectResponseCode() {
        int responseCode = response.getStatusCode();
        Assert.assertEquals(200, responseCode);
    }

    @When("^User sends the API request using (.*) name$")
    public void userSendsTheAPIRequestUsingVehicleName(String vehicle) {
        url = url+ "?name=" + vehicle;
        response = RestAssured.get(url);
        jsonBody = new JsonPath(response.getBody().asString());
    }

    @Given("The species url")
    public void theSpeciesUrl() {
        url = resources.getBaseUrl()+"/species";
    }

    @When("User sends the API request to get all species")
    public void userSendsTheAPIRequestToGetAllSpecies() {
        response = RestAssured.get(url);
        jsonBody = new JsonPath(response.getBody().asString());
    }

    @Then("The first response should be {string}")
    public void theFirstResponseShouldBe(String input) {
        List<Species> species = jsonBody.getList(".", Species.class);
        Assert.assertEquals(species.get(0).getName(), input);
    }

    @And("There should be {int} items in the response")
    public void thereShouldBeItemsInTheResponse(int count) {
        List<Species> species = jsonBody.getList(".", Species.class);
        Assert.assertEquals(species.size(), count);
    }

    @Given("The locations url")
    public void theLocationsUrl() {
        url = resources.getBaseUrl()+"/locations";
    }

    @When("I run the standalone locations endpoint")
    public void iRunTheStandaloneLocationsEndpoint() {
        response = RestAssured.get(url);
        jsonBody = new JsonPath(response.getBody().asString());
    }

    @Then("I should get a list of locations")
    public void iShouldGetAListOfLocations() {
        List<Location> locations = jsonBody.getList(".", Location.class);
        Assert.assertNotNull(locations);
    }

    @And("This list should be of size {int}")
    public void thisListShouldBeOfSize(int count) {
        List<Location> locations = jsonBody.getList(".", Location.class);
        Assert.assertEquals(locations.size(),count);
    }


    @When("I run the locations endpoint with climate filter {string}")
    public void iRunTheLocationsEndpointWithClimateFilter(String filter) {
        url = url + "?climate=" + filter;
        response = RestAssured.get(url);
        jsonBody = new JsonPath(response.getBody().asString());
    }

    @And("This list should only contain {string}")
    public void thisListShouldOnlyContain(String filter) {
        List<Location> locations = jsonBody.getList(".", Location.class);
        for (Location location : locations) {
            Assert.assertEquals(location.getClimate(), filter);

        }
    }
}
