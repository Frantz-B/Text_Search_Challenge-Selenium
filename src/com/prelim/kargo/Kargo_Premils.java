package com.prelim.kargo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Kargo_Premils {

	public static void main(String[] args) {
		String chromeDriverLoc = "/Users/NewUser/Downloads/Automation/chromedriver";
		System.setProperty("webdriver.chrome.driver", chromeDriverLoc);
		
		WebDriver cdriver = new ChromeDriver();
		cdriver.get("http://www.google.com");
		
		WebElement mike = cdriver.findElement(By.id("lst-ib"));
		String arg0 = "kargo";
		mike.sendKeys(arg0 + Keys.RETURN);
		//Keys ky = new Keys();
		//mike.sendKeys(Keys.RETURN);
		
	}

}