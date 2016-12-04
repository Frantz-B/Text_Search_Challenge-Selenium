package com.prelim.kargo;

import org.openqa.selenium.WebDriver;
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

	//Please configure 'chromeDriverLoc' variable with location of ChromeDriver
	private static String chromeDriverLoc = "/Users/NewUser/Downloads/Automation/chromedriver";
	private static WebDriver cdriver = null;
	
	public static void main(String[] args) {
		
		createKeywordsFile(); //generates text file with the 4 desired search terms
		
		//Initializing Webdriver
		System.setProperty("webdriver.chrome.driver", chromeDriverLoc);				 
		cdriver = new ChromeDriver();
		cdriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		googleSearch("kargo");
		
		navigate_KargoAbout_Page();
		
		googleSearch("kargo");
		
		ArrayList<String> keyWord_Cap = keyWord_Capture();
		for(String keyWord : keyWord_Cap){
			googleSearch(keyWord);
		}
	}
	
	public static void googleSearch(String searchTerm){
		cdriver.get("http://www.google.com");
		cdriver.findElement(By.id("lst-ib")).sendKeys(searchTerm + Keys.RETURN);
	}
	
	public static void navigate_KargoAbout_Page(){
		googleSearch("kargo");
		cdriver.findElement(By.linkText("Website")).click();
		cdriver.findElement(By.className("nav-button__bar")).click();
		cdriver.findElement(By.id("menu-item-6427")).click();
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