package com.yodlee.model;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ICICIBank {

	public String errorMsg;
	public String navigation;

	ICICIBank(){
		errorMsg = "";
		navigation="";
	}
	public String scrape(){
		String image = null;
		System. setProperty("webdriver.chrome.driver", "C:\\D_driveFiles\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().setPosition(new Point(-2000, 0));
		try {
			driver.get("https://infinity.icicibank.com/corp/AuthenticationController?FORMSGROUP_ID__=AuthenticationFG&__START_TRAN_FLAG__=Y&FG_BUTTONS__=LOAD&ACTION.LOAD=Y&AuthenticationFG.LOGIN_FLAG=1&BANK_ID=ICI");
//			driver.findElement(By.xpath("//a[contains(text(),'Continue to Login')]")).click();
//		Thread.sleep(2000);
			driver.findElement(By.name("AuthenticationFG.USER_PRINCIPAL")).sendKeys("xxxxx");
			driver.findElement(By.id("AuthenticationFG.ACCESS_CODE")).sendKeys("xxxxx");
			driver.findElement(By.name("Action.VALIDATE_CREDENTIALS")).click();
			Thread.sleep(200);
			//login
			clickOnElement(driver,"Login ->");

			Actions builder = new Actions(driver);
			WebElement hoverElement = driver.findElement(By.id("MY_ACCOUNTS"));
			builder.moveToElement(hoverElement).perform();
			//accouts
			clickOnElement(driver,"MY_ACCOUNTS -> ");
			
			driver.findElement(By.id("Deposits")).click();
			clickOnElement(driver,"Deposits -> ");
			Thread.sleep(500);
			driver.findElement(By.id("Deposits_FD-Advice")).click();
			clickOnElement(driver,"FD-Advice -> ");
			Thread.sleep(500);
			errorMsg = "We couldn't complete your request because the site asks that you verify your personal details. Please visit the site and follow the prompts to update your information. Once updated you can tap REFRESH to continue. (Error 429)";
			System.out.println("Taking sanpshot of error page...::"+errorMsg);
			image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			clickOnElement(driver,"Update Information is Required");
			driver.quit();
		}
		catch (Exception e) {
			e.printStackTrace();
			driver.quit();
			System.exit(0);
		}
		return image;
	}
	
	public void clickOnElement(WebDriver dr,String clickString){
		navigation+=clickString;	
	}

}
