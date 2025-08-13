package testcase;
import java.awt.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addemployee {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tankhapaystag.z13.web.core.windows.net/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
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
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu-toggle']")));
		driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
		

		driver.findElement(By.xpath("//span[contains(text(), 'Employee M')]")).click();
		
		driver.findElement(By.xpath("//a[@id='id_Employees134']")).click();
		
		driver.findElement(By.xpath("//a[text()='Employee ']")).click();
		
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='selector']")));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='selector']")));
		
		 WebElement dropdown = driver.findElement(By.xpath("//select[@id='selector']"));

		 Select select = new Select(dropdown);
		 
		 select.selectByValue("Permanent");
		
		 Thread.sleep(5000);
		//tear down driver

		System.out.println("Success");

	}

}