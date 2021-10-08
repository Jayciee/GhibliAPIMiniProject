import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class Generic {
    Resources resources = new Resources();
    String url;
    Response response;
    @Given("I have the baseURL")
    public void iHaveTheBaseURL() {
        url = resources.getBaseUrl();
    }

    @When("I run the endpoint")
    public void iRunTheEndpoint() {
        response = RestAssured.get(url);
    }

    @Then("I receive a {int} status")
    public void iReceiveAStatus(int arg0) {
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
