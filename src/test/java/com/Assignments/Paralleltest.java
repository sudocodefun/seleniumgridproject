package com.Assignments;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
public class Paralleltest {
    public WebDriver driver;
    @Parameters({ "bname" })
    @Test
    public void crossBrowserTesting(String bname) throws MalformedURLException, InterruptedException {
        System.out.println("RemoteDriver connectivity is started");
        if (bname.equalsIgnoreCase("chrome")) {
        	ChromeOptions option = new ChromeOptions();
        	driver = new RemoteWebDriver(
        	        new URL("http://localhost:4444"),
        	        option);
        	System.out.println("session created on Chrome");       
        	} else if (bname.equalsIgnoreCase("Firefox")) {
try {
    FirefoxOptions option = new FirefoxOptions();
    driver = new RemoteWebDriver(
            new URL("http://localhost:4444"),
            option);
    System.out.println("session created on Firefox");
} catch (Exception e) {
    System.out.println("Firefox session creation failed");
    e.printStackTrace();}
}       else if (bname.equalsIgnoreCase("edge")) {        	
        	EdgeOptions option = new EdgeOptions();
        	driver = new RemoteWebDriver(
        	        new URL("http://localhost:4444"),
        	        option);
        	System.out.println("session created on Edge");       	        	}
        System.out.println("RemoteDriver connectivity is completed");       
        driver.get("https://example.com/");    
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
