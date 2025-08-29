
package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class newclassbrokenlink {
    public static void main(String[] args) {
        // Set ChromeDriver path if not in system PATH
        // System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String homePage = "http://49.50.117.120/";
        driver.get(homePage);

        // Collect all <a> tags
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());

        for (WebElement element : links) {
            String url = element.getAttribute("href");

            // Skip empty/null href
            if (url == null || url.isEmpty()) {
                System.out.println("URL is empty or not configured");
                continue;
            }

            try {
                HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println(url + " --> Broken link (Status: " + responseCode + ")");
                } else {
                    System.out.println(url + " --> Valid link (Status: " + responseCode + ")");
                }
            } catch (Exception e) {
                System.out.println(url + " --> Exception: " + e.getMessage());
            }
        }

       
    }
}

