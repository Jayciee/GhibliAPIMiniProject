import groovy.json.JsonParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import static io.restassured.path.json.JsonPath.*;

public class PeopleStepDef {
    private Resources resources = new Resources();
    private Response response;
    private String url;
    private String name;
    @Given("the people url")
    public void thePeopleUrl() {
        url = resources.getBaseUrl()+"/people";

    }

    @When("^I run the peopleEndpoint with (.*)$")
    public void iRunThePeopleEndpointWithName(String name) {
        response=RestAssured.get(url+"?name="+name);
        System.out.println(url+"?name="+name);
    }

    @Then("^I should get the corresponding (.*)$")
    public void iShouldGetTheCorrespondingGender(String gender) {
        JsonPath jsonPath = new JsonPath(response.getBody().asString());
        System.out.println(response.getBody().asString());
        String responseGender = jsonPath.getString("gender[0]");
        Assert.assertEquals(responseGender,gender);
    }
}
