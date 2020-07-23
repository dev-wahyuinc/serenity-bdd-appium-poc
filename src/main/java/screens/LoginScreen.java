package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginScreen extends BaseScreen {
    @AndroidFindBy(id="com.loginmodule.learning:id/textInputEditTextEmail")
    public WebElementFacade fieldEmail;

    @AndroidFindBy(id="com.loginmodule.learning:id/textInputEditTextPassword")
    public WebElementFacade fieldPassword;

    @AndroidFindBy(id="com.loginmodule.learning:id/appCompatButtonLogin")
    public WebElementFacade buttonLogin;

    @AndroidFindBy(id="com.loginmodule.learning:id/textViewLinkRegister")
    public WebElementFacade linkRegister;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Enter Valid Email']")
    public WebElementFacade errorEmail;

    public final String screenActivityName = ".activities.LoginActivity";

    public void filledEmail(String text){
        fieldEmail.clear();
        fieldEmail.sendKeys(text);
    }

    public void setPassword(String text){
        fieldPassword.clear();
        fieldPassword.sendKeys(text);
    }

    public void clickLogin(){
        buttonLogin.click();
    }

    public Boolean getErrorMessage(){
        return errorEmail.waitUntilVisible().isVisible();
    }

    public WebElementFacade getLoginError(){
        return find(By.xpath("//android.widget.TextView[@text='Wrong Email or Password']"));
    }

    public void accesingScreenRegisterFromLinkText() {
        linkRegister.isClickable();
        linkRegister.click();
    }
}
