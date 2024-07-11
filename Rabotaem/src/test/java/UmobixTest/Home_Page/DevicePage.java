package UmobixTest.Home_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DevicePage extends BasePage{
    public DevicePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void deviceH3Titlecheck(){
        WebElement deviceH3 = driver.findElement(By.xpath("//h3[contains(@class,'choose-platform-title')]"));
        deviceH3.isDisplayed();
    }

    public void androidButton(){
        WebElement androidButton = driver.findElement(By.xpath("//a[contains(@data-localstorege-device,'android')]"));
        androidButton.isDisplayed();
    }

    public void iosButton(){
        WebElement iosButton = driver.findElement(By.xpath("//a[contains(@data-localstorege-device,'ios')]"));
        iosButton.isDisplayed();
    }

    public void androidButtonText(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(@data-localstorege-device,'android')]")));
        WebElement androidButton = driver.findElement(By.xpath("//a[contains(@data-localstorege-device,'android')]"));
        Assert.assertEquals(androidButton.getText(), "Android phone or tablet");
    }

    public void iosButtonText(){
        WebElement iosButton = driver.findElement(By.xpath("//a[contains(@data-localstorege-device,'ios')]"));
        Assert.assertEquals(iosButton.getText(), "iOS, iPhone, iPad");

    }

    public void androidButtonClick(){
        WebElement androidButton = driver.findElement(By.xpath("//a[contains(@data-localstorege-device,'android')]"));
        androidButton.click();
    }

    public void iosButtonClick(){
        driver.get("https://umobix.com/devices.html");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(@data-localstorege-device,'ios')]")));
        WebElement iosButton = driver.findElement(By.xpath("//a[contains(@data-localstorege-device,'ios')]"));
        iosButton.click();
    }
}
