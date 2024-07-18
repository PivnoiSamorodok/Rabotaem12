package UmobixTest.mainFlowTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PricesPage extends BasePage {
    public static final String path = "/prices.html";
    public static final By one_Month_tittle = By.xpath("/html/body/div[4]/UmobixTest.mainFlowTests.main/section/div[1]/form[3]/div[1]/div[1]");
    public static final By full_pack = By.xpath("/html/body/div[4]/UmobixTest.mainFlowTests.main/section/div[1]/form[1]/div[1]/div[2]");
    public static final By Currency = By.xpath("/html/body/div[4]/UmobixTest.mainFlowTests.main/section/div[1]/form[3]/div[2]/div[1]/span[1]");
    public static final By Price = By.xpath("/html/body/div[4]/UmobixTest.mainFlowTests.main/section/div[1]/form[3]/div[2]/div[1]");
    public static final By Duration= By.xpath("//form[contains(@class, 'price-plan-card') and contains(@class, 'price-plan-card--min')]//span[contains(@class, 'price-plan-card__price-small') and contains(text(),'/mo')]");
    public static final By old_offer = By.xpath("/html/body/div[4]/UmobixTest.mainFlowTests.main/section/div[1]/form[3]/div[2]/div[2]");
    public static final By one_try_now = By.xpath("/html/body/div[4]/UmobixTest.mainFlowTests.main/section/div[1]/form[3]/button");
    public PricesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean CompareURL(String currentURL){
        currentURL.contains("/prices.html");
        return true;
    }

    public void isOneMonthTittleVisible(){
        //не нашел варианта лучше чем найти по xpath
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[4]/UmobixTest.mainFlowTests.main/section/div[1]/form[3]/div[1]/div[1]")));
        WebElement oneMonthTittle = driver.findElement(one_Month_tittle);
        oneMonthTittle.isDisplayed();
    }

    public WebElement OneMonthTittleCorrectText(){
        WebElement oneMonthTittle = driver.findElement(one_Month_tittle);
        return oneMonthTittle;
    }

    public void OneMonthFullPackDisplayed(){
        WebElement fullPack = driver.findElement(full_pack);
        fullPack.isDisplayed();
    }
    public WebElement OneMonthFullPackCorrectText(){
            WebElement fullPack = driver.findElement(full_pack);
            return fullPack;
    }
    public WebElement OneMonthCurrencyCheck(){
        WebElement currency = driver.findElement(Currency);
        return currency;
    }

    public void isOneMonthPriceVisible() {
        WebElement price = driver.findElement(Price);
        price.isDisplayed();
    }

    public WebElement OneMonthPriceCorrectDuration(){
        WebElement duration = driver.findElement(Duration);
        return duration;
    }

    public void isOneMonthPriceOldOfferVisible(){
        WebElement oldOffer = driver.findElement(old_offer);
        oldOffer.isDisplayed();
    }

    public WebElement OneMonthPriceCorrectOldOffer(){
        WebElement oldOffer = driver.findElement(old_offer);
        return oldOffer;
    }

    public void OneMonthTryNowButtonDisplaying(){
        ////button[contains(@data-mixpanel-plan-type,'1_month')] Что за бред по данному xpath, находит кнопку где то за хедером
        WebElement oneTryNow = driver.findElement(one_try_now);
        oneTryNow.isDisplayed();
    }

    public WebElement OneMonthTryNowButtonCorrectText(){
        WebElement oneTryNow = driver.findElement(one_try_now);
        return oneTryNow;
    }

    public void OneMonthTryNowButtonClick(){
        WebElement oneTryNow = driver.findElement(one_try_now);
        oneTryNow.click();
    }

    public boolean CheckoutURLCompare(String actualURL){
        actualURL.contains("https://checkout.umobix.com/en/FR/cart/um_mf1_50/umobix");
        return true;
    }
}