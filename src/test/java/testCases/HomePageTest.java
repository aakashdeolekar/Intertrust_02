package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class HomePageTest extends BaseClass{


    @Test
    public void HomeTest(){

        driver.get(baseURL);
        LoginPage lp = new LoginPage(driver);
        HomePage hp = new HomePage(driver);

        lp.clickOnWeatherData("Nagpur");
        hp.headerFromTable();
        hp.rowsFromTable();
        hp.allDataFromTable();

    }


}
