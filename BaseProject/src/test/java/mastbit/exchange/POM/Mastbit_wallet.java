package mastbit.exchange.POM;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Mastbit_wallet {
	static File file;
	static FileOutputStream fos;
	static WritableWorkbook wb;
	static WritableSheet sht;
	static int shtno = 1;
	String TMname;
	static {
		file = new File("./Test-Data/MastbitWalletAddress.xls");
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = Workbook.createWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sht = wb.createSheet("Data" + shtno, shtno - 1);
	}

	public WebDriver driver;
	By wallets = By.xpath("//a[@href='/wallets']");
	By hidewallets = By.xpath(".//*[@id='user_password']");
	By xlmMemo = By.xpath("/html/body/ngb-modal-window/div/div/div[2]/div[1]/p[2]");
	By closeBtn = By.xpath("/html/body/ngb-modal-window/div/div/div[1]/button");
	By walletAddress = By.xpath("/html/body/ngb-modal-window/div/div/div[2]/div[1]/p");
	By tag = By.xpath("/html/body/ngb-modal-window/div/div/div[2]/div[1]/p[2]");
	By next = By.xpath(
			"//*[@id=\"app-wrapper\"]/app-wallets/section/div/div/div/div[3]/pagination-controls/pagination-template/ul/li[4]");

	public Mastbit_wallet(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void getWallets() throws InterruptedException {

		WebElement element = driver.findElement(wallets);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public WebElement getHidewallets() {
		return driver.findElement(hidewallets);
	}

	public void getWalletAddress() throws InterruptedException, RowsExceededException, WriteException, IOException {

		List<WebElement> allcoin = driver.findElements(By
				.xpath("//*[@id=\"app-wrapper\"]/app-wallets/section/div/div/div/div[3]/div/div/table/tbody/tr/td[1]"));
		int count = allcoin.size();

		System.out.println("Count Of Coins:" + " " + allcoin.size());

		List<WebElement> allcoinaddress = driver.findElements(By.xpath(
				"//*[@id=\"app-wrapper\"]/app-wallets/section/div/div/div/div[3]/div/div/table/tbody/tr/td/ul/li[1]"));

		for (int i = 0; i < count; i++) {

			String coinName = allcoin.get(i).getText();
			// System.out.println(allcoin.get(i).getText());

			allcoinaddress.get(i).click();

			String str = driver.findElement(walletAddress).getAttribute("innerHTML");

			if (coinName.equals("XLM")) {
				TMname = driver.findElement(xlmMemo).getAttribute("innerHTML");

			}
			if (coinName.equals("XRP")) {
				TMname = driver.findElement(tag).getAttribute("innerHTML");

			}

			driver.findElement(closeBtn).click();

			sht.addCell(new Label(0, i, coinName));
			sht.addCell(new Label(1, i, str));
			sht.addCell(new Label(2, i, TMname));
			TMname = null;

			if (i == 14) {
				shtno = shtno + 1;

				driver.findElement(next).click();
				sht = wb.createSheet("Data" + shtno, shtno - 1);
				getWalletAddress();

			}

		}

		fos.close();
		wb.write();
		wb.close();

		System.out.println("Workbook is created ");
	}
}
