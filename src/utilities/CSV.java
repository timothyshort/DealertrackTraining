package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// This class deals with all things CSV
// read()
// write()

public class CSV {
	
	// This method will return data from a CSV file based on the path
	public static List<String[]> read(String filename) {
		List<String[]> data = new ArrayList<String[]>();
		String testRow;
		try {
			// 1. Open the file
			BufferedReader br = new BufferedReader(new FileReader(filename));
			// 2. Read data as long as it's not empty
			// Parse the data by comma using .split() method
			// Place into a temporary array, then add to List 
			while ((testRow = br.readLine()) != null) {
				String[] line = testRow.split(",");
				data.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found " + filename);
		} catch (IOException e) {
			System.out.println("ERROR: Could not read " + filename);
		}
		return data;
	}

}
