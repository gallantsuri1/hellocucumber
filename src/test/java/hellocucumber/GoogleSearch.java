package hellocucumber;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class GoogleSearch {

    //mvn clean test -Dwebdriver.gecko.driver=C:\Users\Siri\Downloads\geckodriver.exe
    private WebDriver driver;

    @Before
    public void setUp() {

    }

    @Given("I am on the Google search page")
    public void visitGoogle() {
        driver = new FirefoxDriver();
        driver.navigate().to("https://www.google.com");
    }

    @When("I search for {string}")
    public void searchFor(String query) {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(query);
        element.submit();
    }

    @Then("the page title should start with {string}")
    public void checkTitle(final String title) throws InterruptedException {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10));
        wait.until(webDriver -> webDriver.getTitle().startsWith(title));
        //Thread.sleep(5000);
    }

    @After()
    public void closeBrowser() {
        if (driver != null) driver.quit();
    }
}
