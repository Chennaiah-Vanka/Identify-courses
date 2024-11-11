package Test;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import IdentifyCourses.HomePage;
import IdentifyCourses.Institution;
import IdentifyCourses.ScreenShot;
import Utilities.ExcelUtils;

public class Testng {
    WebDriver driver;
    HomePage ho;
    Institution<ScreenShot> inst;
    ScreenShot ss;
    private static final Logger logger = LoggerFactory.getLogger(Testng.class);

    @BeforeClass
    @Parameters({"browser"})
    void URL(String br) {
    	if (br.equals("chrome")) {
//    	    ChromeOptions options = new ChromeOptions();
//    	    Map<String, Object> prefs = new HashMap<>();
//    	    prefs.put("profile.managed_default_content_settings.images", 2);
//    	    options.setExperimentalOption("prefs", prefs);
    	    driver = new ChromeDriver();
    	} else if (br.equals("edge")) {
//    	    EdgeOptions options = new EdgeOptions();
//    	    Map<String, Object> prefs = new HashMap<>();
//    	    prefs.put("profile.managed_default_content_settings.images", 2);
//    	    options.setExperimentalOption("prefs", prefs);
    	    driver = new EdgeDriver();
    	} else if (br.equals("firefox")) {
//    	    FirefoxProfile profile = new FirefoxProfile();
//    	    profile.setPreference("permissions.default.image", 2);
//    	    FirefoxOptions options = new FirefoxOptions();
//    	    options.setProfile(profile);
    	    driver = new FirefoxDriver();
    	}


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.coursera.org/");
        driver.manage().window().maximize();
        ss = new ScreenShot(driver);
        logger.info("Browser initialized and navigated to Coursera");
    }

    // Step 1: Search for web development courses for Beginners level & English Language
    @Test(priority = 1)
    void HomePagesearch() throws InterruptedException, IOException {
        ho = new HomePage(driver);
        ho.searchbutton(); // Clicking on search button and write web development course
        ss.takeScreenshot("HomePagesearch");
        logger.info("Home Page Search Screenshot taken");
        ho.clicksearch(); // Clicking and searching above course
        if(driver.getCurrentUrl().equals("https://www.coursera.org/search?query=Web+Development+Courses&=&language=English"))
        {
        	ho.english();
        	ho.Alllings();
        	ss.takeScreenshot("Languages");
            logger.info("Languages Screenshot taken");
        	ho.langShowResult();
        	ho.difficultyButton();
        	ho.Allleves();
         	ho.beginnerCheckBox();
         	ss.takeScreenshot("Levels");
            logger.info("Levels Screenshot taken");
         	ho.filterSearchButton();
         	ss.takeScreenshot("searchResults");
            logger.info("Search Results Screenshot taken");
        }
        else
        {
        ho.languageselect(); // Selecting the language
        ss.takeScreenshot("Languages");
        logger.info("Languages Screenshot taken");
        ho.levelselect(); // Selecting the level
        ss.takeScreenshot("Levels");
        logger.info("Levels Screenshot taken");
        }
    }

    // Step 1: Extract the course names, details & rating for first 2 courses
    @Test(priority = 2, dependsOnMethods = {"HomePagesearch"})
    void searchResults() throws InterruptedException, IOException {
        logger.info("Current URL: {}", driver.getCurrentUrl());
        ho.CourseTitle(); // First two course titles
        ho.CourseRating(); // First two course ratings
        ho.courseDuration(); // First two course details
    }

    // Step 2: Extract all the languages and different levels with its total count & display them
    @Test(priority = 4, dependsOnMethods = {"HomePagesearch", "searchResults"})
    void languagesandLevels() throws InterruptedException, IOException {
    	if(driver.getCurrentUrl().contains("https://www.coursera.org/search?query=Web%20Development%20Courses&language=English&productDifficultyLevel=Beginner&sortBy=BEST_MATCH&="))
    	{
    		driver.navigate().to("https://www.coursera.org/"); // Navigating back to home page
    	}
    	else
    	{
        ho.Alllanguages(); // Printing all languages
        Thread.sleep(3000);
        ho.Alllevels(); // Printing all levels
        driver.navigate().to("https://www.coursera.org/"); // Navigating back to home page
        Thread.sleep(3000);
    	}
    }

    @Test(priority = 5)
    void Navigate() throws InterruptedException, IOException {
        inst = new Institution<ScreenShot>(driver);
        inst.campusclick(); // Click on my campus
        ss.takeScreenshot("Navigate");
        logger.info("Navigation Screenshot taken");
        inst.locateform(); // Locate form
        Thread.sleep(2000);
    }

    // Step 3: Filling form and capturing error message
    @Test(priority = 6, dataProvider = "formdetails")
    void form(String f_name, String l_name, String email, String phone, String institutiontype, String institutionname, String Jobrole, String department, String whichd, String country, String state) throws InterruptedException, IOException {
        try {
            inst.formdetails(f_name, l_name, email, phone, institutiontype, institutionname, Jobrole, department, whichd, country, state);
            ss.takeScreenshot("form");
            logger.info("Form Screenshot taken");
            inst.submitForm();
            Thread.sleep(3000);
            inst.errormsg();
            ss.takeScreenshot("Error message");
            logger.info("Error message Screenshot taken");
            Thread.sleep(2000);
        } catch (Exception e) {
        	logger.error("Error in form method: {}", e.getMessage(), e);
        }
    }

    @AfterClass
    void close() {
        if (driver != null) {
            //driver.quit();
            logger.info("Browser closed");
        }
    }
	
    @DataProvider(name = "formdetails")
    public Object[][] formdetails() throws Exception {
        int totalRows = 2; 
        int totalCols = 11; 

        String[][] data = new String[totalRows][totalCols];

        for (int i = 1; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                data[i][j] = ExcelUtils.getExcelValue(i, j);
            }
        }

        return data;
    }
         
}
