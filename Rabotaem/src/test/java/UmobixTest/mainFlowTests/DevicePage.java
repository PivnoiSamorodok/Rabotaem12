    package UmobixTest.mainFlowTests;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    public class DevicePage extends BasePage {

        public static final String path = "/devices.html";
        public static final By device_H3 = By.xpath("//h3[contains(@class,'choose-platform-title')]");
        public static final By android_button = By.xpath("//a[contains(@data-localstorege-device,'android')]");
        public static final By ios_button = By.xpath("//a[contains(@data-localstorege-device,'ios')]");
            public DevicePage(WebDriver driver, WebDriverWait wait) {
            super(driver, wait);
        }

        public void checkDeviceH3TitleVisiblity(){
            WebElement deviceH3 = driver.findElement(device_H3);
            deviceH3.isDisplayed();
        }

        public void isAndroidButtonVisible(){
            WebElement androidButton = driver.findElement(android_button);
            androidButton.isDisplayed();
        }

        public void isIosButtonVisible(){
            WebElement iosButton = driver.findElement(ios_button);
            iosButton.isDisplayed();
        }

        public WebElement checkAndroidButtonText(){
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(android_button));
            WebElement androidButton = driver.findElement(android_button);
            return androidButton;
        }

        public WebElement checkIosButtonText(){
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ios_button));
            WebElement iosButton = driver.findElement(ios_button);
            return iosButton;

        }

        public void checkAndroidButtonClick(){
            WebElement androidButton = driver.findElement(android_button);
            androidButton.click();
        }

        public void checkIosButtonClick(){
            driver.get("https://umobix.com/devices.html");
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ios_button));
            WebElement iosButton = driver.findElement(ios_button);
            iosButton.click();
        }
    }
