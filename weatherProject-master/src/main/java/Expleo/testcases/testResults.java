package Expleo.testcases;
import Expleo.pageobjects.accuWeatherPageObject;
import Expleo.pageobjects.weather24PageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

public class testResults
{
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception
    {

        // System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        String baseUrl = "http://weather.news24.com";
        String expectedURL = "http://weather.news24.com/";
        driver.get(baseUrl);
        // String actualTitle = driver.getTitle();
        String actualURL = driver.getCurrentUrl();
        System.out.println("Actual URL is: " + actualURL);
        Assert.assertEquals(actualURL, expectedURL);
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testWeather() throws Exception
    {
        weather24PageObject weather = PageFactory.initElements(driver, weather24PageObject.class);
        weather.clickDropdown();
        weather.setSelectCity();
        weather.ClickGo();
        weather.Click7Day();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[4]")));

        String [] minTemp24 = new String[5];

        Thread.sleep(3000);
        //Store minimum temperatures from Weather24 in an array
        minTemp24 [0] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[5]")).getText();
        minTemp24 [1] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[5]")).getText();
        minTemp24 [2] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[5]")).getText();
        minTemp24 [3] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[5]")).getText();
        minTemp24 [4] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[5]")).getText();

        String [] maxTemp24 = new String[5];
        //Store maximum temperatures from Weather24 in an array
        maxTemp24 [0] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[4]")).getText();
        maxTemp24 [1] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[4]")).getText();
        maxTemp24 [2] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[4]")).getText();
        maxTemp24 [3] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[4]")).getText();
        maxTemp24 [4] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[4]")).getText();

        //Open Accuweather website
        String baseUrl1 = "http://www.accuweather.com/";
        driver.get(baseUrl1);
        accuWeatherPageObject accWeather = PageFactory.initElements(driver, accuWeatherPageObject.class);
        Thread.sleep(3000);
        accWeather.name("Pretoria");
        accWeather.enter();
        accWeather.chooseCity();
        accWeather.selectDaily();

        String [] minTempAcc = new String[5];
        //Store minimum temperatures from AccuWeather in an array
        minTempAcc [0] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[2]")).getText().substring(2) + "C";
        minTempAcc [1] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[2]")).getText().substring(2) + "C";
        minTempAcc [2] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[2]")).getText().substring(2) + "C";
        minTempAcc [3] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[4]/div[2]/span[2]")).getText().substring(2) + "C";
        minTempAcc [4] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[5]/div[2]/span[2]")).getText().substring(2) + "C";

        String [] maxTempAcc = new String[5];
        //Store maximum temperatures from Weather24 in an array
        maxTempAcc [0] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[1]")).getText()+ "C";
        maxTempAcc [1] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[1]")).getText()+ "C";
        maxTempAcc [2] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[1]")).getText()+ "C";
        maxTempAcc [3] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[4]/div[2]/span[1]")).getText()+ "C";
        maxTempAcc [4] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[5]/div[2]/span[1]")).getText()+ "C";

        String [] Day = new String [5];
        //Store days in an array
        Day[0] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[1]/p[1]")).getText();
        Day[1] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[1]/p[1]")).getText();
        Day[2] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[1]/p[1]")).getText();
        Day[3] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[4]/div[1]/p[1]")).getText();
        Day[4] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[5]/div[1]/p[1]")).getText();


        //Print out the values
        System.out.println(">>>MINIMUM TEMPERATURES<<<");
        System.out.println("---------------------------------");
        System.out.println("    "+"Weather24"+"    "+"AccuWeather");
        System.out.println("---------------------------------");
        for (int i = 0; i <= 4; i++)
        {
            if (minTemp24[i].equals(minTempAcc[i]))
                {
                System.out.println(Day[i]+"    "+ minTemp24[i] + "    " + minTempAcc[i] + "\n" + "Temperatures are the same.");
                System.out.println("---------------------------------");
                }
            else
                {
                System.out.println(Day[i]+"    "+ minTemp24[i] + "    " + minTempAcc[i] + "\n" +  "Temperatures are not the same");
                System.out.println("---------------------------------");
                }
        }
        System.out.println("\n");
        System.out.println(">>>MAXIMUM TEMPERATURES<<<");
        System.out.println("---------------------------------");
        System.out.println("    "+"Weather24"+"    "+"AccuWeather");
        System.out.println("---------------------------------");
        for (int j = 0; j <= 4; j++)
        {
            if(maxTemp24[j].equals(maxTempAcc[j]))
                {
                System.out.println(Day[j]+"    "+ maxTemp24[j]+"    "+maxTempAcc[j]+ "\n" + "Temperatures are the same.");
                System.out.println("---------------------------------");
                }
            else
                {
                System.out.println(Day[j]+"    "+ maxTemp24[j]+"    "+maxTempAcc[j]+"\n" +"Temperatures are not the same");
                System.out.println("---------------------------------");
                }
        }
    }

    @After
    public void tearDown() throws Exception
    {
        //driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString))
        {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by)
    {
        try
        {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e)
        {
            return false;
        }
    }

    private boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e)
        {
            return false;
        }
    }

    private String closeAlertAndGetItsText()
    {
        try
        {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert)
                {
                alert.accept();
                }
            else
                {
                alert.dismiss();
                }
            return alertText;
        }
        finally
        {
            acceptNextAlert = true;
        }
    }
}
