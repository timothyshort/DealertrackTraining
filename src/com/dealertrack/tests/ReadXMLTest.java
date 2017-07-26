package com.dealertrack.tests;

import utilities.*;

public class ReadXMLTest {

	public static void main(String[] args) {
		utilities.GlobalConfigs.setFramework("C:\\DealerTrackTraining\\TestData\\GlobalSettings.xml");
		// DriverFactory.get(GlobalConfigs.browserType, GlobalConfigs.testURL);
		
		String[][] dataTable = utilities.XML.get(GlobalConfigs.testDataFolder + "CarTestData.xml");
		for (String[] car : dataTable) {
			System.out.print("[ ");
			for (String element : car) {
				System.out.print(element + " ");
			}
			System.out.println("]");
		}
	}

}
