package sit707_week2;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation
 * https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver",
				"E:\\New folder\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(2);

		// Load a webpage in chromium browser.
		driver.get(url);

		/*
		 * How to identify a HTML input field - Step 1: Inspect the webpage, Step 2:
		 * locate the input field, Step 3: Find out how to identify it, by id/name/...
		 */

		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Ahsan");

		/*
		 * Find following input fields and populate with values
		 */
		WebElement lastNameElement = driver.findElement(By.id("lastname"));
		lastNameElement.sendKeys("Perera");

		WebElement phoneNumberElement = driver.findElement(By.id("phoneNumber"));
		phoneNumberElement.sendKeys("04578945698");

		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.sendKeys("ahsan@google.com");

		WebElement passwordElement = driver.findElement(By.id("password"));
		passwordElement.sendKeys("Abc@125k");

		WebElement confirmPasswordElement = driver.findElement(By.id("confirmPassword"));
		confirmPasswordElement.sendKeys("Ab@125k");

		WebElement personalButton = driver
				.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[10]/div/button[1]"));
		personalButton.click();

		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		WebElement createAccountButton = driver
				.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[12]/button"));
		createAccountButton.click();

		/*
		 * Take screenshot using selenium API.
		 */
		takeScreenshot(driver, "registration_page");

		// Sleep a while
		sleep(2);

		// close chrome driver
		driver.close();
	}

	

	public static void takeScreenshot(WebDriver driver, String screenshotName) {
		try {
			// Convert WebDriver instance to TakesScreenshot
			TakesScreenshot ts = (TakesScreenshot) driver;

			// Capture screenshot as File object
			File source = ts.getScreenshotAs(OutputType.FILE);

			// Define the destination path
			String destinationPath = "C:\\Users\\Niwanthi Edirisinghe\\Desktop\\Deakin Assigments\\T1 2024\\SIT707\\"
					+ screenshotName + ".png";

			// Copy file to the destination
			FileUtils.copyFile(source, new File(destinationPath));

			System.out.println("Screenshot taken and saved at: " + destinationPath);
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
		}
	}

}