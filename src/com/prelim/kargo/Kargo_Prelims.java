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

public class Kargo_Prelims {

	//Please configure 'chrome_Driver_Loc' variable with location of ChromeDriver
	private static final String chrome_Driver_Loc = "/Users/NewUser/Downloads/Automation/chromedriver";
	private static WebDriver cdriver = null;
	private static final String key_Words_Text_File = "Keywords.txt";
	
	public static void main(String[] args) {
		Kargo_Prelims kargo = new Kargo_Prelims();
		kargo.create_Keywords_File(); //generates text file with the 4 desired search terms
		kargo.navigate_KargoAbout_Page_via_Google();
		kargo.search_Keywords_From_File();
	}
	
	Kargo_Prelims(){
		//Initializing Webdriver
		System.setProperty("webdriver.chrome.driver", chrome_Driver_Loc);				 
		cdriver = new ChromeDriver();
		cdriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public static void google_Search(String search_Term){
		cdriver.get("http://www.google.com");
		cdriver.findElement(By.id("lst-ib")).sendKeys(search_Term + Keys.RETURN);
	}
	
	public void create_Keywords_File() {
		String[] key_Words = {"Mobile ad firm" , "Mobile advertising" , "Mobile marketing" , "Mobile internet"};
		
		try (FileWriter key_Word_File = new FileWriter(key_Words_Text_File)){
			for(String key_Word : key_Words){
				key_Word_File.write(key_Word + "\n");
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void navigate_KargoAbout_Page_via_Google(){
		google_Search("kargo");
		cdriver.findElement(By.linkText("Website")).click();
		cdriver.findElement(By.className("nav-button__bar")).click();
		cdriver.findElement(By.id("menu-item-6427")).click();
	}
	
	public void search_Keywords_From_File(){
		//Purposely wanted to use a dynamic array list for scalability
		ArrayList<String> key_Words_Captured = new ArrayList<String>();
		String file_Location = key_Words_Text_File;
		
		try(Scanner file_Reader = new Scanner(new File(file_Location))){
			while (file_Reader.hasNext()){
				key_Words_Captured.add(file_Reader.nextLine());
			}
		} catch (IOException e){
			e.printStackTrace();
		}	
	
		for(String key_Word : key_Words_Captured){
			google_Search(key_Word);
		}
	}

}