package serenity;

import screens.LoginScreen;
import screens.UserProfileInfoScreen;

public class Login {
    public LoginScreen loginScreen;
    public UserProfileInfoScreen userInfrormationScreen;

    public void SubmitLoginForm(String user, String Password) {
        loginScreen.filledEmail(user);
        loginScreen.setPassword(Password);
        loginScreen.buttonLogin.waitUntilClickable().click();
    }
}
