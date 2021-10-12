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
        JsonPath jsonPath = new JsonPath(response.getBody().asString());
        movie_id = jsonPath.getString("id");

    }

    @Then("^User validates the response with (.*)$")
    public void userValidatesTheResponseWithId(String input_id) {
        Assert.assertEquals(movie_id, input_id);
    }
}
