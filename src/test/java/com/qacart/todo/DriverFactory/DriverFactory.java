package com.qacart.todo.DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    public WebDriver IntializeDriver(){

        String browser=System.getProperty("browser","CHROME");
        WebDriver driver;
        switch (browser){
        case "CHROME" :
            WebDriverManager.chromedriver().setup();
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
         driver =new ChromeDriver(options);
        break;
            case "FIREFOX" :
                WebDriverManager.firefoxdriver().setup();
                 driver =new FirefoxDriver();
                break;
            case "EDGE" :
                WebDriverManager.edgedriver().setup();
                driver =new EdgeDriver();
                break;
            default:
                throw  new RuntimeException("browser is not supported");

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;

}}
