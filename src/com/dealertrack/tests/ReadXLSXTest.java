package com.dealertrack.tests;

public class ReadXLSXTest {

	public static void main(String[] args) {
		System.out.println("REAING EXCEL  - .XLSX");
		String[][] dataTable = utilities.Excel.getXLSX("C:\\DealerTrackTraining\\TestData\\DealertrackXLSX.xlsx");
		for (String[] record : dataTable) {
			for (String item : record) {
				System.out.println(item);
			}
		}
		
		System.out.println("REAING EXCEL  - .XLS");
		String[][] dataTableXLS = utilities.Excel.getXLS("C:\\DealerTrackTraining\\TestData\\DealerTrackTestData.xls");
		for (String[] record : dataTableXLS) {
			for (String item : record) {
				System.out.println(item);
			}
		}
	}

}
