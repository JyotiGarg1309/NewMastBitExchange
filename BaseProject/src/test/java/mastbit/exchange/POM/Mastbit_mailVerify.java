package mastbit.exchange.POM;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mastbit.exchange.common.WaitStatement;

public class Mastbit_mailVerify {
	public WebDriver driver;
	public Properties prop;
	By Uname = By.id("inboxfield");
	By go = By.xpath("//span//button[contains(text(),'Go!')]");
	By mailinator = By.xpath("//div[@id='inboxpane']//tr//td");
	By activationLink = By.xpath("//div[@class='inner-section']//span//a[contains(text(),'Activation Link')]");
	By resetLink = By.xpath("//*[@id='scoped-content']/div[2]/div/p[2]/span/a");

	public Mastbit_mailVerify(WebDriver driver, Properties prop) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.prop = prop;
	}

	public void mail_verifyForActivation(String name, String password, String nationality)
			throws InterruptedException, IOException {

		driver.get(prop.getProperty("url2"));
		// WaitStatement.pageLoad(driver, 20);

		driver.findElement(Uname).sendKeys(name);
		driver.findElement(go).click();

		List<WebElement> allmail = driver.findElements(mailinator);

		String MyMailer = "MastBit";

		for (int i = 0; i < allmail.size(); i++) {
			if (allmail.get(i).getText().equals(MyMailer)) {
				System.out.println("Yes we have got mail from " + MyMailer);
				allmail.get(i).click();
				WaitStatement.sleep(3000);

				// Scrolling the window littlebit up

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,100)");

				// switching into iframe to click activation link
				driver.switchTo().frame("msg_body");

				driver.findElement(activationLink).click();

				break;

			}
		}

	}

	public void mail_verifyForPassword(String name, String password, String nationality)
			throws InterruptedException, IOException {

		driver.get(prop.getProperty("url2"));
		// WaitStatement.pageLoad(driver, 20);

		driver.findElement(Uname).sendKeys(name);

		driver.findElement(go).click();

		List<WebElement> allmail = driver.findElements(mailinator);

		String MyMailer = "MastBit";

		for (int i = 0; i < allmail.size(); i++) {
			if (allmail.get(i).getText().equals(MyMailer)) {
				System.out.println("Yes we have got mail from " + MyMailer);
				allmail.get(i).click();

				// Scrolling the window littlebit up
				WaitStatement.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,100)");

				// switching into iframe to click activation link
				driver.switchTo().frame("msg_body");

				driver.findElement(resetLink).click();

				break;

			}

		}

	}
}
