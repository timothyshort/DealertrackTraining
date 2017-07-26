package com.dealertrack.tests;

public class ReadDB {
	
	public static void main(String[] args) {
		String tableName = "MortgageLoanTestData";
		String[][] dbData = utilities.Database.get(tableName);
		
		for (String[] row : dbData) {
			System.out.print("[ ");
			for (String column : row) {
				System.out.print(column + "  ");
			}
			System.out.println();
		}
	}

}
