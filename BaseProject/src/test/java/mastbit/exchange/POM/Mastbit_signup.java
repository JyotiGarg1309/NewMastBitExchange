package mastbit.exchange.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Mastbit_signup {

	public WebDriver driver;
	By okButton = By.xpath("//button[@aria-label='ok']");
	By signupclick = By.xpath("//*[@id=\"app-wrapper\"]/app-header/nav/div[4]/div/ul/li[6]/a");
	By fullname = By.name("fullName");
	By Email = By.name("email");
	By password = By.name("password");
	By confirmpassword = By.name("confirmPassword");
	By nationality = By.name("nationality");
	By agree = By.xpath("/html/body/div[4]/button");
	By register = By.xpath("//button[@type='submit']");
	By check1 = By.xpath("//label[@id='labelTest1']");

	By toast = By.xpath("//span[@class='toast-message ng-star-inserted']");

	public Mastbit_signup(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getOkButtonclick() {
		return driver.findElement(okButton);
	}

	public WebElement getSignupclick() {
		return driver.findElement(signupclick);
	}

	public WebElement getFullName() {

		return driver.findElement(fullname);
	}

	public WebElement getEmail() {
		List<WebElement> allemail = driver.findElements(Email);
		WebElement dr = allemail.get(1);
		return dr;

	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getConfirmPassword() {
		return driver.findElement(confirmpassword);
	}

	public void getNationality(String nation) {
		WebElement nationalityField = driver.findElement(nationality);
		Select select = new Select(nationalityField);
		select.selectByVisibleText(nation);

	}

	public WebElement getagreeClick() {
		return driver.findElement(agree);
	}

	public void getTermsCondition() {
		driver.findElement(check1).click();

	}

	public WebElement getRegister() {
		List<WebElement> allsubmit = driver.findElements(register);
		WebElement dr = allsubmit.get(1);
		return dr;

	}

	public void getToastMessage() {
		String str = driver.findElement(toast).getAttribute("innerHTML");
		System.out.println("Notification Message :" + " " + str);

	}

}
