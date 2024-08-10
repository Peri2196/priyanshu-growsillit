package org.gsit.Qkart;

import java.time.Duration;
import java.util.List;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.pom.Qkart_POM;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Qkat_project extends BaseClass {
	Qkart_POM q;



	@BeforeClass
	@Parameters("browser")
	public void setUp(String browserName) throws Exception {
		launchBrowser(browserName);
		q = new Qkart_POM(driver);
		Thread.sleep(1500);
	}

	@Test(priority = 1)
	public void testClass1() throws Exception {
		boolean loginBtnDisplay = q.getLoginButton().isDisplayed();
		boolean loginBtnEnable = q.getLoginButton().isEnabled();
		boolean regBtnDisplay = q.getRegButton().isDisplayed();
		boolean srchBoxDisplay = q.getSrchTxt().isDisplayed();

		SoftAssert s = new SoftAssert();

		s.assertEquals(loginBtnDisplay, true);
		s.assertEquals(loginBtnEnable, true);
		s.assertEquals(regBtnDisplay, true);
		s.assertEquals(srchBoxDisplay, true);
		s.assertAll();
	}

	@Test(priority = 2)
	public void testClass2() {
		List<WebElement> img = driver.findElements(By.tagName("img"));
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of images : " + img.size());
		System.out.println("Number of links : " + links.size());
	}

	@Test(priority = 3)
	public void testClass3() {
		String srchTxtBox = q.getSrchTxt().getAttribute("placeholder");
		String pagetitle = pageTitle();
		String pageurl = pageUrl();
		String Expt = "https";
		System.out.println(pagetitle);
		System.out.println(pageurl);
		boolean contains = pageurl.contains(Expt);

		SoftAssert s = new SoftAssert();

		s.assertEquals(srchTxtBox, "Search for items/categories");
		s.assertEquals(pagetitle, "QKart");
//		s.assertEquals(pageurl, contains);
		s.assertTrue(contains, "URL does not contain 'https'.");
		s.assertAll();

	}

	@DataProvider(name = "login_data")
	public Object[][] loginData() {
		return new Object[][] { { "admin123", "admin123" } };

	}

	@Test(priority = 4, dataProvider = "login_data")
	public void testClass4(String uid, String pass) {
		q.getLoginButton().click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		q.getUsrNameTxtBox().sendKeys(uid);
		q.getPassTxtBox().sendKeys(pass);

		q.getLoginToQkartBtn().click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		boolean logoutBtnDisplay = q.getLogoutBtn().isDisplayed();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		SoftAssert s = new SoftAssert();

		s.assertEquals(logoutBtnDisplay, true);
		s.assertAll();
	}

	@Test(priority = 5)
	public void testClass5() throws Exception {
		Thread.sleep(6000);
		q.getRocket().click();
		boolean rocketDisplay = q.getRockectCart().isDisplayed();

		if (rocketDisplay) {
			System.out.println("Product has been successfully added to cart");
		} else {
			System.out.println("Product has not been added to cart");
		}

		q.getRocket().click();
		Thread.sleep(4000);
		boolean itemAdded = q.getItemAdded().isDisplayed();

		if (itemAdded) {
			System.out.println("Item Already Added in cart use the cart sidebar to update and delete the item");
		} else {
			System.out.println("Item not added to cart");
		}
		WebElement size = q.getSize();
		Select selet = new Select(size);
		Thread.sleep(8000);
		selet.selectByVisibleText("9");
		Thread.sleep(2000);
		q.getShoe().click();
		Thread.sleep(5000);
		boolean shoeCart = q.getShoeCart().isDisplayed();
		boolean rockectCart = q.getRockectCart().isDisplayed();

		if (shoeCart && rockectCart) {
			System.out.println("Both items are present in cart");
		} else {
			System.out.println("Either one of the item is missing in cart");
			if (rockectCart == false) {
				System.out.println("Racquet is missing");
			} else {
				System.out.println("Shoe is missing");
			}
		}
		Thread.sleep(2000);
		q.getCheckoutBtn().click();

		Thread.sleep(2000);

		String pageTitle = pageTitle();
		System.out.println("Next webpage title : " + pageTitle);

		q.getAddAddress().click();
		Thread.sleep(1500);
		q.getAddressTxt().click();
		Thread.sleep(1500);
		q.getAddressTxt().sendKeys("adasdgsgadfhfgjdfhhkjdghkdfhsdhsdhgsdfhf");
		Thread.sleep(1500);
		q.getAddBtn().click();
		Thread.sleep(1500);
		q.getAddressRdoBtn().click();
		Thread.sleep(1500);
		q.getDeleteBtn().click();
		Thread.sleep(1500);
	}

	@AfterClass
	public void closeTheBrowser() {
		closeBrowser();
	}
}
