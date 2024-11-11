package IdentifyCourses;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Institution<ScreenShot> {
	
WebDriver driver;
    //constructor
	public Institution(WebDriver driver)
	{
		this.driver = driver;	
		PageFactory.initElements(driver,this);
	}
	
	 
	 @FindBy(linkText ="For Campus")
	 WebElement campus;
	 
	 @FindBy(xpath="//div[@class=\"useFloatingLabels css-esaiwz\"]")
	 WebElement locateform;
	 
	 @FindBy(id="FirstName")
	 WebElement fname;
	 
	 @FindBy(id="LastName")
	 WebElement lname;
	 
	 @FindBy(id="Email")
	 WebElement mail;
	 
	 @FindBy(id="Phone")
	 WebElement ph;
	 
	 @FindBy(id="Institution_Type__c")
	 WebElement insttype;
	 
	 @FindBy(id="Company")
	 WebElement comp;
	 
	 @FindBy(id="Title")
	 WebElement title;
	 
	 @FindBy(id="Department")
	 WebElement Dept;
	
	 @FindBy(id="What_the_lead_asked_for_on_the_website__c")
	 WebElement Wdescribe;
	
	 @FindBy(id="Country")
	 WebElement Count;
	 
	 @FindBy(id="State")
	 WebElement state;
	 
	 @FindBy(xpath="//button[@class=\"mktoButton\"]")
	 WebElement submitform;
	 
	 @FindBy(id="ValidMsgEmail")
	 WebElement errormsgs;
	 
	public void campusclick() throws InterruptedException
	{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", campus);
		campus.click();
		
	}
	public void locateform()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",locateform);
	}
	
	public void formdetails(String firname,String lasname,String Email,String Phone,String instutype,String companyname,String Title,String Department,String Whdescribe,String Countries,String State)
	{
		fname.sendKeys(firname);
		lname.sendKeys(lasname);
		mail.sendKeys(Email);
		ph.sendKeys(Phone);
		Select ins = new Select(insttype);
		ins.selectByVisibleText(instutype);
		comp.sendKeys(companyname);
		Select role = new Select(title);
        role.selectByVisibleText(Title);
        Select dept = new Select(Dept);
        dept.selectByVisibleText(Department);
        Select whichdescribe = new Select(Wdescribe);
        whichdescribe.selectByVisibleText(Whdescribe);
        Select Country =  new Select(Count);
        Country.selectByVisibleText(Countries);
        Select states = new Select(state);
        states.selectByVisibleText(State);
        
        }
	public void submitForm()
	{
		submitform.click();
	}
	
	public void errormsg()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
	 	js.executeScript("scrollBy(0,-500)");
	    String msg = errormsgs.getText();
	    System.out.println("Error message is: " +msg);
	    TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"\\HackathonScreenShots\\ErrorMsgSS.png");
	
		try 
		{
			FileHandler.copy(source, destination);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.err.println("Error in taking screenshot");
		}
	}
	
	
	

}
