package UmobixMainFlowTest;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v122.css.model.Value;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {

    private static final SelenideElement container =$(".nav-second-container");
    private SelenideElement headerTryNow = container.$(".try-now-button");

    private static final String path = "?dont-send-to-stat=1";

    @Override
    List<String> getPaths() {
        return Collections.singletonList(path);
    }

    private String getHeaderTryNow(){
        String text = $x(String.valueOf(headerTryNow)).getText();
        return text;
    }

    public void isTryNowHeaderClickable(){
        headerTryNow.shouldBe(visible).click();
    }

    public boolean compareURL(){
        return WebDriverRunner.url().contains(path);
    }

}

