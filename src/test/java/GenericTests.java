import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GenericTests {
    private String url;
    @BeforeClass
    public void Setup(){
        Resources resources = new Resources();
        url = resources.getBaseUrl();
    }
    @Test
    public void GivenCorrectBaseUrl(){
        Response response = RestAssured.get(url);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
}
