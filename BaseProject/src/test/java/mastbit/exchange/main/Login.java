package mastbit.exchange.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import mastbit.exchange.POM.Mastbit_login;

public class Login {
	public WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public void LoginBase() throws InterruptedException {

		Mastbit_login lg = new Mastbit_login(driver);
		lg.getHomeClickNew();

	}

	public void LoginPageNavigation(String name, String password, String nationality)
			throws IOException, InterruptedException {

		Mastbit_login lg = new Mastbit_login(driver);
		lg.getLoginClick().click();

		lg.getEmail().sendKeys(name + "@mailinator.com");
		lg.getPassword().sendKeys(password);

		lg.getLogin().click();

	}

}
