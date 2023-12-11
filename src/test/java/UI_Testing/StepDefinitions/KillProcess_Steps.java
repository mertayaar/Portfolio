package UI_Testing.StepDefinitions;

import UI_Testing.Pages.Locators;
import io.cucumber.java.en.And;

public class KillProcess_Steps {
    Locators locators = new Locators();
    @And("Enter Random Email")
    public void enterRandomEmail() {
        locators.sendRandomKeysMethod(locators.getWebElement("emailInput"));

    }
}
