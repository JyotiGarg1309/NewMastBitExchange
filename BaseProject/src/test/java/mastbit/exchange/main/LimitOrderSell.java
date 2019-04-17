package mastbit.exchange.main;

import java.io.IOException;

import mastbit.exchange.POM.Mastbit_login;
import mastbit.exchange.POM.Mastbit_order;
import mastbit.exchange.common.BaseBrowser;

public class LimitOrderSell extends BaseBrowser {

	public void LimitorderNavigation(String Email,String Password,String Amount,String Limitval) throws IOException
	{
		Mastbit_login lg=new Mastbit_login(driver);
		lg.getLoginClick().click();
		lg.getEmail().sendKeys(Email);
		lg.getPassword().sendKeys(Password);
		lg.getLogin().click();
		Mastbit_order mo=new Mastbit_order(driver);
		mo.getLimitclick().click();
		mo.getAmount().sendKeys(Amount);
		mo.getLimitval().sendKeys(Limitval);
		mo.getSell().click();
		
		

}
}
