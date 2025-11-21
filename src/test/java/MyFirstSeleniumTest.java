import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class MyFirstSeleniumTest {
    static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameInput.sendKeys("Admin");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement pimMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/web/index.php/pim/viewPimModule']")));
        pimMenu.click();

        WebElement newUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Type for hints...'])[1]")));
        newUser.sendKeys("Ravi M B");

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        searchButton.click();

        WebElement userPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Ravi M']")));
        userPage.click();

        WebElement contactDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Contact Details']")));
        contactDetails.click();




    }
}
