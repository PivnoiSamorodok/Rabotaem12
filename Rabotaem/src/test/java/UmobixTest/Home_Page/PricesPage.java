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
        WebElement currency = driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[2]/div[1]/span[1]"));
        Assert.assertEquals(currency.getText(), "€");
    }

    public void OneMonthPriceDisplaying() {
        WebElement price = driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[2]/div[1]"));
        price.isDisplayed();
    }

    public void OneMonthPriceCorrectDuration(){
        WebElement duration = driver.findElement(By.xpath("//form[contains(@class, 'price-plan-card') and contains(@class, 'price-plan-card--min')]//span[contains(@class, 'price-plan-card__price-small') and contains(text(),'/mo')]"));
        Assert.assertEquals(duration.getText(), "/mo");
    }

    public void OneMonthPriceOldOfferDisplaying(){
        WebElement oldOffer = driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[2]/div[2]"));
        oldOffer.isDisplayed();
    }

    public void OneMonthPriceCorrectOldOffer(){
        WebElement oldOffer = driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[2]/div[2]"));
        Assert.assertEquals(oldOffer.getText(), "€ 59.99 /mo");
    }

    public void OneMonthTryNowButtonDisplaying(){
        ////button[contains(@data-mixpanel-plan-type,'1_month')] Что за бред по данному xpath, находит кнопку где то за хедером
        WebElement oneTryNow = driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/button"));
        oneTryNow.isDisplayed();
    }

    public void OneMonthTryNowButtonCorrectText(){
        WebElement oneTryNow = driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/button"));
        Assert.assertEquals(oneTryNow.getText(), "TRY NOW");
    }

    public void OneMonthTryNowButtonClick(){
        WebElement oneTryNow = driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/button"));
        oneTryNow.click();
    }

    public boolean CheckoutURLCompare(String actualURL, String expectedURL){
        Assert.assertTrue(actualURL.contains(expectedURL), "Checkout URL doesnt have expected part");
        return true;
    }
}