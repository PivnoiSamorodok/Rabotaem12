package UmobixTest.mainFlowTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;


public class main {
    HomePage homePage;
    UmobixTest.mainFlowTests.EmailPage EmailPage;
    UmobixTest.mainFlowTests.DevicePage DevicePage;
    UmobixTest.mainFlowTests.PricesPage PricesPage;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver, wait);
        EmailPage = new EmailPage(driver, wait);
        DevicePage = new DevicePage(driver,wait);
        PricesPage = new PricesPage(driver,wait);

    }

    @Test
    public void HomePageTryNowClick() {
     driver.get(DevicePage.getFullURL(homePage.path));
     homePage.TryNowHeaderClick();
     boolean currentURL = homePage.compareURL(driver.getCurrentUrl());
     Assert.assertTrue(currentURL, "Email URL doesnt have expected part");
    }

    @Test(dependsOnMethods = {"HomePageTryNowClick"})
    public void emailInputFieldDisplay(){
        boolean emailInputField = EmailPage.checkEmailInputVisibility();
        Assert.assertTrue(emailInputField, "Expected email unput field isnt desplaying");
    }

    @Test(dependsOnMethods = {"emailInputFieldDisplay"})
    public void emailPlaceholderCheck(){
        String placeholder = EmailPage.isEmailPlaceholderCorrect();
        Assert.assertEquals(placeholder, "Enter your valid email", "Inccorrect placeholder name");
    }
    @Test(dependsOnMethods = {"emailPlaceholderCheck"})
    public void emailInputIntoField(){
        EmailPage.checkEmailValueInput();
    }

    @Test(dependsOnMethods = {"emailPlaceholderCheck"}) //Временная заглушка с emailPlaceholderCheck должно быть emailInputIntoField
    public void emailButtonDisplay(){
        EmailPage.checkEmailButtonVisibility();
    }

    @Test(dependsOnMethods = {"emailButtonDisplay"})
    public void emailButtonClick(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#tryStep > div > form > button")));
        WebElement emailButton = EmailPage.checkEmailButtonVisibility();
        EmailPage.checkEmailButtonClick(emailButton);
    }

    @Test(dependsOnMethods = {"emailButtonClick"})
    public void compareDeviceURL(){
        boolean isURLCorrect = EmailPage.CompareDeviceURl(driver.getCurrentUrl());
        Assert.assertTrue(isURLCorrect, "Device URL doesnt have expected part");
    }

    @Test(dependsOnMethods = {"compareDeviceURL"})
    public void deviceH3TitleCheck(){
       DevicePage.checkDeviceH3TitleVisiblity();
    }

    @Test(dependsOnMethods = {"deviceH3TitleCheck"}, alwaysRun = true)
    public void deviceAndroidButtonCheck(){
        DevicePage.isAndroidButtonVisible();
    }

    @Test(dependsOnMethods = {"deviceAndroidButtonCheck"}, alwaysRun = true)
    public void deviceIosButtonCheck(){
        DevicePage.isIosButtonVisible();
    }

    @Test(dependsOnMethods = {"deviceAndroidButtonCheck"}, alwaysRun = true)
    public void deviceAndroidButtonText(){
        WebElement androidButton = DevicePage.checkAndroidButtonText();
        Assert.assertEquals(androidButton.getText(), "Android phone or tablet");
    }

    @Test(dependsOnMethods = {"deviceIosButtonCheck"}, alwaysRun = true)
    public void deviceIosButtonText(){
        WebElement iosButton = DevicePage.checkIosButtonText();
        Assert.assertEquals(iosButton.getText(), "iOS, iPhone, iPad");
    }

    @Test(dependsOnMethods = {"deviceIosButtonText"}, alwaysRun = true)
    public void deviceAndroidButtonClick(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(@data-localstorege-device,'android')]")));
        DevicePage.checkAndroidButtonClick();
    }

    @Test(dependsOnMethods = {"deviceAndroidButtonClick"}, alwaysRun = true)
    public void deviceIosButtonClick(){
        DevicePage.checkIosButtonClick();
    }

    @Test(dependsOnMethods = {"deviceIosButtonClick"})
    public void pricesCompareURL(){
        boolean pricesURL = PricesPage.CompareURL(driver.getCurrentUrl());
        Assert.assertTrue(pricesURL, "Expected pricesURL doesnt have expected part");
    }

    @Test(dependsOnMethods = {"pricesCompareURL"})
    public void pricesOneMonthTittleDisplayed(){
        PricesPage.isOneMonthTittleVisible();
    }
    @Test(dependsOnMethods = {"pricesOneMonthTittleDisplayed"}, alwaysRun = true)
    public void pricesOneMonthTittleCorrectText(){
       WebElement oneMonthTittle = PricesPage.OneMonthTittleCorrectText();
        Assert.assertEquals(oneMonthTittle.getText(), "1 Month");

    }
    @Test(dependsOnMethods = {"pricesOneMonthTittleCorrectText"})
    public void pricesOneMonthFullPackDisplayed(){
        PricesPage.OneMonthFullPackDisplayed();
    }
    @Test(dependsOnMethods = {"pricesOneMonthFullPackDisplayed"}, alwaysRun = true)
    public void pricesOneMonthFullPackCorrectText(){
       WebElement fullPack = PricesPage.OneMonthFullPackCorrectText();
        Assert.assertEquals(fullPack.getText(), "FULL PACK");
    }
    @Test(dependsOnMethods = {"pricesOneMonthFullPackCorrectText"})
    public void pricesOneMonthCurrencyCheck(){
        WebElement currency = PricesPage.OneMonthCurrencyCheck();
        Assert.assertEquals(currency.getText(), "€");
    }

    @Test(dependsOnMethods = {"pricesOneMonthCurrencyCheck"})
    public void pricesOneMonthPriceDisplaying(){
        PricesPage.isOneMonthPriceVisible();
    }

    @Test(dependsOnMethods = {"pricesOneMonthPriceDisplaying"}, alwaysRun = true)
    public void pricesOneMonthPriceCorrectValue(){
        WebElement duration = PricesPage.OneMonthPriceCorrectDuration();
        Assert.assertEquals(duration.getText(), "/mo");

    }
    @Test(dependsOnMethods = {"pricesOneMonthPriceDisplaying"}, alwaysRun = true)
    public void isOneMonthPriceOldOfferVisible(){
        PricesPage.isOneMonthPriceOldOfferVisible();
    }

    @Test(dependsOnMethods = {"isOneMonthPriceOldOfferVisible"})
    public void pricesOneMonthPriceCorrectOldOffer(){
        WebElement oldOffer = PricesPage.OneMonthPriceCorrectOldOffer();
        Assert.assertEquals(oldOffer.getText(), "€ 59.99 /mo");

    }
    @Test(dependsOnMethods = {"pricesOneMonthPriceCorrectValue"}, alwaysRun = true)
    public void pricesOneMonthTryNowButtonDisplaying(){
        PricesPage.OneMonthTryNowButtonDisplaying();
    }
    @Test(dependsOnMethods = {"pricesOneMonthTryNowButtonDisplaying"})
    public void pricesOneMonthTryNowButtonCorrectText(){
        WebElement oneTryNow = PricesPage.OneMonthTryNowButtonCorrectText();
        Assert.assertEquals(oneTryNow.getText(), "TRY NOW");

    }
    @Test(dependsOnMethods = {"pricesOneMonthTryNowButtonCorrectText"})
    public void pricesOneMonthTryNowButtonClick(){
        PricesPage.OneMonthTryNowButtonClick();
    }
    @Test(dependsOnMethods = {"pricesOneMonthTryNowButtonClick"})
    public void CheckoutURLCompare(){
        boolean checkoutURL = PricesPage.CheckoutURLCompare(driver.getCurrentUrl());
        Assert.assertTrue(checkoutURL, "Checkout URL doesnt have expected part");

    }


}
