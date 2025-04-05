package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	/**
	 * This method will read the data from Excel sheet and return the value in
	 * string format
	 * 
	 * @param Sheet
	 * @param rowIndex
	 * @param colIndex
	 * @return value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public FileInputStream fis;
	public Workbook wb;

//	public ExcelUtility() throws EncryptedDocumentException, IOException {
//		fis = new FileInputStream("./src/test/resources/TestData/FrameworkTestData.xlsx");
//		wb = WorkbookFactory.create(fis);
//	}

	public String getDataFromExcel(String Sheet, int rowIndex, int colIndex)
			throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("./src/test/resources/TestData/FrameworkTestData.xlsx");
		wb = WorkbookFactory.create(fis);

		return wb.getSheet(Sheet).getRow(rowIndex).getCell(colIndex).getStringCellValue();
	}

	public boolean getDataFromExcelInBoolean(String SheetName, int rowIndex, int colIndex) {
		return wb.getSheet(SheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
	}

	public LocalDateTime getDataFromExcelInDateFormat(String SheetName, int rowIndex, int colIndex) {
		return wb.getSheet(SheetName).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
	}

}
