package serenity;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import screens.BaseScreen;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Verify {
    BaseScreen screen;

    @Step
    public void ShouldSee(WebElementFacade element){
        assertThat(element.waitUntilPresent().isDisplayed(), is(equalTo(true)));
    }

    @Step
    public void isCurrentlyOnRightActivity(String expectedScreen){
        assertThat(expectedScreen, is(equalTo(screen.getCurrentActivityName())));
    }
    
}
