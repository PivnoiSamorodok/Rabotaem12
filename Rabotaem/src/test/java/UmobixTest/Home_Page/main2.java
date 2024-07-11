package UmobixTest.Home_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class main2 {
    homePage homePage;
    EmailPage EmailPage;
    DevicePage DevicePage;
    PricesPage PricesPage;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new homePage(driver, wait);
        EmailPage = new EmailPage(driver, wait);
        DevicePage = new DevicePage(driver,wait);
        PricesPage = new PricesPage(driver,wait);

    }

    @Test
    public void HomePageTryNowClick() {
     driver.get("https://umobix.com/?dont-send-to-stat=1");
     homePage.WaitTryNowHeader();
     homePage.TryNowHeaderClick();
     homePage.getRedirectedURL();
     homePage.compareURL(driver.getCurrentUrl(),"https://umobix.com/email.html");
    }

    @Test(dependsOnMethods = {"HomePageTryNowClick"})
    public void emailInputFieldDisplay(){
        EmailPage.inputFieldDisplaying();
    }

    @Test(dependsOnMethods = {"emailInputFieldDisplay"})
    public void emailPlaceholderCheck(){
        WebElement emailInput = EmailPage.inputFieldDisplaying();
        EmailPage.emailPlaceholderCheck(emailInput);
    }
    @Test(dependsOnMethods = {"emailPlaceholderCheck"})
    public void emailInputIntoField(){
        WebElement emailInput = EmailPage.inputFieldDisplaying();
        EmailPage.emailValueInput(emailInput);
    }

    @Test(dependsOnMethods = {"emailInputIntoField"})
    public void emailButtonDisplay(){
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#tryStep > div > form > button")));
        EmailPage.emailButtonDisplaying();
    }

    @Test(dependsOnMethods = {"emailButtonDisplay"})
    public void emailButtonClick(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#tryStep > div > form > button")));
        WebElement emailButton = EmailPage.emailButtonDisplaying();
        EmailPage.emailButtonClick(emailButton);
    }

    @Test(dependsOnMethods = {"emailButtonClick"})
    public void compareDeviceURL(){
        EmailPage.compareDeviceURl(driver.getCurrentUrl(), "https://umobix.com/devices.html");
    }

    @Test(dependsOnMethods = {"compareDeviceURL"})
    public void deviceH3TitleCheck(){
       DevicePage.deviceH3Titlecheck();
    }

    @Test(dependsOnMethods = {"deviceH3TitleCheck"}, alwaysRun = true)
    public void deviceAndroidButtonCheck(){
        DevicePage.androidButton();
    }

    @Test(dependsOnMethods = {"deviceAndroidButtonCheck"}, alwaysRun = true)
    public void deviceIosButtonCheck(){
        DevicePage.iosButton();
    }

    @Test(dependsOnMethods = {"deviceAndroidButtonCheck"}, alwaysRun = true)
    public void deviceAndroidButtonText(){
        DevicePage.androidButtonText();
    }


    @Test(dependsOnMethods = {"deviceIosButtonCheck"}, alwaysRun = true)
    public void deviceIosButtonText(){
        DevicePage.iosButtonText();
    }

    @Test(dependsOnMethods = {"deviceIosButtonText"}, alwaysRun = true)
    public void deviceAndroidButtonClick(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(@data-localstorege-device,'android')]")));
        DevicePage.androidButtonClick();
    }

    @Test(dependsOnMethods = {"deviceAndroidButtonClick"}, alwaysRun = true)
    public void deviceIosButtonClick(){
        DevicePage.iosButtonClick();
    }

    @Test(dependsOnMethods = {"deviceIosButtonClick"})
    public void pricesCompareURL(){
        PricesPage.CompareURL(driver.getCurrentUrl(), "https://umobix.com/prices.html");
    }

    @Test(dependsOnMethods = {"pricesCompareURL"})
    public void pricesOneMonthTittleDisplayed(){
        PricesPage.OneMonthTittleDisplayed();
    }
    @Test(dependsOnMethods = {"pricesOneMonthTittleDisplayed"}, alwaysRun = true)
    public void pricesOneMonthTittleCorrectText(){
        PricesPage.OneMonthTittleCorrectText();
    }
    @Test(dependsOnMethods = {"pricesOneMonthTittleCorrectText"}, alwaysRun = true)
    public void pricesOneMonthFullPackDisplayed(){
        PricesPage.OneMonthFullPackDisplayed();
    }
    @Test(dependsOnMethods = {"pricesOneMonthFullPackDisplayed"}, alwaysRun = true)
    public void pricesOneMonthFullPackCorrectText(){
        PricesPage.OneMonthFullPackCorrectText();
    }
//12

}
