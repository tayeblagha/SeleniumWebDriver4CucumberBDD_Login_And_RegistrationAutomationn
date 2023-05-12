package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    public static ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();
    public static WebDriver getDriver() throws IOException {
        if (webdriver.get() == null) {
            webdriver.set(createDriver());
        }
        return webdriver.get();
    }
    private static WebDriver createDriver() throws IOException {
        WebDriver driver = null;
        String browserTYpe = getBrowserType();
        switch (browserTYpe) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            }

            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver");
                System.setProperty("webdriver.firefox.bin", "/snap/bin/firefox");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
               // firefoxOptions.addArguments("--remote-allow-origins=*");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;

    }

    public static void cleanupDriver() {
        webdriver.get().quit();
        webdriver.remove();
    }
    private static String  getBrowserType() throws IOException {
        String browserType=null;
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/driver/properities/config.properties");
       properties.load(file);
        browserType= properties.getProperty("browser").toLowerCase().trim();
        return browserType;
    }



}
