package UmobixTest.mainFlowTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailPage extends BasePage {

    public static final String path = "/email.html";

    public static final By email_input_selector =By.cssSelector("#tryNowEmail");
    public static final By email_button_selector =By.cssSelector("#tryStep > div > form > button");

    public EmailPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean checkEmailInputVisibility(){
        WebElement emailInput = driver.findElement(email_input_selector);
        return true;
    }

    public String isEmailPlaceholderCorrect(){
        WebElement emailInput = driver.findElement(email_input_selector);
        String placeholder = emailInput.getAttribute("placeholder");
        return placeholder;
    }

    public void checkEmailValueInput(){
        WebElement emailInput = driver.findElement(email_input_selector);
        randomEmailGeneration rndEmail = new randomEmailGeneration(5);
        String randomEmail = rndEmail.GenerateEmail();
        emailInput.sendKeys(randomEmail);
    }

    public WebElement checkEmailButtonVisibility(){
        WebElement emailButton = driver.findElement(email_button_selector);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#tryStep > div > form > button")));
        emailButton.isDisplayed();
        return emailButton;
    }


    public void checkEmailButtonClick(WebElement emailButton){
        emailButton.click();
    }

    public boolean CompareDeviceURl(String actualURL){
        return actualURL.contains("/devices.html");
    }
//12
}
