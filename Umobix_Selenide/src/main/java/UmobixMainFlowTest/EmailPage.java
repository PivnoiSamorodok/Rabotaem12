package UmobixMainFlowTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class EmailPage extends BasePage {

    private static final String path = "/email.html";

    private SelenideElement emailInputSelector = $("#tryNowEmail");

    private SelenideElement emailButtonSelector = $(".button--primary");
    @Override
    List<String> getPaths() {
        return Collections.singletonList(path);
    }

    public SelenideElement checkEmailInputVisibility() {
        return emailInputSelector.shouldBe(Condition.visible);
    }

    public SelenideElement checkEmailPlaceholderCorrection() {
        return emailInputSelector;
    }

    public String checkEmailValueInput() {
        RandomEmailGeneration rndEmail = new RandomEmailGeneration(5);
        String randomEmail = rndEmail.GenerateEmail();
        emailInputSelector.val(randomEmail);
        return randomEmail;
    }

    public SelenideElement isEmailButtonVisible() {
        return emailButtonSelector;
    }


    public void clickabilityOfEmailButton() {
        emailButtonSelector.shouldBe(Condition.visible).click();
    }
    //12
    public String compareEmailUrl() {
        return getFullURL();
    }

}
