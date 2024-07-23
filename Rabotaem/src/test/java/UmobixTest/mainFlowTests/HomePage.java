package UmobixTest.mainFlowTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public static final By headerTryNow = By.xpath("/html/body/header/div/nav/div[2]/div[2]/a");

    public static final String path = "?dont-send-to-stat=1";
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    private WebElement getHeaderTryNow(){
        return driver.findElement(headerTryNow);
    }

    public void TryNowHeaderClick(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(headerTryNow));
        getHeaderTryNow().click();
    }

    public boolean compareURL(String actualURL){
        return actualURL.contains("/email.html");
    }
//12
}
