package Assessment;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.userListTable;

public class AddUser extends base {
	
	excelUtility d= new excelUtility();
	
	@Test(dataProvider="getData")
	public void addUser(String name, String surname, String username, String password,String customer,String role, String email,String cellphone ) throws IOException {
	
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		
		userListTable userlist= new userListTable(driver);
		
		//Validating that user is on User List table
		Assert.assertTrue(userlist.getAddUserButton().isDisplayed());
		
		
		userlist.getAddUserButton().click();
		
		
		userlist.getName().sendKeys(name);
		userlist.getSurname().sendKeys(surname);
		userlist.getUsername().sendKeys(username);
		userlist.getPassword().sendKeys(password);
		
		if(customer.equals("Company AAA")) {
			
			userlist.getCompanyAAA().click();
		}
		else {
			
			userlist.getCompanyBBB().click();
			
		}
		
		
		if(role.equals("Sales Team")) {
			
			userlist.getRole().selectByValue("0");
			}
		
			else if(role.equals("Customer")){
				
				userlist.getRole().selectByValue("1");
				
			}
		
			else if(role.equals("Admin")){
				
				userlist.getRole().selectByValue("2");
			}
		
		userlist.getEmail().sendKeys(email);
		userlist.getCellPhone().sendKeys(cellphone);
		
		
		
		//Submit to add user
		userlist.getSubmitbutton().click();
		driver.close();
		
		
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
