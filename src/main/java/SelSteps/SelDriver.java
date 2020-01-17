package SelSteps;

import io.cucumber.datatable.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelDriver {
    private class Link {
        String linkName;
        String found;
        String expected;

        public Link(String name, String exp) {
            this.linkName = name;
            this.expected = exp;
        }
    }

    private WebDriver driver;
    final private String destination = "https://en.wikipedia.org/wiki/Haikyu!!";

    @Given("User is on Google")
    public void user_is_on_Google() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jmchavez\\Downloads\\newchrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com/");
    }

    @When("User Searches")
    public void user_Searches(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        dataTable.asList();
        System.out.println(dataTable);
    }

    @When("Searches Haikyu!!")
    public void searches_Haikyu() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Haikyu!!");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement enterBox = driver.findElement(By.cssSelector("input.gNO89b"));
        enterBox.sendKeys(Keys.ENTER);
    }

    @When("Clicks on the first result")
    public void clicks_on_the_first_result() {
        WebElement firstResult = driver.findElement(By.cssSelector(".r")).findElement(By.tagName("a"));
        firstResult.click();
    }

    @Then("Wikipedia should be on display")
    public void wikipedia_should_be_on_display() {
        assertEquals(driver.getCurrentUrl(), destination);
    }
}
