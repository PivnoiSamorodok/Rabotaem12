package UmobixMainFlowTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DevicePage extends BasePage {

    protected static final String path = "/devices.html";
    private SelenideElement deviceH3 = $(".choose-platform-title");
    private static SelenideElement androidButton = $("[data-localstorege-device=android]");
    private static SelenideElement iosButton = $("[data-localstorege-device=ios]");
    private static final String deviceButton = "//div[@class='devices-card']//span[contains(text(),'%s')]";


    @Override
    List<String> getPaths() {
        return Collections.singletonList(path);
    }

//    @Override
//    String getPath() {
//        return path;
//    }


    public SelenideElement checkDeviceH3TitleVisible() {
        return deviceH3.shouldBe(Condition.visible);
    }

    public SelenideElement isAndroidButtonVisible() {
        return androidButton.shouldBe(Condition.visible);
    }

    public SelenideElement isIosButtonVisible() {
        return iosButton.shouldBe(Condition.visible);
    }

    public SelenideElement checkAndroidButtonTextCorrect() {
        return androidButton.shouldBe(Condition.visible);
    }

    public SelenideElement isIosButtonTextCorrect() {
        return iosButton.shouldBe(Condition.visible);

    }

    public void isDevicesButtonClickable(String deviceType) {
        String devicesButton = String.format(DevicePage.deviceButton, deviceType);
        $x(devicesButton).shouldBe(Condition.visible).click();
    }

    public String compareEmailUrl() {
        return getFullURL();
    }
    //12
}
