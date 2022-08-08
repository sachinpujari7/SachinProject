/**
 * 
 */
package com.NhanceNow.dataprovider;

import org.testng.annotations.DataProvider;

import com.NhanceNow.Utility.ExcelLibrary;

/**
 * @author IDS055
 *
 */
public class DataProviders 
{
	ExcelLibrary excel=new ExcelLibrary();
	
	@DataProvider(name = "credentials")
	public Object[][] getLoginCredentials() {
		// Totals rows count
		int rows = excel.getRowCount("LoginCredentials");
		// Total Columns
		int column = excel.getColumnCount("LoginCredentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = excel.getCellData("LoginCredentials", j, i + 2);
			}
		}
		return data;
	}

}
