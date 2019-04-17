package mastbit.exchange.POM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import mastbit.exchange.common.ScreenShot;
import mastbit.exchange.common.WaitStatement;

public class Mastbit_profile {

	public WebDriver driver;
	By profile = By.xpath("//a[@href='/profile']");
	By profilein = By.id("profile");
	By changepassword = By.xpath("//*[@id=\"profile-panel\"]/div/div[1]/div[3]/div/div/button");
	By oldpassword = By.name("oldPassword");
	By password = By.name("first_name");
	By confirmpassword = By.name("confirmPassword");
	By passwordchange = By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[4]/div/button");

	By security = By.id("security");
	By loginalert = By.xpath("//*[@id=\"security-panel\"]/div/ul/li[2]/div[2]/div/div/button");
	By loginshieldview = By.xpath("//*[@id=\"security-panel\"]/div/ul/li[3]/div[2]/div/div/button[1]");
	By loginshieldenable = By.xpath("//*[@id=\"security-panel\"]/div/ul/li[3]/div[2]/div/div/button[2]");
	By kyc = By.id("kyc");
	By firstname = By.id("fname");
	By lastname = By.id("lname");
	By dob = By.xpath("//*[@id=\"kyc-panel\"]/div/div/div[2]/form/div[3]/div/div/div/button");
	By dob1 = By.xpath(
			"//*[@id=\"kyc-panel\"]/div/div/div[2]/form/div[3]/div/div/ngx-my-date-picker/div/div/table[2]/tbody/tr[2]/td[2]/div");
	By contact = By.xpath("//input[@formcontrolname='contactNumber']");
	By nationality = By.id("nation");
	By residence = By.id("country");
	By next1 = By.xpath("//*[@id=\"kyc-panel\"]/div/div/div[2]/form/div[7]/div/div/div[2]/button");
	By idnumber = By.xpath("//input[@formcontrolname='idNumber']");
	By idfrontimage = By.xpath("//input[@formcontrolname='idCoverImage']");
	By idbackimage = By.xpath("//input[@formcontrolname='idBackImage']");
	By next2 = By.xpath("//*[@id=\"kyc-panel\"]/div/div[2]/div/form/div[6]/div/div/button[2]");
	By userimage = By.xpath("//*[@id=\"kyc-panel\"]/div/div[2]/form/div[1]/div/div/input");
	By submit = By.xpath("//*[@id=\"kyc-panel\"]/div/div[2]/form/div[3]/div/div/button[2]");
	By level = By.id("level");
	By levelText = By.xpath("//*[@id=\"level-panel\"]/div/div[3]/div[2]/div[4]/p/span");
	By toast1 = By.xpath("//span[@class='toast-message ng-star-inserted']");

	public Mastbit_profile(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void getProfile() throws InterruptedException {
		WebElement element = driver.findElement(profile);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public WebElement getProfileIn() {
		return driver.findElement(profilein);
	}

	public WebElement getChangepassword() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(changepassword));
		return driver.findElement(changepassword);
	}

	public WebElement getOldPassword() {
		return driver.findElement(oldpassword);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getconfirmPassword() {
		return driver.findElement(confirmpassword);
	}

	public WebElement getPasswordchange() {
		return driver.findElement(passwordchange);
	}

	public WebElement getSecurity() {
		return driver.findElement(security);

	}

	public void getLoginalertEnable() throws InterruptedException {
		driver.findElement(loginalert).click();
		Thread.sleep(3000);
		String str = driver.findElement(loginalert).getText();
		System.out.println("LoginAlert is :" + " " + str);
		Thread.sleep(2000);
		driver.findElement(loginalert).click();
		Thread.sleep(3000);
		String str1 = driver.findElement(loginalert).getText();
		System.out.println("LoginAlert is :" + " " + str1);

	}

	public void getLoginShieldEnable() throws InterruptedException {
		driver.findElement(loginshieldenable).click();
		Thread.sleep(3000);
		String str = driver.findElement(loginshieldenable).getText();
		System.out.println("LoginShield is :" + " " + str);
		Thread.sleep(2000);
		driver.findElement(loginshieldenable).click();
		Thread.sleep(3000);
		String str1 = driver.findElement(loginshieldenable).getText();
		System.out.println("LoginShield is :" + " " + str1);

	}

	public void getLoginshieldView() throws InterruptedException, IOException {
		driver.findElement(loginshieldview).click();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		ScreenShot.take_screenshot(driver, "LoginShield");
	}

	public WebElement getKyc() {
		return driver.findElement(kyc);
	}

	public WebElement getFirstname() {
		return driver.findElement(firstname);
	}

	public WebElement getLastname() {
		return driver.findElement(lastname);
	}

	public WebElement getDOB() {
		return driver.findElement(dob);
	}

	public WebElement getDOBActual() {
		return driver.findElement(dob1);
	}

	public WebElement getContact() {
		return driver.findElement(contact);
	}

	public void getNationality(String nation) {
		WebElement nationalityField = driver.findElement(nationality);
		Select select = new Select(nationalityField);
		select.selectByVisibleText(nation);

	}

	public void getResidenceCountry(String country) {
		WebElement countryField = driver.findElement(residence);
		Select select = new Select(countryField);
		select.selectByVisibleText(country);

	}

	public WebElement getNext1() {
		return driver.findElement(next1);
	}

	public WebElement getIdNumber() {
		return driver.findElement(idnumber);
	}

	public void getIdfrontimage() {
		WebElement browse = driver.findElement(idfrontimage);

		browse.sendKeys(System.getProperty("user.dir") + "/Images/37.jpg");

	}

	public void getIdbackimage() {
		WebElement browse = driver.findElement(idbackimage);
		browse.sendKeys(System.getProperty("user.dir") + "/Images/flower.jpg");
	}

	public WebElement getNext2() {
		return driver.findElement(next2);
	}

	public void getUserimage() {
		WebElement browse = driver.findElement(userimage);
		browse.sendKeys(System.getProperty("user.dir") + "/Images/download.jpg");

	}

	public WebElement getSubmit() {
		return driver.findElement(submit);
	}

	public WebElement getLevelClick() {
		return driver.findElement(level);
	}

	public WebElement getLevelText() {
		return driver.findElement(levelText);
	}

	public void getToastMessage() {
		String str = driver.findElement(toast1).getAttribute("innerHTML");
		System.out.println(str);

	}
}
