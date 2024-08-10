package org.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Qkart_POM {
    public Qkart_POM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Login Button
    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    // Register button
    @FindBy(xpath = "//button[text()='Register']")
    private WebElement regButon;

    // Search box
    @FindBy(xpath = "//input[@name='search']")
    private WebElement srchTxt;

    // Username Text box
    @FindBy(id = "username")
    private WebElement usrNameTxtBox;

    // Password Text box
    @FindBy(id = "password")
    private WebElement passTxtBox;

    // Login to Qkart button
    @FindBy(xpath = "//button[text()='Login to QKart']")
    private WebElement loginToQkartBtn;
    
    //logout Button
    @FindBy(xpath = "//button[text()='Logout']")
    private WebElement logoutBtn;
    
    //add to cart racket
    @FindBy(xpath = "(//button[text()='Add to cart'])[3]")
    private WebElement rocket;
    
    //add to cart shoe
    @FindBy(xpath = "(//button[text()='Add to cart'])[4]")
    private WebElement shoe;
    
    //shoe size Dropdown
    @FindBy(xpath = "(//*[@name='age'])[1]")
    private WebElement size;
    
    //rockt added in cart
    @FindBy(xpath = "(//*[text()='YONEX Smash Badminton Racquet'])[2]")
    private WebElement rockectCart;

	//Shoe added in cart
    @FindBy(xpath = "(//*[text()='Roadster Mens Running Shoes'])[2]")
    private WebElement shoeCart;

	//checkout button
    @FindBy(xpath = "//*[text()='Checkout']")
    private WebElement checkoutBtn;
    
    //item already added
    @FindBy(xpath = "//*[text()='Item already in cart. Use the cart sidebar to update quantity or remove item.']")
    private WebElement itemAdded;
    
    //Add new Address button
    @FindBy(id = "add-new-btn")
    private WebElement addAddress;
    
    //address text box
    @FindBy(xpath = "//*[@placeholder='Enter your complete address']")
    private WebElement addressTxt;
    
    //add button
    @FindBy(xpath = "//*[text()='Add']")
    private WebElement addBtn;
    
    //Address Radio btn
    @FindBy(name = "address")
    private WebElement addressRdoBtn;
    
    //delete Btn
    @FindBy(xpath = "//*[text()=' Delete ']")
    private WebElement deleteBtn;

	// Getters for the WebElements  
    
    public WebElement getAddAddress() {
		return addAddress;
	}

	public WebElement getAddressTxt() {
		return addressTxt;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getAddressRdoBtn() {
		return addressRdoBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
    
    public WebElement getRegButon() {
		return regButon;
	}

	public WebElement getSize() {
		return size;
	}

	public WebElement getRockectCart() {
		return rockectCart;
	}

	public WebElement getShoeCart() {
		return shoeCart;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	public WebElement getItemAdded() {
		return itemAdded;
	}
	
	public WebElement getRocket() {
		return rocket;
	}

	public WebElement getShoe() {
		return shoe;
	}

    public WebElement getLogoutBtn() {
		return logoutBtn;
	}

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getRegButton() {
        return regButon;
    }

    public WebElement getSrchTxt() {
        return srchTxt;
    }

    public WebElement getUsrNameTxtBox() {
        return usrNameTxtBox;
    }

    public WebElement getPassTxtBox() {
        return passTxtBox;
    }

    public WebElement getLoginToQkartBtn() {
        return loginToQkartBtn;
    }
}
