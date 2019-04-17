package mastbit.exchange.POM;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mastbit.exchange.common.BaseBrowser;

public class Mastbit_forgetPassword {
	public WebDriver driver;

	By forgotemail = By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div/div/input");
	By forgotsend = By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[3]/div/button");
	By resetPassword = By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[2]/div/div/input");
	By confirmPassword = By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[3]/div/div/input");
	By submit = By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[5]/div/button");

	public Mastbit_forgetPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getForgotemail() {
		return driver.findElement(forgotemail);
	}

	public void getResetPasswordWindow() throws InterruptedException {
		Thread.sleep(8000);

		Set<String> winHandles = driver.getWindowHandles();
		System.out.println(winHandles.size());

		for (String handle : winHandles) {
			if (!handle.equals(BaseBrowser.parentWinHandle)) {

				driver.switchTo().window(handle);
				Thread.sleep(5000);
				System.out.println("Title of the new window: " + driver.getTitle());

			}
		}
	}

	public WebElement getForgotsend() {
		return driver.findElement(forgotsend);
	}

	public WebElement getPassword() {
		return driver.findElement(resetPassword);

	}

	public WebElement getConfirmPassword() {
		return driver.findElement(confirmPassword);
	}

	public WebElement getSend() {
		return driver.findElement(submit);
	}

}
