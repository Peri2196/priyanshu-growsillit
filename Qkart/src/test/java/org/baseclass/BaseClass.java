package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static Properties prop;

	public void loadProperties() throws IOException {
		FileInputStream file = new FileInputStream(
				"D:\\GSIT\\project\\Work_Space\\Qkart\\src\\test\\java\\config.properties");
		prop = new Properties();
		prop.load(file);
	}

	@Parameters("browser")
	@BeforeClass
	public void launchBrowser(String browserName) throws IOException {
		loadProperties();
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

	public static void launchChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public void edgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	}

	public static void WindowsMaximazer() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String URL) {
		driver.get(URL);
	}

	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String pageUrl() {
		String pageUrl = driver.getCurrentUrl();
		return pageUrl;
	}

	public static void passText(String txt, WebElement ele) {
		ele.sendKeys("txt");
	}

	public static void clckBtn(WebElement ele) {
		ele.click();
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void quiteBrowser() {
		driver.quit();

	}

	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("Location+ imgName.png");
		FileUtils.copyFile(image, f);
	}

	public static Actions a;

	public static void MovetoElement(WebElement targetElement) {
		a = new Actions(driver);
		a.moveToElement(targetElement).perform();
	}

	public static void DragandDrop(WebElement dragElement, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragElement, dropElement);
	}
}