package TestCase.Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
//	public static void main(String[] args) {

		@DataProvider (name = "LoginData")
	public String[][] getData() {
		String path = ".\\testData\\LoginData.xlsx";

		ExcelReader excelUtil = new ExcelReader(path);
		int totalRows = excelUtil.getRowCount("Sheet1");
		int totalColumns = excelUtil.getColumnCount("Sheet1");

		String data[][] = new String[totalRows - 1][totalColumns];
		for (int rownum = 2; rownum <= totalRows; rownum++) {
			for (int colnum = 0; colnum < totalColumns; colnum++) {
				data[rownum - 2][colnum] = excelUtil.getCellData("Sheet1", colnum, rownum);
			}
		}

		return data;
	}

//		String data[][] = new String[totalRows - 1][totalColumns];
//		for (int rownum = 2; rownum <= totalRows; rownum++) {
//			for (int colnum = 0; colnum < totalColumns; colnum++) {
//				data[rownum - 2][colnum] = excelUtil.getCellData("Sheet1", colnum, rownum);
//			}
//		}
//		for (int rownum = 2; rownum <= totalRows; rownum++) {
//			for (int colnum = 0; colnum < totalColumns; colnum++) {
//				System.out.println(data[rownum-2][colnum]);
//			}
//
//	}
//	}
}
