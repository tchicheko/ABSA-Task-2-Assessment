package Assessment;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Resources.base;
import pageObjects.userListTable;

public class AddUser extends base {
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	excelUtility d= new excelUtility();
	
	@BeforeTest
	public void inititialize() throws IOException {
		
		//Webdriver initialization
		driver= initializeDriver();
		log.info("Driver is initialised");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Userlist webpage ");
	}
	
	
	@Test(dataProvider="getData")
	public void addUser(String name, String surname, String username, String password,String customer,String role, String email,String cellphone ) {
		
		
		//Creating object for pageObject model  userListTable class
		userListTable userlist= new userListTable(driver);
		log.info("userlist object created");
		
		//Validating that user is on User List table
		Assert.assertTrue(userlist.getTableHeader().isDisplayed());
		log.info("Validation done for User List Table done");
		
		//Parsing data and performing actions to web elements
		userlist.getAddUserButton().click();
		userlist.getName().sendKeys(name);
		userlist.getSurname().sendKeys(surname);		
		userlist.getUsername().sendKeys(username);
		userlist.getPassword().sendKeys(password);
		
		//Checking option to select for the Customer field considering data provided by the DataProvider
		if(customer.equals("Company AAA")) {
			
			userlist.getCompanyAAA().click();
			log.info("Customer is Company AAA");
			
		}
		else {
			
			userlist.getCompanyBBB().click();
			log.info("Customer is Company BBB");
			
		}
		
		//Checking option to select for the Role field considering data provided by the DataProvider
		if(role.equals("Sales Team")) {
			
			userlist.getRole().selectByValue("0");
			}
		
			else if(role.equals("Customer")){
				
				userlist.getRole().selectByValue("1");
				
			}
		
			else if(role.equals("Admin")){
				
				userlist.getRole().selectByValue("2");
			}
		
		//Parsing data and performing actions to web elements
		userlist.getEmail().sendKeys(email);
		userlist.getCellPhone().sendKeys(cellphone);
		
		
		
		//Click submit to add user
		userlist.getSubmitbutton().click();
		log.info("Submit button clicked");
		
		//Ensuring user has been added to the list
		Assert.assertEquals(userlist.getTable(), username);
		
		
		
	}
	
	//Closing the browser
	@AfterTest
	public void teardown() {
		
		driver.close();
		log.info("Browser closed");
		
	}
	
	
	
	
	
	@DataProvider
	public Object [][] getData(){
		
		Object [][]users= new Object[2][8];
		users[0][0]="FName1";
		users[0][1]="LName1";
		users[0][2]="User1";
		users[0][3]="Pass1";
		users[0][4]="Company AAA";
		users[0][5]="Admin";
		users[0][6]="Admin@mail.com";
		users[0][7]="82555";
		
		users[1][0]="FName2";
		users[1][1]="LName2";
		users[1][2]="User2";
		users[1][3]="Pass2";
		users[1][4]="Company BBB";
		users[1][5]="Customer";
		users[1][6]="cusomter@mail.com";
		users[1][7]="82555";
		
		return users;
		
	}
	


}
