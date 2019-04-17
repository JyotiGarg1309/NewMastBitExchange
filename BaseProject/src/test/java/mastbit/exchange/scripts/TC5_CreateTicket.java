package mastbit.exchange.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import mastbit.exchange.POM.Mastbit_login;
import mastbit.exchange.common.BaseBrowser;
import mastbit.exchange.main.CreateTicket;

public class TC5_CreateTicket extends BaseBrowser {

	@Test()
	public void createTicketFunctionality() throws IOException, InterruptedException {
		logger = extent.startTest("*******Create Ticket********");
		Mastbit_login lg = new Mastbit_login(driver);
		lg.getMenu().click();
		CreateTicket ct = new CreateTicket(driver);
		ct.createTicket();

	}

}
