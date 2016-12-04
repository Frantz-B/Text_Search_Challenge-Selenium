package com.prelim.kargo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Kargo_Premils {

	public static void main(String[] args) {
		
		String chromeDriverLoc = "/Users/NewUser/Downloads/Automation/chromedriver";
		System.setProperty("webdriver.chrome.driver", chromeDriverLoc);
		
		WebDriver cdriver = new ChromeDriver();
		cdriver.get("http://www.google.com");
		cdriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		WebElement mike = cdriver.findElement(By.id("lst-ib"));
		String arg0 = "kargo";
		mike.sendKeys(arg0 + Keys.RETURN);
		
		
		cdriver.findElement(By.linkText("Website")).click();
		
		cdriver.findElement(By.className("nav-button__bar")).click();
		cdriver.findElement(By.id("menu-item-6427")).click();
		
		cdriver.get("http://www.google.com");
		WebElement me = cdriver.findElement(By.id("lst-ib"));
		String arg1 = "kargo";
		me.sendKeys(arg1 + Keys.RETURN);
		
		
		// Mobile ad firm
		// Mobile advertising
		// Mobile marketing
		// Mobile internet
		createKeywordsFile();
		ArrayList<String> keyWord_Cap = keyWord_Capture();
		System.out.println(keyWord_Cap);
		for(String keyWord : keyWord_Cap){
			cdriver.get("http://www.google.com");
			cdriver.findElement(By.id("lst-ib")).sendKeys(keyWord + Keys.RETURN);
		}
	}
	
	public static void createKeywordsFile() {
		String[] keyWords = {"Mobile ad firm" , "Mobile advertising" , "Mobile marketing" , "Mobile internet"};
		FileWriter key_Word_File = null;
		
		try {
			key_Word_File = new FileWriter("Keywords.txt");
			for(String key_Word : keyWords){
				key_Word_File.write(key_Word + "\n");
			}
			key_Word_File.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> keyWord_Capture(){
		ArrayList<String> keyWords_Captured = new ArrayList<String>();
		String fileLocation = "Keywords.txt";
		Scanner fileReader = null;
		
		try{
			fileReader = new Scanner(new File(fileLocation));
			while (fileReader.hasNext()){
				keyWords_Captured.add(fileReader.nextLine());
			}
			fileReader.close();
		} catch (IOException e){
			e.printStackTrace();
		}	
		return keyWords_Captured;
	}

}