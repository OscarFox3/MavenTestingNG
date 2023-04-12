package TestNGCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FormTestCase {

    private WebDriver driver;

    @BeforeClass
    void setUp()
    {
        System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jotform.com/form/201002944857453");
    }

    @AfterClass
    void tearDown()
    {
        System.out.println("Driver Closed");
        driver.close();
    }

    @Test
    void oneAlphabetFirstLastName()
    {
        // To check that first name text field and last name text field should accept at least one alphabet
        System.out.println("This is my first case");
        WebElement firstNameElement = driver.findElement(By.xpath("//*[@id=\"first_11\"]"));
        firstNameElement.sendKeys("Omar");
        WebElement lastNameElement = driver.findElement(By.xpath("//*[@id=\"last_11\"]"));
        lastNameElement.sendKeys("Bosh");
        Assert.assertEquals("Omar",firstNameElement.getAttribute("value"));
        Assert.assertEquals("Bosh",lastNameElement.getAttribute("value"));
        firstNameElement.clear();
        lastNameElement.clear();
    }
    @Test
    void notAcceptNumberLastName()
    {
        // To check that only last name text field should not accept number
        System.out.println("This is my second case");
        WebElement lastNameElement = driver.findElement(By.xpath("//*[@id=\"last_11\"]"));
        lastNameElement.sendKeys("123");
        Assert.assertEquals("123",lastNameElement.getAttribute("value"));
        lastNameElement.clear();
    }
    @Test
    void specialAcceptMiddleName()
    {
        // To check that middle name text field should accept specialchar
        System.out.println("This is my third case");
        WebElement middleNameElement = driver.findElement(By.xpath("//*[@id=\"middle_11\"]"));
        middleNameElement.sendKeys("!");
        Assert.assertEquals("!",middleNameElement.getAttribute("value"));
        middleNameElement.clear();
    }

    @Test
    void radioButtonSelectMale()
    {
        // To check that male radio button should be able to select
        System.out.println("This is my fourth case");
        WebElement maleRadioButton = driver.findElement(By.xpath("//*[@id=\"label_input_19_0\"]"));
        maleRadioButton.click();
    }

    @Test
    void radioButtonSelectFemale()
    {
        // To check that female radio button should be able to select
        System.out.println("This is my fifth case");
        WebElement maleRadioButton = driver.findElement(By.xpath("//*[@id=\"label_input_19_1\"]"));
        maleRadioButton.click();
    }

    @Test
    void radioButtonSelectOthers()
    {
        // To check that others radio button should be able to select
        System.out.println("This is my sixth case");
        WebElement maleRadioButton = driver.findElement(By.xpath("//*[@id=\"label_input_19_2\"]"));
        maleRadioButton.click();
    }

    @Test
    void dateNotNull() {
        // To check that date should not accept null
        System.out.println("This is my seventh case");
        WebElement dayElement = driver.findElement(By.xpath("//*[@id=\"day_15\"]"));
        dayElement.sendKeys("");

        WebElement monthElement = driver.findElement(By.xpath("//*[@id=\"month_15\"]"));
        monthElement.sendKeys("");

        WebElement yearElement = driver.findElement(By.xpath("//*[@id=\"year_15\"]"));
        yearElement.sendKeys("");
    }

    @Test
    void anyDate() {
        // To check you should be able to pick any date
        System.out.println("This is my eighth case");
        WebElement day = driver.findElement(By.xpath("//*[@id=\"day_15\"]"));
        day.sendKeys("14");

        WebElement month = driver.findElement(By.xpath("//*[@id=\"month_15\"]"));
        month.sendKeys("4");

        WebElement year = driver.findElement(By.xpath("//*[@id=\"year_15\"]"));
        year.sendKeys("2005");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"input_17\"]"));
        submitButton.click();

        Assert.assertEquals("14", day.getAttribute("value"));
        Assert.assertEquals("4", month.getAttribute("value"));
        Assert.assertEquals("2005", year.getAttribute("value"));
    }

    @Test
    void cityAlpha() {
        // To check that city text field should accept alphabet
        System.out.println("This is my ninth case");
        WebElement city = driver.findElement(By.xpath("//*[@id=\"input_16_city\"]"));
        city.sendKeys("Naples");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"input_17\"]"));
        submitButton.click();

        Assert.assertEquals("Naples", city.getAttribute("value"));

        city.clear();
    }

    @Test
    void streetAddressAlpha() {
        // To check that street address text field should accept alphabet
        System.out.println("This is my tenth case");
        WebElement streetAddress = driver.findElement(By.xpath("//*[@id=\"input_16_addr_line1\"]"));
        streetAddress.sendKeys("Main Street");

        Assert.assertEquals("Main Street", streetAddress.getAttribute("value"));

        streetAddress.clear();
    }
}

