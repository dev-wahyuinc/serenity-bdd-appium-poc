package serenity;

import net.thucydides.core.annotations.Step;
import screens.RegisterScreen;
import utils.RandomNumber;

public class Register {
    RegisterScreen registerScreen;
    final private String username = "saprol";
    final private String password = "test";
    final private String emailProvider ="@asem.com";
    private String email;

    public void filledName(String name) {
        registerScreen.setName(name);
    }

    public void filledEmail(String email) {
        registerScreen.setEmail(email);
    }

    public void submitRegister() {
        registerScreen.clickRegister();
    }

    public void checkIsMessageAlertDisplay(String enter_email_valid) {
        registerScreen.getMessageErrorDisplayed(enter_email_valid).waitUntilVisible().isDisplayed();
    }

    public void scrollToLinkRegister(){
        registerScreen.scrollToText("Already a member? Login");
    }

    @Step
    public void filledWithNullData() {
        scrollToLinkRegister();
        registerScreen.clickRegister();
        checkIsMessageAlertDisplay("Enter Full Name");
        registerScreen.fieldName.sendKeys(this.username);
        registerScreen.clickRegister();
        checkIsMessageAlertDisplay("Enter Valid Email");
        registerScreen.fieldEmail.sendKeys("sapr@gmail.com");
        registerScreen.clickRegister();
        checkIsMessageAlertDisplay("Enter Password");
        registerScreen.fieldPassword.sendKeys(this.password);
        registerScreen.clickRegister();
        checkIsMessageAlertDisplay("Password Does Not Matches");
    }


    @Step
    public void inputValidRegister() {
        this.email = "saprol"+ RandomNumber.randomIntegerUntilHundred() + this.emailProvider;
        registerScreen.setName(this.username);
        registerScreen.setEmail(email);
        registerScreen.setFieldPassword(this.password);
        registerScreen.setFieldConfirmPass(this.password);
        scrollToLinkRegister();
        registerScreen.clickRegister();
    }

    public void isRegisterSuccesfull(){
        registerScreen.isSuccesfullDisplayed();
    }

    public String getEmail() {
        return email;
    }
}
