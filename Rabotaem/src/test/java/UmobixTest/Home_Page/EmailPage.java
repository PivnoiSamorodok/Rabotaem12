package UmobixTest.Home_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void emailButtonDisplaying(){
        WebElement emailButton = driver.findElement(By.cssSelector("#tryStep > div > form > button"));
        emailButton.isDisplayed();
    }

    public void emailButtonClick(WebElement emailButton){
        WebElement
    }

}
