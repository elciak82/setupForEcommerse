package webui.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.pages.*;

public class HeaderComponent extends BasePage { //exception

    private final SearchComponent searchBar;

    @FindBy(className = "logo img-fluid")
    private WebElement logo;

    @FindBy(id = "contact-link")
    private WebElement contactUsLink;

    @FindBy(css = "[class='expand-more']")
    private WebElement languageDropdown;

    @FindBy(css = "[class = 'expand-more _gray-darker']")
    private WebElement currencyDropdown;

    @FindBy(css = "[class = 'logout hidden-sm-down']")
    private WebElement signOut;

    @FindBy(className = "user-info")
    private WebElement signIn;

    @FindBy(className = "account")
    private WebElement account;

    @FindBy(id = "_desktop_cart")
    private WebElement cart;

    @FindBy(id = "category-3")
    private WebElement clothesLink;

    @FindBy(id = "category-6")
    private WebElement accessoriesLink;

    @FindBy(id = "category-9")
    private WebElement artLink;

    @FindBy(id = "category-4")
    private WebElement menLink;

    @FindBy(id = "category-5")
    private WebElement womenLink;

    @FindBy(css = "[class = 'account'] span[class = 'hidden-sm-down']")
    private WebElement userFirstNameLastname;

    public HeaderComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        searchBar = new SearchComponent(driver);
    }

    public SearchComponent getSearchBar() {
        return searchBar;
    }

    public WebElement getLogo() {
        logo.isDisplayed();
        return logo;
    }

    @Step("Contact Us link click.")
    public ContactUsPage clickOnContactUsPage() {
        contactUsLink.click();
        return new ContactUsPage(driver);
    }

    @Step("Clothes link click.")
    public ClothesPage clickOnClothesPage() {
        clothesLink.click();
        return new ClothesPage(driver);
    }

    @Step("Accessories link click.")
    public AccessoriesPage clickOnAccessoriesPage() {
        accessoriesLink.click();
        return new AccessoriesPage(driver);
    }

    @Step("Art link click.")
    public ArtPage clickOnArtPage() {
        artLink.click();
        return new ArtPage(driver);
    }

    @Step("Men link click.")
    public MenPage clickOnMenPage() {
        hoverOnElement(clothesLink);
        menLink.click();
        return new MenPage(driver);
    }

    @Step("Women link click.")
    public WomenPage clickOnWomenPage() {
        hoverOnElement(clothesLink);
        womenLink.click();
        return new WomenPage(driver);
    }

    @Step("Sign In link click.")
    public LoginPage clickOnSignIn() {
//        WebDriverWait wait = new WebDriverWait(driver, 2);
//        wait.until(ExpectedConditions.stalenessOf(signIn));
        signIn.click();
        return new LoginPage(driver);
    }

    @Step("Sign Out link click.")
    public LoginPage clickOnSignOut() {
        signOut.click();
        return new LoginPage(driver);
    }

    @Step("Get user data from page header.")
    public String getUserFirstnameLastnameFromPage() {
        fluentWaitForElementDisplayed(userFirstNameLastname);
        return getTextFromWebElement(userFirstNameLastname);
    }

    public HomePage goToHomePage() {
        getLogo().click();
        return new HomePage(driver);
    }

    public FooterComponent getFooter() {
        return new FooterComponent(driver);
    }

    public ProductMiniatureComponent getProductMiniatures() {
        return new ProductMiniatureComponent(driver);
    }

    public void signOut() {
        signOut.click();
    }
}