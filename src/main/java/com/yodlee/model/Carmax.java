package com.yodlee.model;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Carmax {
	public String errorMsg;
	Carmax(){
		errorMsg = "";
	}
	public String scrape(){
		String image = null;
		System. setProperty("webdriver.chrome.driver", "C:\\D_driveFiles\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().setPosition(new Point(-2000, 0));

		try {
			driver.get("https://www4.carmax.com/maintenance/sitedown");
			Thread.sleep(10);

			if(driver.findElement(By.id("maintenancesitedown"))!=null){
			image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			errorMsg = "We're sorry, we couldn't update your account because Site is temporarily down for maintenance. Please try again later. (Error 424)";
			System.out.println("Taking sanpshot of error page...::"+errorMsg);
			driver.quit();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			driver.quit();
			System.exit(0);
		}
		return image;
	}

}
