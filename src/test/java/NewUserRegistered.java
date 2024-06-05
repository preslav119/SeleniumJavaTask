import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewUserRegistered {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://shop.pragmatic.bg/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void userRegistered() {
        WebElement myAcountDropdown = driver.findElement(By.cssSelector(".caret"));
        myAcountDropdown.click();
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();
        WebElement firstNameField = driver.findElement(By.id("input-firstname"));
        firstNameField.sendKeys("Preslav");
        WebElement lastNameField = driver.findElement(By.id("input-lastname"));
        lastNameField.sendKeys("Stoyanov");
        String emailPreFix = RandomStringUtils.randomAlphabetic(6);
        String emailSuFix = RandomStringUtils.randomAlphabetic(3);
        String emailAddress = emailPreFix + "@" + emailSuFix + ".com";
        WebElement emailInputfield = driver.findElement(By.id("input-email"));
        emailInputfield.sendKeys(emailAddress);
        WebElement telephoneNumber = driver.findElement(By.id("input-telephone"));
        telephoneNumber.sendKeys("081111111");
        WebElement passwordField = driver.findElement(By.id("input-password"));
        passwordField.sendKeys("parola123!");
        WebElement passwordConfirm = driver.findElement(By.id("input-confirm"));
        passwordConfirm.sendKeys("parola123!");
        WebElement checkBox = driver.findElement(By.xpath("//div/input[@name='agree']"));
        checkBox.click();
        WebElement continueButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        continueButton.click();
        WebElement assertText = driver.findElement(By.xpath("//div[@id='content']/h1"));
        Assert.assertTrue(assertText.isDisplayed());


    }
}
