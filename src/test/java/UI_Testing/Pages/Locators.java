package UI_Testing.Pages;

import Utilities.BaseDriver;
import Utilities.UI_Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Locators extends UI_Methods {

    public Locators() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }


    // Navigation
    @FindBy(css = "a[class='login']")
    private WebElement signInButton;
    @FindBy(css = "a[title='Contact us']")
    private WebElement contactUsButton;

    // Dialog
    @FindBy(css = "button[name='SubmitCreate']")
    private WebElement createAnAccountButton;

    @FindBy(id = "email_create")
    private WebElement emailCreateInput;

    @FindBy(id = "id_gender2")
    private WebElement mrsRadioButton;

    @FindBy(id = "id_gender1")
    private WebElement mrRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement selectDay;

    @FindBy(id = "months")
    private WebElement selectMonth;

    @FindBy(id = "years")
    private WebElement selectYear;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy(css = "p[class='info-account']")
    private WebElement loginSuccess;

    @FindBy(css = "div[class='alert alert-danger']>p")
    private WebElement loginError;

    @FindBy(css = "p[class*='success']")
    private WebElement alertSuccess;



    @FindBy(id = "message")
    private WebElement contactMessageInput;

    @FindBy(id = "fileUpload")
    private WebElement chooseFileButton;

    @FindBy(css = "select[name='id_order']")
    private WebElement selectRef;

    @FindBy(id = "submitMessage")
    private WebElement sendButton;

    @FindBy(css = "a[title='Addresses']")
    private WebElement myAddressButton;

    @FindBy(css = "a[title='Add an address']")
    private WebElement addAddressButton;

    @FindBy(css = "a[title='Sitemap']")
    private WebElement siteMap;

    @FindBy(css = "a[title*='my addresses']")
    private WebElement addressesButton;


    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "postcode")
    private WebElement postCode;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "phone_mobile")
    private WebElement phoneMobile;

    @FindBy(id = "submitAddress")
    private WebElement addressSaveButton;

    @FindBy(id = "uniform-id_state")
    private WebElement state;

    @FindBy(xpath = "//option[text()='Virginia']")
    private WebElement virginiaOption;

    @FindBy(css = "h3[class='page-subheading']")
    private WebElement addressTitle;

    @FindBy(css = "a[title='Women']")
    private WebElement womenCategory;

    @FindBy(css = "a[title='Summer Dresses']")
    private WebElement summerDresses;

    @FindBy(css = "span[class='cat-name']")
    private WebElement categoryOfProducts;

    @FindBy(css="span[title='Close window']")
    private WebElement closeWindow;

    @FindBy(xpath = "(//div[@class='product-container'])[1]")
    private WebElement product1;

    @FindBy(xpath = "(//div[@class='product-container'])[2]")
    private WebElement product2;

    @FindBy(xpath = "(//div[@class='product-container'])[3]")
    private WebElement product3;

    @FindBy(xpath = "(//a[@title='Add to cart'])[1]")
    private WebElement addToCart1;

    @FindBy(xpath = "(//a[@title='Add to cart'])[2]")
    private WebElement addToCart2;

    @FindBy(xpath = "(//a[@title='Add to cart'])[3]")
    private WebElement addToCart3;

    @FindBy(css = "span[class='title']")
    private WebElement cartLayerTitle;

    @FindBy(css = "a[title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "span[class='heading-counter']")
    private WebElement headingCounter;

    @FindBy(xpath = "(//a[text()='Dresses'])[2]")
    private WebElement dresses;

    @FindBy(xpath = "(//div[@class='product-count'])[2]")
    private WebElement bottomProductCount;

    @FindBy(css = "div[class='product-container']")
    private List<WebElement> productList;

    @FindBy(css = "span[title='Continue shopping']>span")
    private WebElement continueShoppingButton;

    @FindBy(id = "button_order_cart")
    private WebElement checkOutButton;

    @FindBy(css = "a[title='View my shopping cart']")
    private WebElement shoppingCart;

    @FindBy(css = "td[class='cart_product']")
    private List<WebElement> cartItemList;

    //CHECKOUT

    @FindBy(css = "p>a[title='Proceed to checkout']")
    private WebElement proceedToCheckOut;

    @FindBy(css = "button[name='processAddress']")
    private WebElement processTheAddress;

    @FindBy(id = "uniform-cgv")
    private WebElement checkBox;

    @FindBy(css = "button[name='processCarrier']")
    private WebElement checkOutButton2;

    @FindBy(id = "paypal-standard-btn")
    private WebElement paypalButton;

    @FindBy(css = "div[class='message']")
    private WebElement paypalMessage;

    @FindBy(css = "a[href*='javascript']")
    private WebElement creditCardButton;

    @FindBy(tagName = "body")
    private WebElement creditCardMessage;

    @FindBy(css = "a[class='bankwire']")
    private WebElement bankWireButton;

    @FindBy(xpath = "//span[text()='I confirm my order']")
    private WebElement confirmButton;

    @FindBy(css = "div[class='box']")
    private WebElement saveRecord;

    // Contact Us

    @FindBy(id = "uniform-id_contact")
    private WebElement subjectHeading;

    @FindBy(css = "option[value='2']")
    private WebElement customerServiceOption;

    @FindBy(xpath = "//select[@name='id_order']/parent::div")
    private WebElement orderReference;

    @FindBy(css = "select[name='id_order']>option")
    private List<WebElement> referenceOption;

    @FindBy(css = "select[name='id_product']")
    private List<WebElement> selectProduct;

    @FindBy(xpath = "(//select[@name='id_product']//option)[2]")
    private WebElement selectProductOption;

    // Kill Process
    @FindBy(css="a[title='Manage my personal information']")
    private WebElement personalInformation;

    @FindBy(id="old_passwd")
    private WebElement currentPasswordInput;

    @FindBy(id="confirmation")
    private WebElement confirmPassword;

    @FindBy(css = "button[name='submitIdentity']")
    private WebElement saveButton;
    public WebElement getSelectProductOption() {
        return selectProductOption;
    }

    public WebElement getSelectRef() {
        return selectRef;
    }

    public WebElement getChooseFileButton() {
        return chooseFileButton;
    }

    public WebElement getSaveRecord() {
        return saveRecord;
    }

    public List<WebElement> getReferenceOption() {
        return referenceOption;
    }

    public List<WebElement> getSelectProduct() {
        return selectProduct;
    }

    public List<WebElement> getWebElementList(String elementName) {
        switch (elementName) {
            case "productList":
                return this.productList;
            case "cartItemList":
                return this.cartItemList;
            case "referenceOption":
                return this.referenceOption;
            case"selectProduct":
                return this.selectProduct;
        }
        return null;
    }

    public WebElement getWebElement(String elementName) {
        switch (elementName) {
            case "signInButton":
                return this.signInButton;
            case "contactUsButton":
                return this.contactUsButton;
            case "createAnAccountButton":
                return this.createAnAccountButton;
            case "emailCreateInput":
                return this.emailCreateInput;
            case "mrsRadioButton":
                return this.mrsRadioButton;
            case "mrRadioButton":
                return this.mrRadioButton;
            case "firstNameInput":
                return this.firstNameInput;
            case "lastNameInput":
                return this.lastNameInput;
            case "emailInput":
                return this.emailInput;
            case "passwordInput":
                return this.passwordInput;
            case "registerButton":
                return this.registerButton;
            case "loginButton":
                return this.loginButton;
            case "loginSuccess":
                return this.loginSuccess;
            case "loginError":
                return this.loginError;
            case "address1":
                return this.address1;
            case "city":
                return this.city;
            case "postCode":
                return this.postCode;
            case "phone":
                return this.phone;
            case "phoneMobile":
                return this.phoneMobile;
            case "contactMessageInput":
                return this.contactMessageInput;
            case "selectRef":
                return this.selectRef;
            case "sendButton":
                return this.sendButton;
            case "myAddressButton":
                return this.myAddressButton;
            case "addAddressButton":
                return this.addAddressButton;
            case "addressSaveButton":
                return this.addressSaveButton;
            case "state":
                return this.state;
            case "virginiaOption":
                return this.virginiaOption;
            case "addressTitle":
                return this.addressTitle;
            case "siteMap":
                return this.siteMap;
            case "addressesButton":
                return this.addressesButton;
            case "womenCategory":
                return this.womenCategory;
            case "summerDresses":
                return this.summerDresses;
            case "categoryOfProducts":
                return this.categoryOfProducts;
            case "product1":
                return this.product1;
            case "product2":
                return this.product2;
            case "product3":
                return this.product3;
            case "addToCart1":
                return this.addToCart1;
            case "addToCart2":
                return this.addToCart2;
            case "addToCart3":
                return this.addToCart3;
            case "cartLayerTitle":
                return this.cartLayerTitle;
            case "proceedToCheckoutButton":
                return this.proceedToCheckoutButton;
            case "headingCounter":
                return this.headingCounter;
            case "dresses":
                return this.dresses;
            case "bottomProductCount":
                return this.bottomProductCount;
            case "continueShoppingButton":
                return this.continueShoppingButton;
            case "checkOutButton":
                return this.checkOutButton;
            case "shoppingCart":
                return this.shoppingCart;
            case "proceedToCheckOut":
                return this.proceedToCheckOut;
            case "processTheAddress":
                return this.processTheAddress;
            case "checkBox":
                return this.checkBox;
            case "checkOutButton2":
                return this.checkOutButton2;
            case "paypalButton":
                return this.paypalButton;
            case "paypalMessage":
                return this.paypalMessage;
            case "creditCardButton":
                return this.creditCardButton;
            case "creditCardMessage":
                return this.creditCardMessage;
            case "bankWireButton":
                return this.bankWireButton;
            case "confirmButton":
                return this.confirmButton;
            case "alertSuccess":
                return this.alertSuccess;
            case "subjectHeading":
                return this.subjectHeading;
            case "customerServiceOption":
                return this.customerServiceOption;
            case "orderReference":
                return this.orderReference;
            case "selectProductOption":
                return this.selectProductOption;
            case "personalInformation":
                return this.personalInformation;
            case "currentPasswordInput":
                return this.currentPasswordInput;
            case "confirmPassword":
                return this.confirmPassword;
            case "saveButton":
                return this.saveButton;
            case "closeWindow":
                return this.closeWindow;

        }
        return null;

    }
}
