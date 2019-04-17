package mastbit.exchange.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import mastbit.exchange.POM.Mastbit_createTicket;
import mastbit.exchange.common.ScreenShot;
import mastbit.exchange.common.WaitStatement;

public class CreateTicket {
	public WebDriver driver;

	public CreateTicket(WebDriver driver) {
		this.driver = driver;
	}

	public void createTicket() throws IOException, InterruptedException {
		Mastbit_createTicket ct = new Mastbit_createTicket(driver);
		ct.getYourTicket();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		ct.getCreateTicket().click();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		ct.getTitle().sendKeys("Test");
		ct.getDescription().sendKeys("This is only for testing purpose");

		ct.getCreate().click();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		ct.getToastMessage();

		ct.getEye().click();

		String str = ct.getHeader().getAttribute("innerHTML");
		System.out.println("**********Title of ticket is:" + " " + str + "***********");
		ScreenShot.take_screenshot(driver, " CreateTicket");

	}

}
