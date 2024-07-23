package UmobixTest.mainFlowTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PricesPage extends BasePage {
    public static final String path = "/prices.html";
    public static final By oneMonthTittle = By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[1]/div[1]");
    public static final By fullPack = By.xpath("/html/body/div[4]/main/section/div[1]/form[1]/div[1]/div[2]");
    public static final By currency = By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[2]/div[1]/span[1]");
    public static final By price = By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[2]/div[1]");
    public static final By duration = By.xpath("//form[contains(@class, 'price-plan-card') and contains(@class, 'price-plan-card--min')]//span[contains(@class, 'price-plan-card__price-small') and contains(text(),'/mo')]");
    public static final By oldOffer = By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[2]/div[2]");
    public static final By oneTryNow = By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/button");
    private static final String buttonProduct = "//div[@class='prices-plans']//input[contains(@value,'%s')]/parent::form/button";

    public PricesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean CompareURL(String currentURL){
        return currentURL.contains("/prices.html");
    }

    public void isOneMonthTittleVisible(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(oneMonthTittle));
        WebElement oneMonthTittle = driver.findElement(PricesPage.oneMonthTittle);
        oneMonthTittle.isDisplayed();
    }

    public WebElement OneMonthTittleCorrectText(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(oneMonthTittle));
        WebElement oneMonthTittle = driver.findElement(PricesPage.oneMonthTittle);
        return oneMonthTittle;
    }

    public void OneMonthFullPackDisplayed(){
        WebElement fullPack = driver.findElement(PricesPage.fullPack);
        fullPack.isDisplayed();
    }
    public WebElement OneMonthFullPackCorrectText(){
            WebElement fullPack = driver.findElement(PricesPage.fullPack);
            return fullPack;
    }
    public WebElement OneMonthCurrencyCheck(){
        WebElement currency = driver.findElement(PricesPage.currency);
        return currency;
    }

    public void isOneMonthPriceVisible() {
        WebElement price = driver.findElement(PricesPage.price);
        price.isDisplayed();
    }

    public WebElement OneMonthPriceCorrectDuration(){
        WebElement duration = driver.findElement(PricesPage.duration);
        return duration;
    }

    public void isOneMonthPriceOldOfferVisible(){
        WebElement oldOffer = driver.findElement(PricesPage.oldOffer);
        oldOffer.isDisplayed();
    }

    public WebElement OneMonthPriceCorrectOldOffer(){
        WebElement oldOffer = driver.findElement(PricesPage.oldOffer);
        return oldOffer;
    }

    public void isOneMonthTryNowButtonVisible(){
        WebElement oneTryNow = driver.findElement(PricesPage.oneTryNow);
        oneTryNow.isDisplayed();
    }

    public WebElement checkOneMonthTryNowButtonCorrectText(){
        WebElement oneTryNow = driver.findElement(PricesPage.oneTryNow);
        return oneTryNow;
    }

//    public void checkOneMonthTryNowButtonClick(){
//        WebElement oneTryNow = driver.findElement(PricesPage.oneTryNow);
//        oneTryNow.click();
//    }

    public boolean isCheckoutURLCorrect(String actualURL){
        return actualURL.contains("https://checkout.umobix.com/en/FR/cart/um_mf1_50/umobix");

    }

    public void TryNowButtonClick(String productId){
        driver.get(BasePage.getFullURL(PricesPage.path));
        String buttonProduct = String.format(PricesPage.buttonProduct, productId);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonProduct)));
        WebElement tryNowButton = driver.findElement(By.xpath(buttonProduct));
        tryNowButton.click();
    }

//    public String returnPath(){
//        return path;
//    }
}