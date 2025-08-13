package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class logintestcase {
    public static void main(String[] args) throws InterruptedException {
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tankhapaystag.z13.web.core.windows.net/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Click "Login with OTP"
            WebElement loginWithOtpLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login with OTP']")));
            loginWithOtpLink.click();
            System.out.println("Clicked Login with OTP");

            // Enter mobile number and click Send OTP
            WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
            mobileInput.sendKeys("7777777777");

            WebElement sendOtpButton = driver.findElement(By.xpath("//button"));
            sendOtpButton.click();
            System.out.println("OTP sent");

            // Wait for OTP input field
            WebElement otpInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
            otpInput.sendKeys("5501");

            WebElement verifyOtpButton = driver.findElement(By.xpath("//button"));
            verifyOtpButton.click();
            System.out.println("OTP Verified");

            // Wait for menu to appear
            WebElement menuToggle = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-toggle")));
            menuToggle.click();
            System.out.println("Menu opened");

            System.out.println("Login Test Passed ✅");

        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Thread.sleep(3000); // just to see result before quit
           
        }
    }
}
