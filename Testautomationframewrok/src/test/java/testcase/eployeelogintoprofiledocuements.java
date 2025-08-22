package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class eployeelogintoprofiledocuements {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://emptankhapaystrstaging.z29.web.core.windows.net/login");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Login
            driver.findElement(By.xpath("//input[@placeholder='Enter your registered Mobile number (10 digit)']")).sendKeys("7000000000");
            driver.findElement(By.xpath("//button[contains(text(),'Send OTP')]")).click();

            WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='xxxx']")));
            otpField.sendKeys("9900");
            driver.findElement(By.xpath("//button[contains(text(),'Verify OTP')]")).click();

            System.out.println("✅ OTP entered and verified successfully.");

            // Open Education Details
            // WebElement educationDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    // By.xpath("//h4[contains(text(),'Education Details / Academic Details')]")));
            // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", educationDetails);
            // educationDetails.click();

            // Click Add
            // WebElement addLink = wait.until(ExpectedConditions.elementToBeClickable(
                    // By.xpath("//div[@id='collapseOne21']//a[@title='Edit' and normalize-space()='Add']")));
            // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addLink);
            // addLink.click();

            // Wait for form modal to appear
         // WebElement modal = efwait.until(ExpectedConditions.visibilityOfElementLocated(
            // By.xpath("//div[contains(@class, 'modal-content')]")
        // ));
        // Thread.sleep(50000);
        // driver.findElement(By.xpath("//input[@placeholder='Enter course']")).sendKeys("c.Tech");
        // driver.findElement(By.xpath("//input[@placeholder='Enter specialization']")).sendKeys("Electrical Science");
        // driver.findElement(By.xpath("//input[@placeholder='Enter country']")).sendKeys("ashmir");
        // driver.findElement(By.xpath("//input[@placeholder='Enter state']")).sendKeys("Perla");
        // driver.findElement(By.xpath("//input[@placeholder='Enter University']")).sendKeys("GTU");
        // driver.findElement(By.xpath("//input[@placeholder='Enter course type']")).sendKeys("Fast Time");
        // driver.findElement(By.xpath("//input[@placeholder='Enter passing year']")).sendKeys("2026");
        // driver.findElement(By.xpath("//input[@placeholder='Enter percentage/cgpa']")).sendKeys("9.5");

            // Click Save button inside modal
        // WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                // By.xpath("(//input[@value='Save'])[2]")));

        // Scroll into view (optional)
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);

        // Click the Save button
        // saveButton.click();

        // System.out.println("✅ Second Save button clicked successfully.");
        
        // WebElement workExpSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
               //  By.xpath("(//h4[normalize-space()='Work Experience'])[1]")));

        // Scroll into view
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", workExpSection);

        // Click to expand or interact (if clickable)
        // workExpSection.click();
        
        // WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait for the second "Add" link to be clickable
        // WebElement addLink = wait1.until(ExpectedConditions.elementToBeClickable(
                // By.xpath("(//a[@title='Edit'][normalize-space()='Add'])[2]")));

        // Scroll into view (optional)
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addLink);

        // Click the second "Add" link
        // addLink.click();
        // Thread.sleep(50000);
        // driver.findElement(By.xpath("//input[@placeholder='Enter company name']")).sendKeys("tech solution");
        // driver.findElement(By.xpath("//input[@placeholder='Enter job title ']")).sendKeys("Software Engineer");
        // driver.findElement(By.xpath("//input[@id='expTo']")).sendKeys("01-01-2020");
        // driver.findElement(By.xpath("//input[@id='expTo']")).sendKeys("31-12-2023");
        // driver.findElement(By.xpath("//input[@placeholder='Enter job description']")).sendKeys("Developing software solutions");
        // driver.findElement(By.xpath("//input[@placeholder='Enter skills (eg. : Java, Python)']")).sendKeys("Java, Python");
        // driver.findElement(By.xpath("//input[@placeholder='Total experience']")).sendKeys("6");
        // driver.findElement(By.xpath("//input[@placeholder='Enter 1 last take-home drawn']")).sendKeys("100000");
        // driver.findElement(By.xpath("//input[@placeholder='Enter leaving reason']")).sendKeys("Better career opportunities");
        // driver.findElement(By.xpath("//input[@placeholder='Enter leaving reason']")).sendKeys("Better career opportunities");
        
        // WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait for the first Save button to be clickable
        // WebElement saveButton1 = wait11.until(ExpectedConditions.elementToBeClickable(
                // By.xpath("(//button[normalize-space()='Save'])[1]")));

        // Scroll into view (optional)
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton1);

        // Click the Save button
        // saveButton1.click();
            
        //WebElement trainingSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
                //By.xpath("//h4[normalize-space()='Training/Certification Details']")));

        // Scroll into view
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", trainingSection);

        // Click the section to expand if collapsible
        //trainingSection.click();
        //WebElement thirdAddLink = wait.until(ExpectedConditions.elementToBeClickable(
                //By.xpath("(//a[@title='Edit'][normalize-space()='Add'])[3]")));

        // Scroll into view (optional)
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", thirdAddLink);

        // Click the third "Add" link
        //thirdAddLink.click();
     //Thread.sleep(20000);
         //driver.findElement(By.xpath("//input[@placeholder='eg. Financial Modeling']")).sendKeys("tech solution");
         //Thread.sleep(50000);
         //WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(
        		 
                 //By.id("date_of_completion"))); // Replace with the actual ID of the input field
         //dateField.click();

         // Select a random past year (e.g., 2010 - 2020)
         //Random random = new Random();
         //int randomYear = random.nextInt(11) + 2010; // Random year between 2010 and 2020

         // Select the year from the dropdown
         //WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
         //yearDropdown.click();
         //WebElement yearOption = driver.findElement(By.xpath("//option[text()='" + randomYear + "']"));
         //yearOption.click();

         // Select the correct month (e.g., August)
         //WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
         //monthDropdown.click();
         //WebElement monthOption = driver.findElement(By.xpath("//option[text()='Aug']"));
         //monthOption.click();

         // Now, select a specific day (e.g., 22nd)
         //WebElement day = driver.findElement(By.xpath("//td[contains(text(),'22')]"));
         //day.click();

         //WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));

         // Wait for the first Save button to be clickable
         // WebElement saveButton1 = wait11.until(ExpectedConditions.elementToBeClickable(
                 // By.xpath("(//button[normalize-space()='Save'])[1]")));

         // Scroll into view (optional)
         // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton1);

         // Click the Save button
         // saveButton1.click();

            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Wait for the "Family Details" section
            WebElement familyDetails = wait1.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h4[normalize-space()='Family Details']")));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", familyDetails);

            // Click the "Family Details" section (if collapsible/expandable)
            familyDetails.click();
            WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Wait until the 3rd "Add" link is clickable
            WebElement fourthAdd = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//a[@title='Edit'][normalize-space()='Add'])[4]")));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fourthAdd);

            // Click the element
            fourthAdd.click();
            Thread.sleep(20000);
            driver.findElement(By.xpath("//input[@placeholder='Enter name']")).sendKeys("hgfgf solution");
            WebDriverWait wait111 = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Wait until the 4th "Save" input button is clickable
            WebElement fourthSave = wait111.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//input[@value='Save'])[4]")));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fourthSave);

            // Click the element
            fourthSave.click();
            System.out.println("✅ Fourth 'Save' button clicked successfully.");
            Thread.sleep(50000);
            WebDriverWait wait1111 = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Wait until "Bank Details" heading is clickable
            WebElement bankDetails = wait1111.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//h4[normalize-space()='Bank Details']")));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bankDetails);

            // Click on "Bank Details"
            bankDetails.click();

            System.out.println("✅ 'Bank Details' section clicked successfully.");

        } catch (Exception e) {
            System.out.println("⚠️ Error while clicking (//div[@id='headingOne3'])[1]:");
            e.printStackTrace();

          
        }
    }
}

