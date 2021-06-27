package com.chaithra.model;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NwmSite {
	static{
		System.setProperty("webdriver.chrome.driver", "C:\\D_driveFiles\\chromedriver.exe");
	}
	public String errorMsg;
	public String image;
	public static WebDriver driver;
	
	NwmSite(){
		errorMsg = "";
		image="";
	}
	public String scrape(){
		driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(-2000, 0));
		//driver.manage().window().maximize();
		try {
			driver.get("file:///D:/Terms%20of%20Use.html");
			Thread.sleep(10);
			image = driver.getPageSource();
			errorMsg = "Northwestern Mutual Investment Services asks that you accept its new terms and conditions before we can complete your request. (Error 428)";
			System.out.println("Taking sanpshot of error page...::"+errorMsg);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		return image;
	}
	
	
	public String scrape1(){
		System.out.println("Scraping Continue...");
		driver.quit();
		return "  Successfully Refreshed...";
	}
	
	public void scrape2(){
		driver.quit();
	}
}
