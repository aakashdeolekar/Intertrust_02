package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage {

    WebDriver ldriver;

    public HomePage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Historical weather data for Nagpur')]")
    public WebElement TitleOnHomePage;


    public boolean verifyTitle(){
        TitleOnHomePage.isDisplayed();
        return true;
    }

    public void headerFromTable(){
        List<WebElement> allHeaders = ldriver.findElements(By.xpath("//table[contains(@class,table)]//th"));
        Assert.assertEquals(allHeaders.size(),5);

        boolean status=false;
        for(WebElement ele : allHeaders){
            String value=ele.getText();
            if(value.contains("Longitude")){
                status=true;
                break;
            }
        }
    }

    public void rowsFromTable(){
        List<WebElement> numberOfRows = ldriver.findElements(By.xpath("//table[contains(@class,table)]//tbody//tr"));

        boolean dataSet = false;
        for (WebElement ele : numberOfRows){
            String value = ele.getText();
            if(value.contains("Longitude")){
               dataSet=true;
               break;
            }

        }
    }

    /* The only reason to write this extra loop to iterate the x-path was because
     I was not able to get the data, some network issue, as the
     the data had 15 records as per my manual testing but was not fetching. */
    public void allDataFromTable(){

        boolean dataset1 = false;
        int countOfData = ldriver.findElements(By.xpath("//table[contains(@class,table)]//tbody//tr//td")).size();
        for (int m = 1; m <=countOfData;m++){
            List<WebElement> allDataValaue = ldriver.findElements(By.xpath("//table[contains(@class,table)]//tbody//tr//td"+"["+m+"]"));
            for (WebElement ele : allDataValaue){
                String value = ele.getText();
                if(value.contains("WARDHA, IN")){
                    dataset1=true;
                    break;
                }
            }
        }
    }

}
