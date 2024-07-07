package UmobixTest.Home_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class main2 {
    homePage homePage;
    EmailPage EmailPage;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new homePage(driver, wait);
        EmailPage = new EmailPage(driver, wait);

    }

    @Test
    public void HomePageTryNowClick() {
     driver.get("https://umobix.com/?dont-send-to-stat=1");
     homePage.WaitTryNowHeader();
     homePage.TryNowHeaderClick();
     homePage.getRedirectedURL();
     homePage.compareURL(driver.getCurrentUrl(),"https://umobix.com/email.html");
    }

    @Test
    public void emailInputFieldDisplay(){
        EmailPage.inputFieldDisplaying();
    }

    @Test
    public void emailPlaceholderCheck(){
        WebElement emailInput = EmailPage.inputFieldDisplaying();
        EmailPage.emailPlaceholderCheck(emailInput);
    }

    @Test
    public void emailButtonDisplay(){
        EmailPage.emailButtonDisplaying();
    }

    @Test
    public void emailButtonClick(){

    }
}
