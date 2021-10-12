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

import java.util.HashMap;
import java.util.List;

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

    @When("^I run the peopleEndpoint and search name with (.*)$")
    public void iRunThePeopleEndpointWithName(String name) {
        response=RestAssured.get(url+"?name="+name);
        System.out.println(url+"?name="+name);
    }

    @Then("^I should get the corresponding (.*)$")
    public void iShouldGetTheCorrespondingGender(String gender) {
        JsonPath jsonPath = new JsonPath(response.getBody().asString());
        //System.out.println(response.getBody().asString());
        String responseGender = jsonPath.getString("gender[0]");
        Assert.assertEquals(responseGender,gender);
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
}
