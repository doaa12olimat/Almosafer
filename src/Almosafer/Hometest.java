package Almosafer;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Hometest extends Parameters {
	//*******language is correct*******
	@Test(priority =1 )
	public void check_the_website_default_language() {

		if (driver.getCurrentUrl().equals(EnglishwebSite)) {

			WebElement HTMLPAGE = driver.findElement(By.tagName("html"));
			String Actual = HTMLPAGE.getAttribute("lang");
			String Expected = "en";

			myAssertion.assertEquals(Actual, Expected);

		}
		else if (driver.getCurrentUrl().equals(ArabicWebsite)) {
			WebElement HTMLPAGE = driver.findElement(By.tagName("html"));
			String Actual = HTMLPAGE.getAttribute("lang");
			String Expected = "ar";

			AssertJUnit.assertEquals(Actual, Expected);

		} 
	}
	//***************************default currency is correct(SAR)***********************************
	
@Test(priority = 2)
public void checkSar () throws InterruptedException {
	Thread.sleep(3000);
	String [] mywebsitelnguge= {"https://www.almosafer.com/ar","https://www.almosafer.com/en"};
	
	driver.get(mywebsitelnguge[0]);
	String Actualrsa=driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/div[1]/div/button")).getText();
	
	System.out.println("currency is   "+Actualrsa);
	
myAssertion .assertEquals(Actualrsa,"SAR");

}
	
	//****************Contact number are correct*********************
	
@Test(priority = 3)
public void CONTACTNUMBER () throws InterruptedException {
	Thread.sleep(3000);
	String Actual=driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[2]")).getText();
	
	System.out.println("Contact number  "+Actual);
myAssertion .assertEquals(Actual,"+966554400000");

}
	//*******•	Verify “qitaf” logo is displayed in footer. **********
	
@Test(priority = 4)
public void TestlogoQetaf () throws InterruptedException {
	Thread.sleep(3000);
	WebElement DIVcontaintqitaf= driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/div[3]/div[3]/div[1]/div[2]/div/div[2]"));
	List<WebElement> divgitaf =DIVcontaintqitaf.findElements(By.tagName("svg"));
	String ExpectedQitafId="Footer__QitafLogo";
	String Actualqitafid=divgitaf.get(0).getAttribute("data-testid");
	myAssertion .assertEquals(Actualqitafid,ExpectedQitafId);

}
	
	
	
	
	
	
//**5.	Randomly select “1 room, 2 adults, 0 children” or “1 room, 1 adult, 0 children” option.
	  @Test(priority = 5 ,invocationCount = 5) 
	  
	  public void SelectRoom() throws InterruptedException {
		  Thread.sleep(3000);
	  Random rand = new Random();
	  int RandomNumber= rand.nextInt(500)%2;
	  driver.get("https://www.almosafer.com/en");
	  String [] SelectValue= {"A","B"};
	  
	  driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]")).click();
	  WebElement Dropdwn= driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[3]/div/select" ));
	  Select select = new Select(Dropdwn);
	  
	
	  
	  
	  }
	  
	 
	 
	
//******	Click on search hotels button.
 @Test(priority = 6)
  public void ClickSearchbuttom(){
	driver.get("https://www.almosafer.com/en");
	WebElement SearchButtom =driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[2]/div/div[2]/div"));

	SearchButtom.findElement(By.tagName("button")).click();
	
	
}
 
 //******•	Flight departure date is set to “today+1day” by default.
 
 @Test(priority = 7)
 public void Flightdeparture() throws InterruptedException {
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-flights\"]/div")).click();
	
	 WebElement SearchDate =driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[3]/div/div/div[1]/div[1]")); 
	String actual= SearchDate.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[3]/div/div/div[1]/div[1]/span[2]")).getText();
	
	Calendar cal=new GregorianCalendar(); 
	int day= cal.get(Calendar.DAY_OF_MONTH);
	System.out.println( "date is  " +day);
	int exp1=1+day;
	 String expected=String.valueOf(exp1);
	System.out.println(expected);
	 System.out.println("departure date"+actual);  
	 
	 myAssertion.assertEquals(actual,expected);
	  myAssertion.assertAll(); 
 }

	
//•	*******Flight return date is set to “today+2days” by default.
 @Test(priority = 8)
 public void Flightreturn() throws InterruptedException {
	 Thread.sleep(3000);
	 
	
	 WebElement SearchDate =driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[3]/div/div/div[1]/div[2]")); 
	String actual= SearchDate.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[3]/div/div/div[1]/div[2]/span[2]")).getText();
	
	Calendar cal=new GregorianCalendar(); 
	int date= cal.get(Calendar.DAY_OF_MONTH);
	System.out.println(date);

	 int returndate=date+2;
	 String expected=String.valueOf(returndate); 
	System.out.println(expected);
	 System.out.println("return date  "+expected);  
	 myAssertion.assertEquals(actual,expected );
	  myAssertion.assertAll(); 
 }

 
//*******3.	Use random method to change language (sometime keep AR, sometime change to EN)
	@Test(priority = 9,invocationCount=5)
	public void CheckOnLang() throws InterruptedException

	{	Thread.sleep(3000);
		
		
		int RandomNumber= rand.nextInt(2);
		System.out.println( RandomNumber);
		driver.get(WebSiteURLS[RandomNumber]);
		String ActualTitle=driver.getTitle();//get title to test language
		
	  if (RandomNumber == 1) {
		 myAssertion .assertEquals(ActualTitle,"المسافر: رحلات، فنادق، أنشطة ممتعة و تذاكر طيران");
	  } else {
			   
		myAssertion .assertEquals(ActualTitle,"Almosafer: Flights, Hotels, Activities & Airlines Ticket Booking") ;
		   
	  }
 
 
	}
 
	
	
	@Test(priority = 10)
	public void hotelsearch() throws InterruptedException

	{	Thread.sleep(3000);
		
		
		int RandomNumber= rand.nextInt(2);
		int RandomNumber1= rand.nextInt(3);
		System.out.println( RandomNumber);
		driver.get(WebSiteURLS[RandomNumber]);
		
		 if (RandomNumber == 0) {
			 driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div/input")).sendKeys(HotelSearchEn[RandomNumber1]); 
			 
		 } else {
				   
			  driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div/input")).sendKeys(HotelSearchAr[RandomNumber]);
			 
		 }
 
	}
 
	
	
	
	
	
	
 
 
 
 
 
 
 @AfterTest
	public void myAfterTest() {
		myAssertion.assertAll();

	}
	
}

	