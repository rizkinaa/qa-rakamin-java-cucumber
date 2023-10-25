package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Login {
    WebDriver driver;
    @Given("I Open browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @And("Open website saucedemo")
    public void openWebsiteSaucedemo() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        Thread.sleep(1000);
    }

    @And("Located on saucedemo website")
    public void locatedOnSaucedemoWebsite() {
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @When("I input empty username")
    public void iInputEmptyUsername() {
        driver.findElement(By.name("user-name")).sendKeys("");
    }

    @And("I input valid password")
    public void iInputValidPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String errorMessage) {
        WebElement errorElement = driver.findElement(By.cssSelector(".error-message-container.error"));
        assert(errorElement.getText().contains(errorMessage));
        driver.close();
        driver.quit();
    }

    @When("I input valid username")
    public void iInputValidUsername() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }


    @Then("I go to homepage")
    public void iGoToHomepage() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).isDisplayed();
        driver.close();
        driver.quit();
    }

    @And("Successfully login")
    public void SuccessfullyLogin() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).isDisplayed();
    }

    @And("I click add to cart a product")
    public void IClickAddToCartAProduct() {
        String elementId = "add-to-cart-sauce-labs-backpack";
        driver.findElement(By.id(elementId)).click();
    }


    @And("I click cart icon")
    public void IClickCartIcon() {
        String elementId = "shopping_cart_container";
        driver.findElement(By.id(elementId)).click();
    }

    @And("I click checkout button")
    public void IClickCheckoutButton() {
        String elementId = "checkout";
        driver.findElement(By.id(elementId)).click();
    }

    @And("I fill the form")
    public void IFillTheForm() {
        driver.findElement(By.id("first-name")).sendKeys("kikiluky");
        driver.findElement(By.id("last-name")).sendKeys("novasolo");
        driver.findElement(By.id("postal-code")).sendKeys("50261");
    }

    @Then("I'm in homepage")
    public void iMInHomepage() {
        String elementId = "shopping_cart_container";
        driver.findElement(By.id(elementId)).isDisplayed();
    }

    @And("I click continue button")
    public void iClickContinueButton() {
        String elementId = "continue";
        driver.findElement(By.id(elementId)).click();
    }

    @Then("I click finish button")
    public void iClickFinishButton() {
        String elementId = "finish";
        driver.findElement(By.id(elementId)).click();
    }

    @Then("I should see an success message {string}")
    public void iShouldSeeAnSuccessMessage(String successMsg) {
        WebElement successElement = driver.findElement(By.cssSelector(".complete-header"));
        assert(successElement.getText().contains(successMsg));
        driver.close();
        driver.quit();
    }

    @And("I click icon filter")
    public void iClickIconFilter() {

        Select sel = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        sel.selectByValue("za");
    }

    @And("I select Name Z-A")
    public void iSelectNameZA() {
        Select sel = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        sel.selectByValue("za");
    }

    @Then("I should see Z-A result")
    public void iShouldSeeZAResult() {
        WebElement inventoryList = driver.findElement(By.cssSelector(".inventory_list"));
        String allInventoryText = inventoryList.findElement(By.xpath("..")).getText();
        String[] splittedInventoryText = allInventoryText.split("\n");
        String firstItemName = splittedInventoryText[0].trim();

        assert(firstItemName.equals("Test.allTheThings() T-Shirt (Red)"));
    }

    @When("I click price high to low")
    public void iClickPriceHighToLow() {
        Select sel = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        sel.selectByValue("hilo");
    }

    @Then("I should see filter result")
    public void iShouldSeeFilterResult() {
        WebElement inventoryList = driver.findElement(By.cssSelector(".inventory_list"));
        String itemDescription = inventoryList.findElement(By.xpath("..")).getText();
        String[] descriptionLines = itemDescription.split("\n");

        // The first line should contain "Sauce Labs Fleece Jacket"
//        String itemName = descriptionLines[0].trim();
        String itemName = descriptionLines[2].trim();

        System.out.println(itemName);
        assert(itemName.equals("$49.99"));
//        assert(itemName.equals("Sauce Labs Fleece Jacket"));
        driver.close();
        driver.quit();
    }
}