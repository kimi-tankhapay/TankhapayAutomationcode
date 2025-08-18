package testcase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class newroaster {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tankhapaystag.z13.web.core.windows.net/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // ---- Login ----
        driver.findElement(By.xpath("//a[text()='Login with OTP']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("7777777777");
        driver.findElement(By.xpath("//button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("5501");
        driver.findElement(By.xpath("//button")).click();

        // ---- Navigate to Attendance Manage ----
        Thread.sleep(60000); // OTP/session wait
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu-toggle']"))).click();

        WebElement attendanceMenu = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Attendance Manage...']"))
        );
        attendanceMenu.click();
        System.out.println("✅ Clicked on 'Attendance Manage...' menu successfully.");

        // ---- Navigate to Settings ----
        By settingsLocator = By.xpath("(//a[contains(text(),'Settings')])[2]");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(settingsLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        System.out.println("✅ Clicked on 'Settings' successfully!");

        // ---- Navigate to Roster ----
        WebElement rosterMenu = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='id_Roster192']"))
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rosterMenu);
        rosterMenu.click();
        System.out.println("✅ Clicked on 'Roster192' successfully!");

        // ---- Employee Roster Management Page Automation ----

        // 1. Select "Show" dropdown
        WebElement showDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select")));
        Select select = new Select(showDropdown);

        List<WebElement> options = select.getOptions();
        System.out.println("Available dropdown options:");
        for (WebElement option : options) {
            System.out.println(" - " + option.getText());
        }

        // Try selecting valid values only
        String[] expectedOptions = {"10", "20", "50", "100", "All"};
        for (String expected : expectedOptions) {
            boolean found = options.stream().anyMatch(opt -> opt.getText().trim().equals(expected));
            if (found) {
                select.selectByVisibleText(expected);
                System.out.println("✅ Selected: " + expected);
                Thread.sleep(1000);
            } else {
                System.out.println("❌ Option not found in dropdown: " + expected);
            }
        }

        // 2. Select "View Type"
        WebElement viewTypeDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='view-type']"))
        );
        Select selectViewType = new Select(viewTypeDropdown);

        // Loop through all available options safely
        List<WebElement> viewTypes = selectViewType.getOptions();
        System.out.println("Available view types:");
        for (WebElement v : viewTypes) {
            System.out.println(" - " + v.getText());
            selectViewType.selectByVisibleText(v.getText());
            Thread.sleep(1000);
        }

        // 3. Select Date
     // Wait until the date input is visible
        WebElement selectedDateInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='selectedDate']"))
        );

        // Remove 'readonly' attribute (if present)
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly')", selectedDateInput);

        // Clear any pre-filled value
        selectedDateInput.clear();

        // Enter a new date (adjust format according to your app requirement)
        selectedDateInput.sendKeys("20-08-2025");

        System.out.println("✅ Date entered successfully in selectedDate field.");

        // 4. Select Organization Unit
        Select orgUnit = new Select(driver.findElement(By.xpath("//select[@formcontrolname='organizationUnit']")));
        if (orgUnit.getOptions().size() > 1) {
            orgUnit.selectByIndex(1);
        }

        // 5. Select Department
        Select dept = new Select(driver.findElement(By.xpath("//select[@formcontrolname='department']")));
        if (dept.getOptions().size() > 1) {
            dept.selectByIndex(1);
        }

        // 6. Search Employee
        driver.findElement(By.xpath("//input[@placeholder='Search Employee(s)']")).sendKeys("John");

        // 7. Click buttons
        driver.findElement(By.xpath("//button[normalize-space()='Shift Rotation Setting']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Bulk Clear']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Bulk Assign Shift']"))).click();

        // 8. Click Next
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Next →']"))).click();

        System.out.println("✅ Roster Page Automation Completed Successfully!");

        Thread.sleep(5000);
        driver.quit();
    }
}


