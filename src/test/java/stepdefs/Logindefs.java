package stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Account;
import net.thucydides.core.annotations.Steps;
import serenity.Login;
import serenity.Register;
import serenity.Verify;

public class Logindefs {
    @Steps
    Login loginStep;

    @Steps
    Register register;

    @Steps
    Verify verify;

    private String freshEmailCurrentlyRegister;
    private String password = "test";

    @Before(value="@validlogin", order=1)
    public void registerFirst() {
        loginStep.loginScreen.accesingScreenRegisterFromLinkText();
        register.inputValidRegister();
        this.freshEmailCurrentlyRegister = register.getEmail();
        loginStep.loginScreen.navigateBack();
    }

    @Given("filled email with {string}")
    public void filledEmailWith(String email) {
        loginStep.loginScreen.filledEmail(email);
    }

    @When("submit login")
    public void submitLogin() {
        loginStep.loginScreen.clickLogin();
    }

    @Then("should see alert error Valid Email")
    public void shouldSeeAlertErrorValidEmail() {
        verify.ShouldSee(loginStep.loginScreen.errorEmail);
    }

    @Given("in login screen")
    public void inLoginScreen() {
        verify.isCurrentlyOnRightActivity(loginStep.loginScreen.screenActivityName);
    }

    @When("user wrong password and email")
    public void userWrongPasswordAndEmail() {
        loginStep.SubmitLoginForm(Account.INVALIDEMAIL.getAccount(),password);
    }

    @Then("should see Error Login")
    public void shouldSeeErrorLogin() {
        verify.ShouldSee(loginStep.loginScreen.getLoginError());
    }

    @When("user using unregister email or account")
    public void userUsingUnregisterEmailOrAccount() {
        loginStep.SubmitLoginForm(Account.UNREGISTER.getAccount(),password);
    }

    @When("log in using a valid email address and password")
    public void logInUsingAValidEmailAddressAndPassword() {
        loginStep.SubmitLoginForm(freshEmailCurrentlyRegister,password);
    }

    @Then("should be access to his account")
    public void shouldBeAccessToHisAccount() {
        verify.isCurrentlyOnRightActivity(loginStep.userInfrormationScreen.screenActivityName);
    }
}
