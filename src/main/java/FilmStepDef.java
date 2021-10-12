import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

public class FilmStepDef {
    private Resources resources = new Resources();
    private Response response;
    private String url;
    private String movie_id;
    private JsonPath jsonBody;

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
        movie_id = jsonBody.getString("id[0]");
        Assert.assertEquals(movie_id, input_id);
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
}
