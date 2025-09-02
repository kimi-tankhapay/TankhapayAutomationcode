
package testcase;
import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class conurrenyissue {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1); // To start both together

        Runnable user1 = () -> {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://tankhapaystag.z13.web.core.windows.net/login");
            driver.manage().window().maximize();
            try {
                latch.await(); // Wait for the other thread
                driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("7311416723");
                driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
                driver.findElement(By.xpath("//button[text()='Login']")).click();
                Thread.sleep(3000); // wait for login
                System.out.println("User1 logged in");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }
        };

        Runnable user2 = () -> {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://tankhapaystag.z13.web.core.windows.net/login");
            driver.manage().window().maximize();
            try {
                latch.await();
                driver.findElement(By.xpath("//a[text()='Login with OTP']")).click();
                driver.findElement(By.xpath("//input[@type='text']")).sendKeys("7777777777");
                driver.findElement(By.xpath("//button")).click();
                Thread.sleep(3000); // wait for OTP field
                driver.findElement(By.xpath("//input[@type='password']")).sendKeys("5501");
                driver.findElement(By.xpath("//button")).click();
                System.out.println("User2 logged in");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }
        };

        // Start threads
        Thread t1 = new Thread(user1);
        Thread t2 = new Thread(user2);
        t1.start();
        t2.start();

        latch.countDown(); // Both threads start together

        t1.join();
        t2.join();

        System.out.println("Both users finished login");
    }
}
package testcase;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Concurrecnyciisue_cycle {

    public static void main(String[] args) throws InterruptedException {

        // All users
        String[] users = {
        		"9755580587", "6301062146", "6127944519", "6127946843",
                "6619114552", "8847435955", "7931338077", "9984161233", "7892896968"
            
        };
        String password = "123456";

        CountDownLatch latch = new CountDownLatch(1); // To start all threads together

        // Loop through users and create a thread for each
        for (String user : users) {
            Runnable task = () -> {
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("https://tankhapaystag.z13.web.core.windows.net/login");

                try {
                    latch.await(); // Wait for all threads to be ready

                    // Enter username and password
                    driver.findElement(By.xpath("//input[@type='text' or @placeholder='Username']")).sendKeys(user);
                    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
                    driver.findElement(By.xpath("//button[text()='Login']")).click();

                    Thread.sleep(5000); // Wait for login to complete
                    System.out.println("User " + user + " logged in successfully.");
                } catch (Exception e) {
                    System.out.println("User " + user + " login failed: " + e.getMessage());
                } finally {
                    
                }
            };

            Thread thread = new Thread(task);
            thread.start();
        }

        Thread.sleep(2000); // Small delay to ensure all threads are ready
        latch.countDown(); // Start all logins together

    }
}

