package com.dealertrack.tests;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CSVLoginTest {

  @Test
  public void loginTestOneTestCase() {
	  
	  // Grab the data from the file
	  String filename = "C:\\DealerTrackTraining\\TestData\\AccountTestData.csv";
	  List<String[]> dataSet = utilities.CSV.read(filename);
	  
	  for (String[] user : dataSet) {
		  System.out.print("Email: " + user[3]);
		  System.out.print("   Password: " + user[4]);
		  System.out.println();
		  
		  /* This was an exercise to see the fields in our data set
		  int fields = user.length;
		  System.out.println("There are " + fields + " fields inside the record");
		  for (int i = 0; i < fields; i++) {
			  System.out.println("Field " + i + " : " + user[i]);
		  }
		  */
	  }
	  
  }
  
  /*
  @Test(dataProvider="getData")
  public void loginTest(String email, String password) {
	  System.out.println(email + "   " + password);	  
  }
  
  
  
  
  @DataProvider
  public List<String[]> getData() {
	  return utilities.CSV.read("C:\\DealerTrackTraining\\TestData\\LoginTestData.csv");
  }
  */
}
