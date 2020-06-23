package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class userListTable {

	
	public WebDriver driver;
	
	public userListTable (WebDriver driver) {
		
		this.driver=driver;
	}
	
	By adduser = By.xpath("/html/body/table/thead/tr[2]/td/button");
			
	public WebElement getAddUserButton() {
		
			return driver.findElement(adduser);
	}
	
	By name = By.xpath("//input[contains(@name,'FirstNa')]");
	public WebElement getName() {
		
		return driver.findElement(name);
}
	
	By surname = By.xpath("//input[contains(@name,'LastNa')]");
	public WebElement getSurname() {
		
		return driver.findElement(surname);
}
	
	By username = By.xpath("//input[contains(@name,'UserNa')]");
	public WebElement getUsername() {
		
		return driver.findElement(username);
}
	
	By password = By.xpath("//input[contains(@name,'Passwo')]");
	public WebElement getPassword() {
		
		return driver.findElement(password);
}
	
	By email = By.xpath("//input[contains(@name,'Emai')]");
	public WebElement getEmail() {
		
		return driver.findElement(email);
}
	
	By cellphone = By.xpath("//input[contains(@name,'Mobilepho')]");
	public WebElement getCellPhone() {
		
		return driver.findElement(cellphone);
}
	
	By submit = By.xpath("/html/body/div[3]/div[3]/button[2]");
	public WebElement getSubmitbutton() {
		
		return driver.findElement(submit);
}
	
	
	public Select getRole() {
		
		Select role= new Select (driver.findElement(By.xpath("//select[contains(@name,'RoleI')]")));
		return role;
}
	
	By companyAAA = By.xpath("//input[@value='15']");
	public WebElement getCompanyAAA() {
		
		return driver.findElement(companyAAA);
}
	
	By companyBBB = By.xpath("//input[@value='16']");
	public WebElement getCompanyBBB() {
		
		return driver.findElement(companyBBB);
}
	
	//tagName[contains(@attribute,'value')]   /html/body/table/thead/tr[2]/td/button
	//button[contains(@type,'ad')]  /html/body/div[3]/div[2]/form/table/tbody/tr[1]/td[2]/input
}
