package screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegisterScreen extends BaseScreen {
    @AndroidFindBy(id="com.loginmodule.learning:id/textInputEditTextName")
    public WebElementFacade fieldName;

    @AndroidFindBy(id="com.loginmodule.learning:id/textInputEditTextEmail")
    public WebElementFacade fieldEmail;

    @AndroidFindBy(id="com.loginmodule.learning:id/textInputEditTextPassword")
    public WebElementFacade fieldPassword;

    @AndroidFindBy(id="com.loginmodule.learning:id/textInputEditTextConfirmPassword")
    public WebElementFacade fieldConfirmPass;

    final private String textButton = "com.loginmodule.learning:id/appCompatButtonRegister";

    @AndroidFindBy(id=textButton)
    public WebElementFacade buttonRegister;

    @AndroidFindBy(id="com.loginmodule.learning:id/appCompatTextViewLoginLink")
    public WebElementFacade linkLogin;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Enter Valid Email']")
    public WebElementFacade errorEmail;

    @AndroidFindBy(id="com.loginmodule.learning:id/snackbar_text")
    public WebElementFacade textSuccesfull;

    public WebElementFacade getMessageErrorDisplayed(String text){
        return find(MobileBy.ByAndroidUIAutomator.xpath("//android.widget.TextView[@text='"+text+"']"));
    }

    public void setName(String text){
        fieldName.sendKeys(text);
    }

    public void setEmail(String text){
        fieldEmail.sendKeys(text);
    }

    public void setFieldPassword(String text){
        fieldPassword.sendKeys(text);
    }

    public void setFieldConfirmPass(String text){
        fieldConfirmPass.sendKeys(text);
    }

    public void clickRegister(){
        buttonRegister.click();
    }

    public void isSuccesfullDisplayed(){
        textSuccesfull.waitUntilVisible().isVisible();
    }
}
