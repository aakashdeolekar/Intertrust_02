package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;
    public LoginPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    public WebElement SignIn;

    @FindBy(xpath = "//span[contains(text(),'Sign up')]")
    public WebElement Signup;

    @FindBy(xpath = "//input[@placeholder='Enter an email address for your account']")
    public WebElement AccountEmail;

    @FindBy(xpath = "//*[contains(text(),'Continue')]")
    public WebElement ContinueBtn;

    @FindBy(xpath = "//*[contains(text(),'Accept all cookies')]")
    public WebElement Coockies;

    @FindBy(xpath = "//input[@id='exampleInputEmail1']")
    public WebElement EmailAddress;

    @FindBy(xpath = "//input[@id='exampleInputPassword1']")
    public WebElement Password;

    @FindBy(xpath = "//div/button[contains(text(),'Sign in')]")
    public WebElement SignInLoginBtn;

    @FindBy(xpath = "//*[@id='navbarNav']/ul/li[1]/a")
    public WebElement WeatherData;

    @FindBy(xpath = "//input[@placeholder='Enter a location']")
    public WebElement Location;

    @FindBy(xpath = "//*[contains(text(),'Search')]")
    public WebElement Search;

    public void clickOnWeatherData(String City){

        if(Coockies.isDisplayed()){
            Coockies.click();
            WeatherData.click();
            Location.sendKeys(City);
            Search.click();
        }
        else {
            WeatherData.click();
            Location.sendKeys(City);
            Search.click();
        }

    }
}
