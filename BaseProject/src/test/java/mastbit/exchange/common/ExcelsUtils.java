package mastbit.exchange.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelsUtils {

	static String login = "C:\\Users\\revinfotech\\eclipse-workspace\\MastbitExchange\\Test-Data\\mastbit.xlsx";
	

	public static String SignUp(int rowNum, int cellNum) throws InvalidFormatException {
		String data = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(new File(login)));
			data = wb.getSheet("SignUp").getRow(rowNum).getCell(cellNum).getStringCellValue();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;

	}

	public static String SignUpInvalid(int rowNum, int cellNum) {
		String data = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(new File(login)));
			data = wb.getSheet("Sheet2").getRow(rowNum).getCell(cellNum).getStringCellValue();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public static String Login(int rowNum, int cellNum) {
		String data = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(new File(login)));
			data = wb.getSheet("LogIn").getRow(rowNum).getCell(cellNum).getStringCellValue();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;

	}
}
