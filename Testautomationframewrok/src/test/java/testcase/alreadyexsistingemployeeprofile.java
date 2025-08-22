package testcase;

import java.time.Duration;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;


public class anotherexsistingemp {

    @Test
    public void loginWithOtpAndClickMenuToggle() throws InterruptedException {

    	WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tankhapaystag.z13.web.core.windows.net/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		//Find login with OTP link and click on it
		driver.findElement(By.xpath("//a[text()='Login with OTP']")).click();
		
		//Find mobile number field, enter the number and click on send OTP button
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("7777777777");
		driver.findElement(By.xpath("//button")).click();
		
		//Applying Explicit wait to wait for OTP Field
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
		
		//Enter Static OTP and click on Verify OTP button
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("5501");
		driver.findElement(By.xpath("//button")).click();
		
		System.out.println("Line 38");
		Thread.sleep(50000);
		WebDriverWait empwait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu-toggle']")));
		driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
		
		System.out.println("Line39");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[contains(text(), 'Employee M')]")).click();
		
		System.out.println("Line42");
		Thread.sleep(5000);
		
		System.out.println("Line48");
		Thread.sleep(5000);
				driver.findElement(By.xpath("//a[@id='id_Employees134']")).click();
				
				WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));

		            WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(
		                By.xpath("//body/app-root/span[@id='router-main']/app-employees/section/div[@id='wrapper']/div[@id='page-wrapper']/div[@class='container-fluid']/div[@class='row']/div[@class='col-md-12 col-sm-12']/div[@class='card']/div[@class='card-body']/ul[@class='list']/li[1]/div[2]/a[1]")
		            ));

		            targetElement.click();

		            JavascriptExecutor js = (JavascriptExecutor) driver;
		            WebDriverWait exsiwait = new WebDriverWait(driver, Duration.ofSeconds(10));

		            // Wait for the header to be visible
		            WebElement eduSectionHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//h4[text()=' Education Details / Academic Details ']")));

		            // Scroll into view
		            js.executeScript("arguments[0].scrollIntoView(true);", eduSectionHeader);
		            
		            js.executeScript("window.scrollBy(0, -200);");

		            // Optionally move to element (scroll/hover)
//		            Actions actions = new Actions(driver);
//		            actions.moveToElement(eduSectionHeader).perform();

		            // Click the header
		            eduSectionHeader.click();

		            // Wait for and click the Add button
		            WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(
		                By.xpath("//div[div[h4[text()=' Education Details / Academic Details ']]]//a[text()='Add']")));
//		            actions.moveToElement(addButton).click().perform();
		            driver.findElement(By.xpath("//div[div[h4[text()=' Education Details / Academic Details ']]]//a[text()='Add']")).click();		            
		            
		            WebDriverWait efwait = new WebDriverWait(driver, Duration.ofSeconds(30));

		         // Optional: Click the button that opens the modal
		         // driver.findElement(By.id("editButton")).click();
Thread.sleep(50000);
		         // WebElement modal = efwait.until(ExpectedConditions.visibilityOfElementLocated(
		             // By.xpath("//div[contains(@class, 'modal-content')]")
		         // ));
		         Thread.sleep(50000);
		         driver.findElement(By.xpath("//input[@placeholder='Enter course']")).sendKeys("B.Tech");
		         driver.findElement(By.xpath("//input[@placeholder='Enter specialization']")).sendKeys("Computer Science");
		         driver.findElement(By.xpath("//input[@placeholder='Enter country']")).sendKeys("India");
		         driver.findElement(By.xpath("//input[@placeholder='Enter state']")).sendKeys("Karnataka");
		         driver.findElement(By.xpath("//input[@placeholder='Enter University']")).sendKeys("VTU");
		         driver.findElement(By.xpath("//input[@placeholder='Enter course type']")).sendKeys("Full Time");
		         driver.findElement(By.xpath("//input[@placeholder='Enter passing year']")).sendKeys("2022");
		         driver.findElement(By.xpath("//input[@placeholder='Enter percentage/cgpa']")).sendKeys("8.5");

		         driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		            
		            System.out.println("Success");
		            
		            
    }
}
