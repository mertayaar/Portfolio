package UI_Testing.StepDefinitions;

import UI_Testing.Pages.Locators;
import Utilities.DBUtilities;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class JDBC_Steps {

    Locators locators = new Locators();

    List<List<String>> dataFromDB;

    @When("Send the query to get items on database")
    public void sendTheQueryToGetItemsOnDatabase(DataTable table) {
        List<String> query = table.asList(String.class);
        dataFromDB = DBUtilities.getData(query.get(0));

    }

    @Then("Check if the result match with UI")
    public void checkIfTheResultMatchWithUI() {
        List<WebElement> nameListFromUI = locators.getProductNames();
        List<WebElement> priceListFromUI = locators.getProductPrice();
        System.out.println("priceListFromUI = " + priceListFromUI);
        for (int i = 0; i < nameListFromUI.size(); i++) {
            Assert.assertEquals(nameListFromUI.size(), dataFromDB.size());
            Assert.assertTrue(dataFromDB.get(i).get(1).contains(priceListFromUI.get(i).getText()));
            Assert.assertTrue(dataFromDB.get(i).get(0).contains(nameListFromUI.get(i).getText()));

        }
    }
}
