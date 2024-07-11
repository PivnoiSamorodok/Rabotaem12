package UmobixTest.Home_Page;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class homePage extends BasePage{
    public homePage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    private WebElement getHeaderTryNow(){
        return driver.findElement(By.xpath("/html/body/header/div/nav/div[2]/div[2]/a"));
    }

    public void WaitTryNowHeader(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/header/div/nav/div[2]/div[2]/a")));
    }

    public void TryNowHeaderClick(){
        getHeaderTryNow().click();
    }

    public String getRedirectedURL(){
        return driver.getCurrentUrl();
    }

    public boolean compareURL(String actualURL, String expectedURL){
    Assert.assertTrue(actualURL.contains(expectedURL), "Expected emailURL doesnt have expected part");
    return true;
    }
//12
}
