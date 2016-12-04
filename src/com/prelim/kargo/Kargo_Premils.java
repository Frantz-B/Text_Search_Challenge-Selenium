package com.prelim.kargo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class Kargo_Premils  {

	public static void main(String[] args) throws IOException {
		
		InputStreamReader cin = null;

	      try {
	         cin = new InputStreamReader(System.in);
	         System.out.println("Enter characters, 'q' to quit.");
	         char c;
	         do {
	            c = (char) cin.read();
	            System.out.print(c);
	         } while(c != 'q');
	      }finally {
	         if (cin != null) {
	            cin.close();
	         }
	      }}}