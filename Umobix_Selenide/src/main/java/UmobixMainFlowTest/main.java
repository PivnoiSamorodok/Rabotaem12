package UmobixMainFlowTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;


public class main {
    UmobixMainFlowTest.HomePage homePage;
    UmobixMainFlowTest.EmailPage EmailPage;
    UmobixMainFlowTest.DevicePage DevicePage;
    UmobixMainFlowTest.PricesPage PricesPage;
    WebDriver driver;
    WebDriverWait wait;
    RandomEmailGeneration RandomEmailGeneration;

    @BeforeClass
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        //Configuration.timeout = 10000;
        homePage = new UmobixMainFlowTest.HomePage();
        EmailPage = new UmobixMainFlowTest.EmailPage();
        DevicePage = new DevicePage();
        PricesPage = new PricesPage();
        RandomEmailGeneration = new RandomEmailGeneration(5);

    }

    @Test
    public void HomePageTryNowClick() {
        Selenide.open(homePage.getFullURL());
        homePage.isTryNowHeaderClickable();
        boolean currentURL = homePage.compareURL();
        Assert.assertTrue(currentURL, "Email URL doesnt have expected part");
    }

    @Test(dependsOnMethods = {"HomePageTryNowClick"})
    public void emailInputFieldDisplay() {
        EmailPage.checkEmailInputVisibility();

    }

    @Test(dependsOnMethods = {"emailInputFieldDisplay"})
    public void emailPlaceholderCheck() {
        EmailPage.checkEmailPlaceholderCorrection().shouldHave(Condition.attribute("placeholder", "Enter your valid email"));
    }

    @Test(dependsOnMethods = {"emailPlaceholderCheck"})
    public void emailInputIntoField() {
        String emailInput = EmailPage.checkEmailValueInput();
        Assert.assertTrue(emailInput.contains(RandomEmailGeneration.getDomain()));
    }

    @Test(dependsOnMethods = {"emailInputIntoField"})
    public void emailButtonDisplay() {
        EmailPage.isEmailButtonVisible().shouldBe(Condition.visible);
    }

    @Test(dependsOnMethods = {"emailButtonDisplay"})
    public void emailButtonClick() {
        String initialURL = WebDriverRunner.url();
        EmailPage.clickabilityOfEmailButton();
        String newURL = WebDriverRunner.url();
        Assert.assertNotEquals(newURL, initialURL, "URL doesnt change after button click");
    }

    @Test(dependsOnMethods = {"emailButtonClick"})
    public void compareDeviceURL() {
        String isURLCorrect = DevicePage.compareEmailUrl();
        Assert.assertEquals(isURLCorrect, "https://umobix.com/devices.html", "Device URL doesnt have expected part");
    }

    @Test(dependsOnMethods = {"compareDeviceURL"})
    public void deviceH3TitleCheck() {
        DevicePage.checkDeviceH3TitleVisible().shouldHave(Condition.text("Select the target device to be monitored"));
    }

    @Test(dependsOnMethods = {"deviceH3TitleCheck"}, alwaysRun = true)
    public void deviceAndroidButtonCheck() {
        DevicePage.isAndroidButtonVisible();

    }
    @Test(dependsOnMethods = {"deviceAndroidButtonCheck"}, alwaysRun = true)
    public void deviceAndroidButtonText() {
        DevicePage.checkAndroidButtonTextCorrect().shouldHave(Condition.text("Android phone or tablet"));
    }

    @Test(dependsOnMethods = {"deviceAndroidButtonText"}, alwaysRun = true)
    public void deviceIosButtonCheck() {
        DevicePage.isIosButtonVisible();
    }

    @Test(dependsOnMethods = {"deviceIosButtonCheck"}, alwaysRun = true)
    public void deviceIosButtonText() {
        DevicePage.isIosButtonTextCorrect().shouldHave(Condition.text("iOS, iPhone, iPad"));
    }

    @DataProvider(name = "devicesTypes")
    public Object[][] devicesTypes() {
        return new Object[][]{
                {"Android phone or tablet"},
                {"iOS, iPhone, iPad"}
        };
    }
