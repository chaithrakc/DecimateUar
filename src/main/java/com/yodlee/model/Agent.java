package com.yodlee.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Agent{
	public String errorMsg;
	Agent(){
		errorMsg = "";
	}
	public String scrape(){
		String image = null;
		System. setProperty("webdriver.chrome.driver", "C:\\D_driveFiles\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().window().setPosition(new Point(-2000, 0));
		try {
			driver.get("https://www.usaa.com/?wa_ref=pub_auth_nav_home");
			driver.findElement(By.className("profileWidget-button profileWidget-button--logon font-normal")).click();
			Thread.sleep(100);
			driver.findElement(By.name("j_usaaNum")).sendKeys("Chaithra");
			Thread.sleep(10);
			driver.findElement(By.name("j_usaaPass")).sendKeys("Chaithra");
			Thread.sleep(10);

			driver.findElement(By.className("ent-logon-jump-button")).click();
			Thread.sleep(10);

			if(driver.findElement(By.id("messageLoginErrorLabel"))!=null){
				image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
				errorMsg = "Your login information appears to be incorrect. Please re-enter your credentials. (Error 402)";
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
