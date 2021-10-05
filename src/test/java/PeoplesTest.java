import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PeoplesTest {
    @BeforeClass
    public void Setup(){
        Resources resources = new Resources();
    }
    @Test
    public void test1(){
        System.out.println("HelloWorld");

    }
}
