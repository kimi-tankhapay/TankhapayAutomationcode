package testcase;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class excelfile {

    private Sheet sheet;

    // Constructor for Excel reading
    public excelfile(String excelFilePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fis);
            this.sheet = workbook.getSheet(sheetName);
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to fetch Excel cell data
    public String getCellData(int rowNum, int colNum) {
        try {
            Row row = sheet.getRow(rowNum);
            if (row == null) return "";
            Cell cell = row.getCell(colNum);
            if (cell == null) return "";
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // Main test method
    public static void main(String[] args) throws InterruptedException {

        // ✅ STEP 1: Set the path to your chromedriver.exe
    	WebDriverManager.chromedriver().setup(); // <-- UPDATE THIS LINE

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        // ✅ STEP 2: Open the login page
        driver.get("https://tankhapaystag.z13.web.core.windows.net/login");

        // ✅ STEP 3: Login with OTP
        driver.findElement(By.xpath("//a[text()='Login with OTP']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("7777777777");
        driver.findElement(By.xpath("//button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("5501");
        driver.findElement(By.xpath("//button")).click();

        System.out.println("✅ OTP Login Completed");

        // ✅ STEP 4: Navigate to employee form
        Thread.sleep(50000); // Allow time to log in (adjust as needed)
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-toggle"))).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[contains(text(), 'Employee M')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("id_Employees134")).click();

        WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[@class='list']/li[1]/div[2]/a[1]")));
        targetElement.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement eduSectionHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h4[text()=' Education Details / Academic Details ']")));
        js.executeScript("arguments[0].scrollIntoView(true);", eduSectionHeader);
        js.executeScript("window.scrollBy(0, -200);");
        eduSectionHeader.click();

        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[div[h4[text()=' Education Details / Academic Details ']]]//a[text()='Add']")));
        addButton.click();

        // ✅ STEP 5: Read data from Excel and fill the form
        excelfile excelReader = new excelfile("Employee_Details on the way.xlsx", "Sheet1"); // <-- UPDATE

        driver.findElement(By.name("companyName")).sendKeys(excelReader.getCellData(1, 0));
        driver.findElement(By.name("jobTitle")).sendKeys(excelReader.getCellData(1, 1));
        driver.findElement(By.name("fromDate")).sendKeys(excelReader.getCellData(1, 2));
        driver.findElement(By.name("toDate")).sendKeys(excelReader.getCellData(1, 3));
        driver.findElement(By.name("jobDescription")).sendKeys(excelReader.getCellData(1, 4));
        driver.findElement(By.name("skills")).sendKeys(excelReader.getCellData(1, 5));
        driver.findElement(By.name("totalExperience")).sendKeys(excelReader.getCellData(1, 6));
        driver.findElement(By.name("lastTakeHome")).sendKeys(excelReader.getCellData(1, 7));
        driver.findElement(By.name("leavingReason")).sendKeys(excelReader.getCellData(1, 8));

        driver.findElement(By.xpath("//button[text()='Save']")).click();

        System.out.println("✅ Form submitted successfully.");

        // Optional: driver.quit();
    }
}
