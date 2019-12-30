package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//according to page model design
//we have to create corresponded page class
//for each page of application
//login page = login page class
//every page class will store webelements and methods related to that page

public class LoginPage extends BasePage{

    @FindBy(id = "prependedInput") //this line will initialize web element
    public WebElement userNameInput;

    @FindBy(id = "prependedInput2")//without FindBy, web element will be null
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement warningMessage;

    public LoginPage(){ //CONSTRUCTOR
        //it is mandatory if you want to use @FindBy annotation
        //"this" means LoginPage class
        //Driver.get() return Webdriver object
        PageFactory.initElements(Driver.get(),this);
    }

     //reusable login method
    //just call this method to login provide username and password
     //provide username and password as parameters
    //parameters userName and password

    public void login(String userName, String password){
        userNameInput.sendKeys(userName);

        //Keys.ENTER to replace login button  click
        passwordInput.sendKeys(password, Keys.ENTER);


    }

//    Warm UP task!
//    Write a method, under LoginPage class that will login user user certain role:
//    public void login(String role){
//        if(role.equals("driver")){
//            login as driver
//        }else if(role.equals("store.manager")){
//            login as store manager
//        }else if(role.equals("sales.manager")){
//            login as sales manager
//        }
//    }
//    Add cucumber scenario into Login.feature to test it:
//    Given user is on the login page
//    Then user logs in as "role"

//    public void login(){
//        login(ConfigurationReader.getProperty(""));
//    }

    public void login(String role){
        String userName ="";
        String password = ConfigurationReader.getProperty("password");

        switch (role){
            case "driver":
                userName = ConfigurationReader.getProperty("driver.username");
                break;
            case "store manager":
                userName = ConfigurationReader.getProperty("store.manager.username");
                break;
            case "sales manager":
                userName = ConfigurationReader.getProperty("sales.manager.username");
                break;
            default:
                throw new RuntimeException("Invalid role!");
        }

        login(userName,password);
    }



}
