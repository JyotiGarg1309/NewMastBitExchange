package mastbit.exchange.main;

import java.io.IOException;

import mastbit.exchange.POM.Mastbit_login;
import mastbit.exchange.common.BaseBrowser;

public class OpenOrder extends BaseBrowser{
	
	public void LoginPageNavigation(String Email,String Password) throws IOException
	{
		Mastbit_login lg=new Mastbit_login(driver);
		lg.getLoginClick().click();
		lg.getEmail().sendKeys(Email);
		lg.getPassword().sendKeys(Password);
		lg.getLogin().click();
}

	
}