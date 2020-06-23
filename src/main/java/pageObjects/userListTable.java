package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class userListTable {

	//Declaring variables
	public WebDriver driver;
	By adduser = By.xpath("/html/body/table/thead/tr[2]/td/button");
	By name = By.xpath("//input[contains(@name,'FirstNa')]");
	By surname = By.xpath("//input[contains(@name,'LastNa')]");
	By username = By.xpath("//input[contains(@name,'UserNa')]");
	By password = By.xpath("//input[contains(@name,'Passwo')]");
	By email = By.xpath("//input[contains(@name,'Emai')]");
	By cellphone = By.xpath("//input[contains(@name,'Mobilepho')]");
	By submit = By.xpath("/html/body/div[3]/div[3]/button[2]");
	By companyAAA = By.xpath("//input[@value='15']");
	By companyBBB = By.xpath("//input[@value='16']");
	By tableHeader = By.xpath("/html/body/table/thead/tr[3]");
	By table = By.xpath("/html/body/table");
	
	
	//Constructor for the class object
	public userListTable (WebDriver driver) {
		
		this.driver=driver;
	}
	
	//Getting Table  Element 		
			public WebElement getTable() {
				
					return driver.findElement(table);
			}
	
	//Getting Table Header Element 		
		public WebElement getTableHeader() {
			
				return driver.findElement(tableHeader);
		}
		
	
	//Getting Add User button Element 		
	public WebElement getAddUserButton() {
		
			return driver.findElement(adduser);
	}
	
	//Getting Name input field Element 
	public WebElement getName() {
		
		return driver.findElement(name);
}
	
	//Getting Surname input field Element 
	public WebElement getSurname() {
		
		return driver.findElement(surname);
}
	
	//Getting Username input field Element 
	public WebElement getUsername() {
		
		return driver.findElement(username);
}
	
	//Getting Password input field Element 
	public WebElement getPassword() {
		
		return driver.findElement(password);
}
	
	//Getting Email input field Element 
	public WebElement getEmail() {
		
		return driver.findElement(email);
}
	
	//Getting Cell Phone Number input field Element
	public WebElement getCellPhone() {
		
		return driver.findElement(cellphone);
}
	
	//Getting Submit button field Element
	public WebElement getSubmitbutton() {
		
		return driver.findElement(submit);
}
	
	//Creating an object for the drop down field Element
	public Select getRole() {
		
		Select role= new Select (driver.findElement(By.xpath("//select[contains(@name,'RoleI')]")));
		return role;
}
	
	//Getting Company AAA option field element
	public WebElement getCompanyAAA() {
		
		return driver.findElement(companyAAA);
}
	
	//Getting Company BBB option field element
	public WebElement getCompanyBBB() {
		
		return driver.findElement(companyBBB);
}
	
}
