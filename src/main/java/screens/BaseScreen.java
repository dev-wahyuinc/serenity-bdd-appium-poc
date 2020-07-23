package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;

public class BaseScreen extends PageObject {

    private String screenPackage = "";

    public AndroidDriver<AndroidElement> androidDriver() {
        return (AndroidDriver<AndroidElement>)
                ((WebDriverFacade) getDriver()).getProxiedDriver();
    }

    public void scrollToText(String text) {
        MobileElement el = androidDriver().findElementByAndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));");
        el.isDisplayed();
    }

    public String getCurrentActivityName() {
        return this.androidDriver().currentActivity();
    }

    public void navigateBack(){
        androidDriver().navigate().back();
    }
}
