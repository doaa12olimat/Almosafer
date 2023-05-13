package Almosafer;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;



public class Parameters {
	SoftAssert myAssertion = new SoftAssert(); 
	 WebDriver driver;
	 String[] WebSiteURLS = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
	 String[] HotelSearchAr  = { "دﺑﻲ ", "ﱠدة ﺟ " };// list hotel search in ar
	 String[] HotelSearchEn = { "Dubai", "Jeddah"," Riyadh" };// list hotel search in en
		String EnglishwebSite = "https://wwiw.almosafer.com/en"; 
		String ArabicWebsite = "https://www.almosafer.com/ar"; 
		Random rand = new Random();
		Date today = new Date(); 

	 @BeforeTest
		public void mySetup() {

			
			  //*** this method How to solve the problem of inability to use Chrome *****
			  
			  
			  ChromeOptions option = new ChromeOptions();
			  option.addArguments("--remote-allow-origins=*");
			  driver = new ChromeDriver(option);
			  

				String URl = "https://www.google.com/ar";
				driver.get(URl);
				
		}

	

}