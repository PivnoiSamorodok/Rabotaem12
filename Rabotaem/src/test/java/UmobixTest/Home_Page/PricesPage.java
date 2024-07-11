package UmobixTest.Home_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PricesPage extends BasePage{
    public PricesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean CompareURL(String currentURL, String expectedURL){
        Assert.assertTrue(currentURL.contains(expectedURL), "Expected pricesURL doesnt have expected part");
        return true;
    }

    public void OneMonthTittleDisplayed(){
        //не нашел варианта лучше чем найти по xpath
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[1]/div[1]")));
        WebElement oneMonthTittle = driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[1]/div[1]"));
        oneMonthTittle.isDisplayed();
    }

    public void OneMonthTittleCorrectText(){
        WebElement oneMonthTittle = driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[1]/div[1]"));
        Assert.assertEquals(oneMonthTittle.getText(), "1 Month");
    }

    public void OneMonthFullPackDisplayed(){
        WebElement fullPack = driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[1]/div[1]/div[2]"));
        fullPack.isDisplayed();
    }
    public void OneMonthFullPackCorrectText(){
            WebElement fullPack = driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[1]/div[1]/div[2]"));
            Assert.assertEquals(fullPack.getText(), "FULL PACK");
    }
    public void OneMonthCurrencyCheck(){
        WebElement currecny = driver.findElement(By)
    }

}