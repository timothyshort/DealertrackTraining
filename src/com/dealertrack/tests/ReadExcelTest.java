package com.dealertrack.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelTest {
	
	String filepath = "C:\\DealerTrackTraining\\TestData\\DealerTrackTestData.xls";
	
	
	@Test
	public void excelTest() {
		
		String[][] dealertrackData = utilities.Excel.getXLS(filepath);
		
		for (String[] testCase : dealertrackData) {
			System.out.print("NEW TEST: ");
			for (String element : testCase) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}
	/*
	
	@Test(dataProvider="getExcelData")
	public void excelTestwithDataProvider(String carMake, String searchParam1, String searchParam2,
			String pymtDuration, String pymntFrequency,String downPayment) {
		
		System.out.println(carMake + " " + searchParam1 + " " + searchParam2 + " " + pymtDuration + " " + pymntFrequency + " " + downPayment);
		
	}
	*/
	
	
	@DataProvider
	public String[][] getExcelData() {
		return utilities.Excel.getXLS(filepath);
	}
	

}
