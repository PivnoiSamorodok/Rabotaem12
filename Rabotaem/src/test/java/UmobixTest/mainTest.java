//package UmobixTest;
//
//import UmobixTest.Home_Page.homePage;
//import org.checkerframework.checker.units.qual.C;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//
//public class mainTest {
//    static WebDriver driver ;
//    static WebDriverWait wait;
//
//    @BeforeTest
//    public void profileSetup(){
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//    }
//
//    @Test
//public void first(){
//        //homePage homePage = new homePage(driver);
//        driver.get("https://umobix.com/?dont-send-to-stat=1");
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@class, 'try-now-button button button--header button-style-blinking button-style-1') and contains(text(),'Try Now')]")));
//        homePage.clickTryNow();
//    }
//
//@Test
//public void firstTest(){
//    driver.get("https://umobix.com/?dont-send-to-stat=1");
//    //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/header/div/nav/div[2]/div[2]/a")));
//    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@class, 'try-now-button button button--header button-style-blinking button-style-1') and contains(text(),'Try Now')]")));
//    homePage.clickTryNow();
//
//
//    driver.findElement(By.xpath("/html/body/header/div/nav/div[2]/div[2]/a")).click();
//    String currentURL = driver.getCurrentUrl();
//    Assert.assertEquals(currentURL, "https://umobix.com/email.html?dont-send-to-stat=1");
//
//    WebElement emailInput = driver.findElement(By.xpath("//*[contains(@placeholder, 'Enter your valid email')]"));
//    String placeholderValue = emailInput.getAttribute("placeholder");
//
//        if(placeholderValue.equals("Enter your valid email")){
//             System.out.println("Correct Placeholder");
//        } else System.out.println("Error. Incorrect Placeholder");
//
//    emailInput.sendKeys("dmitry_kavunenko+zxc123MT@tchdm.live");
//    String currentEmail = emailInput.getAttribute("value");
//    Assert.assertEquals(currentEmail, "dmitry_kavunenko+zxc123MT@tchdm.live");
//
//    WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"tryStep\"]/div/form/button"));
//    Assert.assertEquals(createAccount.getText(), "Create account".toUpperCase());
//    createAccount.click();
//
//
//
//    String devicesURL = driver.getCurrentUrl();
//    Assert.assertEquals(devicesURL, "https://umobix.com/devices.html?dont-send-to-stat=1");
//    WebElement deviceH3 = driver.findElement(By.xpath("/html/body/div[3]/article/div[2]/div/h3"));
//    Assert.assertTrue(deviceH3.isDisplayed(), "Expected deviceH3 to be displayed");
//
//    WebElement androidButton = driver.findElement(By.xpath("/html/body/div[3]/article/div[2]/div/div/a[1]"));
//    Assert.assertTrue(androidButton.isDisplayed(), "Expected androidButton doesnt displayed");
//
//    WebElement iosButton = driver.findElement(By.xpath("/html/body/div[3]/article/div[2]/div/div/a[2]"));
//    Assert.assertTrue(iosButton.isDisplayed(), "Expected iosButton doesnt displayed");
//
//    Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[3]/article/div[2]/div/div/a[1]/span")).getText(), "Android phone or tablet");
//    Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[3]/article/div[2]/div/div/a[2]/span")).getText(), "iOS, iPhone, iPad");
//
//    androidButton.click();
//
//
//            //Оцениtь данную реализацию проверку url without get params
//    String actualPricesURL = driver.getCurrentUrl();
//    String expectedPricesURL = "https://umobix.com/prices.html";
//    Assert.assertTrue(actualPricesURL.contains(expectedPricesURL), "Expected PricesURL doesnt have expected part" + actualPricesURL);
//    WebElement emailPricesHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div/nav/div[3]/div[1]/span[1]")));
//    Assert.assertTrue(emailPricesHeader.isDisplayed(), "Expected emailPrice to be displayed");
//    Assert.assertEquals(emailPricesHeader.getText(), "dmitry_kavunenko+zxc123MT@tchdm.live");
//
//    }
//    @Test
//    public void OneMonthPrices(){
//        driver.get("https://umobix.com/prices.html?dont-send-to-stat=1");
//        String currentURL = driver.getCurrentUrl();
//        WebElement oneMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[1]/div[1]")));
//        Assert.assertEquals(oneMonth.getText(),"1 Month");
//        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[2]/div[1]/span[1]")).getText(), "€");
//        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[2]/div[1]/span[2]")).getText(), "/mo");
//        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/div[2]/div[2]")).getText(), "€ " +"59.99 " + "/mo");
//        WebElement TryNowOneM = driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[3]/button"));
//        TryNowOneM.click();
//    }
//
//    @Test
//    public void ThreeMonthsPrices(){
//        driver.get("https://umobix.com/prices.html?dont-send-to-stat=1");
//        String currentURL = driver.getCurrentUrl();
//        WebElement threeMonths = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/main/section/div[1]/form[2]/div[1]/div[1]")));
//        Assert.assertEquals(threeMonths.getText(),"3 Month");
//        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[2]/div[2]/div[1]/span[1]")).getText(), "€");
//        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[2]/div[2]/div[1]/span[2]")).getText(), "/mo");
//        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[2]/div[2]/div[2]")).getText(), "€ " +"35.99 " + "/mo");
//        driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[2]/button")).click();
//    }
//
//    @Test
//    public void TwelveMonthsPrices(){
//        driver.get("https://umobix.com/prices.html?dont-send-to-stat=1");
//        String currentURL = driver.getCurrentUrl();
//        WebElement twelveMonths = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/main/section/div[1]/form[1]/div[1]/div[1]")));
//        Assert.assertEquals(twelveMonths.getText(), "12 Month");
//        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[1]/div[2]/div[1]/span[1]")).getText(), "€");
//        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[1]/div[2]/div[1]/span[2]")).getText(), "/mo");
//        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[1]/div[2]/div[2]")).getText(), "€ " +"14.99 " + "/mo");
//        driver.findElement(By.xpath("/html/body/div[4]/main/section/div[1]/form[1]/button")).click();
//
//    }
//}
