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
		
		// writing string to a file encoded as modified UTF-8
	      DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("file2016.txt"));
	      dataOut.writeUTF("hello");
	      dataOut.writeUTF("dez");
	      dataOut.writeUTF("nuts");

	      // Reading data from the same file
	      DataInputStream dataIn = new DataInputStream(new FileInputStream("file2016.txt"));

	      while(dataIn.available()>0) {
	         String k = dataIn.readUTF();
	         System.out.print(k+" ");
	      }
	   }
	}