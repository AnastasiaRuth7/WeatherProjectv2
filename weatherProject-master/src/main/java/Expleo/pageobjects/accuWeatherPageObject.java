package Expleo.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class accuWeatherPageObject
{
        //Use FindBy to get web elements
        @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div[2]/div[1]/form/input")
        private WebElement search;
        private WebElement query;
        private WebElement enter;
        @FindBy(how = How.XPATH, using = "/html/body/div/div[5]/div/div[1]/div[1]/div[1]/a[1]")
        private WebElement city;
        @FindBy(how = How.XPATH, using = "/html/body/div/div[4]/div/div/div[3]/a[4]/span")
        private  WebElement daily;
        @FindBy(how = How.XPATH, using = "/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[2]")
        private WebElement min;
        @FindBy(how = How.XPATH, using = "/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[1]")
        private WebElement max;

        //Create methods for web elements
        public void name (String text)
        {
            query.clear();
            query.sendKeys(text);
        }

        public void enter ()
        {
            query.sendKeys(Keys.ENTER);
        }

        public void chooseCity()
        {
            city.click();
        }

        public void selectDaily()
        {
            daily.click();
        }
}