//12
    @Test(dataProvider = "devicesTypes", dependsOnMethods = {"deviceIosButtonText"}) //12
    public void deviceTypeChoosing(String devicesTypes) {
        String devicesURL = WebDriverRunner.url();
        DevicePage.isDevicesButtonClickable(devicesTypes);
        if (devicesTypes.equals("Android phone or tablet")) {
            Assert.assertTrue(WebDriverRunner.url().contains("/prices"), "URL doesnt contains expected part");
            open(devicesURL);
        } else if (devicesTypes.equals("iOS, iPhone, iPad")) {
            Assert.assertTrue(WebDriverRunner.url().contains("/prices"), "URL, doesnt contains expected part");
        } else {
            System.out.println("Failed redirect to PricesPage");
        }
        //12
    }
    public void qweTest(){
      int qwe;
    }

    /*
    @Test(dependsOnMethods = {"deviceTypeChoosing"}, alwaysRun = true)
    public void pricesCompareURL() {
        boolean isValidURL = PricesPage.compareURL();
        Assert.assertTrue(isValidURL, "Current URL doesnt have expected part");
    }

    @DataProvider(name = "subTittleName")
    public Object[][] subTittleName() {
        return new Object[][]{
                {"1 Month"},
                {"12 Month"},
                {"3 Month"}
        };
    }

    @Test(dataProvider = "subTittleName", dependsOnMethods = {"pricesCompareURL"})
    public void subTypeTittleVisible(String subTittleName) {
        boolean isVisible = PricesPage.subTypeTittleVisible(subTittleName);
        Assert.assertTrue(isVisible, "Subtitle" + subTittleName + "should be visible");
    }

    @Test(dataProvider = "subTittleName", dependsOnMethods = {"subTypeTittleVisible"})
    public void subTypeTittleCorrectText(String subTittleName) {
        String actualText = PricesPage.subTypeTittleCorrectText(subTittleName);
        Assert.assertEquals(actualText, subTittleName, "Subtitle text should be " + subTittleName);
    }

    @Test(dataProvider = "subTittleName", dependsOnMethods = {"subTypeTittleCorrectText"})
    public void pricesFullPackTittleDisplayed(String subTittleName) {
        boolean isVisible = PricesPage.isFullPackTittleVisible(subTittleName);
        Assert.assertTrue(isVisible, "Full pack doenst visible on the page");
    }

    @Test(dataProvider = "subTittleName", dependsOnMethods = {"pricesFullPackTittleDisplayed"}, alwaysRun = true)
    public void pricesFullPackTittleCorrectText(String subTittleName) {
        WebElement fullPack = PricesPage.isFullPackCorrectText(subTittleName);
        Assert.assertEquals(fullPack.getText(), "FULL PACK");
    }

    @Test(dependsOnMethods = {"pricesFullPackTittleCorrectText"})
    public void pricesOneMonthCurrencyCheck() {
        WebElement currency = PricesPage.isOneMonthCurrencyCorrect();
        Assert.assertEquals(currency.getText(), "€");
    }

    @Test(dependsOnMethods = {"pricesOneMonthCurrencyCheck"})
    public void pricesOneMonthPriceDisplaying() {
        boolean isVisible = PricesPage.isOneMonthPriceVisible();
        Assert.assertTrue(isVisible, "Price should be visible on the page");
    }

    @Test(dependsOnMethods = {"pricesOneMonthPriceDisplaying"}, alwaysRun = true)
    public void pricesOneMonthPriceCorrectValue() {
        WebElement duration = PricesPage.isOneMonthPriceCorrectDuration();
        Assert.assertEquals(duration.getText(), "/mo");

    }

    @Test(dependsOnMethods = {"pricesOneMonthPriceDisplaying"}, alwaysRun = true)
    public void isOneMonthPriceOldOfferVisible() {
        boolean isVisible = PricesPage.isOneMonthPriceOldOfferVisible();
        Assert.assertTrue(isVisible, "Old offer should be visible on the page");
    }

    @Test(dependsOnMethods = {"isOneMonthPriceOldOfferVisible"})
    public void pricesOneMonthPriceCorrectOldOffer() {
        WebElement oldOffer = PricesPage.isOneMonthPriceCorrectOldOfferValue();
        Assert.assertEquals(oldOffer.getText(), "€ 59.99 /mo");

    }

    @Test(dependsOnMethods = {"pricesOneMonthPriceCorrectValue"}, alwaysRun = true)
    public void pricesOneMonthTryNowButtonDisplaying() {
        boolean isVisible = PricesPage.isOneMonthTryNowButtonVisible();
        Assert.assertTrue(isVisible, "Try Now button should be visible on the page");
    }

    @Test(dependsOnMethods = {"pricesOneMonthTryNowButtonDisplaying"})
    public void pricesOneMonthTryNowButtonCorrectText() {
        WebElement oneTryNow = PricesPage.isOneMonthTryNowButtonCorrectText();
        Assert.assertEquals(oneTryNow.getText(), "TRY NOW");

    }

    @DataProvider(name = "SubscriptionValue")
    public Object[][] SubscriptionValue() {
        return new Object[][]{
                {"49.99"},
                {"29.99"},
                {"12.49"}
        };
    }

    @Test(dataProvider = "SubscriptionValue", dependsOnMethods = "pricesOneMonthTryNowButtonCorrectText")
    public void subscriptionPricesVisibility(String price) {
        boolean isVisible = PricesPage.isPriceVisible(price);
        Assert.assertTrue(isVisible, "Expected price doesnt visible");
    }

    @DataProvider(name = "subscriptionsTypes")
    public Object[][] subscriptionsTypes() {
        return new Object[][]{
                {"um_mf1_50"},
                {"um_mf3_90"},
                {"um_mf12_150"}
        };
    }

    @Test(dataProvider = "subscriptionsTypes", dependsOnMethods = {"subscriptionPricesVisibility"})
    public void tryNowSubButtonClick(String subscriptionsTypes) {
        //driver.get("https://umobix.com/prices.html");
        String currentURL = driver.getCurrentUrl();
        boolean isClickable = PricesPage.isTryNowButtonClickable(subscriptionsTypes);
        Assert.assertTrue(isClickable, "Button for subscription type " + subscriptionsTypes + "isn't clickable");
        Assert.assertTrue(PricesPage.isCheckoutURLCorrect(), "URL doesnt have expected part");
        if (!subscriptionsTypes.equals("um_mf12_150")) {
            driver.get(currentURL);
        } else System.out.println("Error. Product id wasnt chosen");
    }

    @Test(dependsOnMethods = {"tryNowSubButtonClick"}, alwaysRun = true)
    public void checkoutURLCompare() {
        boolean checkoutURL = PricesPage.isCheckoutURLCorrect();
        Assert.assertTrue(checkoutURL, "Checkout URL doesnt have expected part");
    }

*/
//121
}

