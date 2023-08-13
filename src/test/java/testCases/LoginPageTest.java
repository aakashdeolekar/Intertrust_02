package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginPageTest extends BaseClass {

    @Test
    public void loginTest(){

        driver.get(baseURL);
        LoginPage lp = new LoginPage(driver);
        HomePage hp = new HomePage(driver);

        lp.clickOnWeatherData("Nagpur");
        hp.verifyTitle();
        Assert.assertTrue(hp.verifyTitle());

    }
}
