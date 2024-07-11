package UmobixTest.Home_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EmailPage extends BasePage{

    public EmailPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement inputFieldDisplaying(){
        WebElement emailInput = driver.findElement(By.cssSelector("#tryNowEmail"));
        //Нужно ли писать такой if ли он не имеет смысла для кейса с отображением кнопки
        if(emailInput.isDisplayed()){
            System.out.println("Email input field is displaying");
        } else System.out.println("Expected email input field isnt displayed");
        return emailInput;
    }

    public void emailPlaceholderCheck(WebElement emailInput){
        String placeholder = emailInput.getAttribute("placeholder");
        Assert.assertEquals(placeholder, "Enter your valid email", "Inccorrect placeholder name");
    }

    public WebElement emailValueInput(WebElement emailInput){
        emailInput.sendKeys("dmitry_kavunenko+zxc123MT@tchdm.live");
        String currentEmail = emailInput.getAttribute("value");
        Assert.assertEquals(currentEmail, "dmitry_kavunenko+zxc123MT@tchdm.live");
        return emailInput;
    }

    public WebElement emailButtonDisplaying(){
        WebElement emailButton = driver.findElement(By.cssSelector("#tryStep > div > form > button"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#tryStep > div > form > button")));
        emailButton.isDisplayed();
        return emailButton;
    }


    public void emailButtonClick(WebElement emailButton){
        emailButton.click();
    }

    public boolean compareDeviceURl(String actualURL, String expectedURL){
        Assert.assertTrue(actualURL.contains(expectedURL), "Expected deviceURL doesnt have expected part");
        return true;
    }
//12
}
