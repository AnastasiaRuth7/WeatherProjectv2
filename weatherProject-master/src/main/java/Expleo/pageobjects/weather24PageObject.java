package Expleo.pageobjects;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;

public class weather24PageObject
{
    //Use FindBy to get web elements
    @FindBy (how = How.XPATH, using = "//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]")
    private WebElement clickDropdown;
    @FindBy (how = How.XPATH, using = "//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]/option[73]")
    private WebElement selectCity;
    @FindBy (how = How.XPATH, using = ".//*[@id=\"ctl00_WeatherContentHolder_btnGo\"]")
    private WebElement clickGo;
    @FindBy (how = How.XPATH, using = "//*[@id=\"ext-gen28\"]")
    private WebElement click7Day;

    //Create methods for web elements
    public void clickDropdown()
    {
        clickDropdown.click();
    }

    public void setSelectCity()
    {
        selectCity.click();
    }

    public void ClickGo()
    {
        clickGo.click();
    }

    public void Click7Day()
    {
        click7Day.click();
    }
}
