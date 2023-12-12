package UI_Testing.StepDefinitions;

import UI_Testing.Pages.Locators;
import Utilities.BaseDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AllStepsDefinitions {

    Locators locators = new Locators();

    @Given("Navigate to Web Page")
    public void navigateToWebPage() {
        BaseDriver.getDriver().get("https://cleverppc.com/prestashop4/.");
    }

    @And("Click on The Element")
    public void clickOnTheElement(DataTable table) {
        List<String> elementNameList = table.asList(String.class);
        for (int i = 0; i < elementNameList.size(); i++) {
            WebElement linkWebElement = locators.getWebElement(elementNameList.get(i));
            locators.clickMethod(linkWebElement);
        }
    }


    @And("Enter Data in Text Box")
    public void enterDataInTextBox(DataTable table) {
        List<List<String>> items = table.asLists(String.class);
        for (int i = 0; i < items.size(); i++) {
            WebElement element = locators.getWebElement(items.get(i).get(0));
            String text = items.get(i).get(1);
            locators.sendKeysMethod(element, text);

        }
    }

    @Then("Verification Process")
    public void verificationProcess(DataTable table) {
        List<List<String>> items = table.asLists(String.class);
        for (int i = 0; i < items.size(); i++) {
            WebElement element = locators.getWebElement(items.get(i).get(0));
            String message = items.get(i).get(1);
            locators.verifyContainsText(element, message);
        }
    }

    @And("Hover On The Element")
    public void hoverOnTheElement(DataTable value) {
        List<String> items = value.asList(String.class);
        for (int i = 0; i < items.size(); i++) {
            WebElement linkWebElement = locators.getWebElement(items.get(i));
            locators.hoverFunction(linkWebElement);
        }

    }

    @And("Verifying that is equal to {string}")
    public void verifyingThatIsEqualTo(String number, DataTable table) {

        List<String> items = table.asList(String.class);
        for (int i = 0; i < items.size(); i++) {
            WebElement linkWebElement = locators.getWebElement(items.get(i));
            locators.verifyContainsText(linkWebElement, number);
        }
    }

    @Then("Length of the {string} list equal to {string}")
    public void lengthOfTheProductListEqualTo(String element, String size) {
        locators.verifyListSize(locators.getWebElementList(element), size);
    }

    @And("Verification is performed and the previous page is returned.")
    public void verificationIsPerformedAndThePreviousPageIsReturned(DataTable table) {
        List<List<String>> items = table.asLists(String.class);
        for (int i = 0; i < items.size(); i++) {
            WebElement element = locators.getWebElement(items.get(i).get(0));
            String word = items.get(i).get(1);
            locators.verifyContainsText(element, word);
        }
        BaseDriver.getDriver().navigate().back();
    }

    @Then("Record Order Reference")
    public void recordOrderReference() {
        locators.recordOrderReference(locators.getSaveRecord());
    }

    @And("Adding Receipt Of Payment File with path {string}")
    public void addingReceiptOfPaymentFile(String path) {
        locators.contactUsFileUploadAction(locators.getChooseFileButton(), path);
    }

    @And("Get Recorded Reference Number on Path {string}")
    public void getRecorderReferenceNumber(String path) {
        List<WebElement> referenceOptions = locators.getReferenceOption();
        String refNumber = locators.fileReaderMethod(path);
        Select refSelect = new Select(locators.getSelectRef());

        for (WebElement refOption : referenceOptions) {
            if (refOption.getText().contains(refNumber.trim())) {
                refSelect.selectByValue(refOption.getAttribute("value"));
                break;
            }

        }


    }

    @And("Select a Product")
    public void selectAProduct() {
        List<WebElement> elementList = locators.getSelectProduct();
        for (WebElement element : elementList) {
            if (element.getAttribute("style").contains("inline-block")) {
                Select productSelect = new Select(element);
                productSelect.selectByIndex(1);
                break;
            }
        }


    }
}
