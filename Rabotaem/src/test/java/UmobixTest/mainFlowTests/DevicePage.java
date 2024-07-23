    package UmobixTest.mainFlowTests;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    public class DevicePage extends BasePage {

        public static final String path = "/devices.html";
        public static final By deviceH3 = By.xpath("//h3[contains(@class,'choose-platform-title')]");
        public static final By androidButton = By.xpath("//a[contains(@data-localstorege-device,'android')]");
        public static final By iosButton = By.xpath("//a[contains(@data-localstorege-device,'ios')]");
        private static final String  deviceButton = "//div[@class='devices-card']//span[contains(text(),'%s')]";
            public DevicePage(WebDriver driver, WebDriverWait wait) {
            super(driver, wait);
        }

        public void checkDeviceH3TitleVisiblity(){
            WebElement deviceH3 = driver.findElement(DevicePage.deviceH3);
            deviceH3.isDisplayed();
        }

        public void isAndroidButtonVisible(){
            WebElement androidButton = driver.findElement(DevicePage.androidButton);
            androidButton.isDisplayed();
        }

        public void isIosButtonVisible(){
            WebElement iosButton = driver.findElement(DevicePage.iosButton);
            iosButton.isDisplayed();
        }

        public WebElement checkAndroidButtonText(){
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(androidButton));
            WebElement androidButton = driver.findElement(DevicePage.androidButton);
            return androidButton;
        }

        public WebElement checkIosButtonText(){
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(iosButton));
            WebElement iosButton = driver.findElement(DevicePage.iosButton);
            return iosButton;

        }

        public void checkAndroidButtonClick(){
            WebElement androidButton = driver.findElement(DevicePage.androidButton);
            androidButton.click();
        }

        public void checkIosButtonClick(){
            driver.get("https://umobix.com/devices.html");
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(iosButton));
            WebElement iosButton = driver.findElement(DevicePage.iosButton);
            iosButton.click();
        }

        public void clickDevicesButton(String deviceType){
                driver.get(BasePage.getFullURL(PricesPage.path));
                String devicesButton = String.format(DevicePage.deviceButton, deviceType);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(devicesButton)));
                WebElement buttons = driver.findElement(By.xpath(devicesButton));
                buttons.click();
        }
    }
