package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	
	// This method will connect to a SQL Server M.S. database and return a double array
	public static String[][] get(String table) {
		int numRows;
		int numCols = 5;
		String dataTable[][] = null;

		// Define connection string
		String connectionString;
		String server = "jdbc:sqlserver://sql2k801.discountasp.net:1433";
		String databaseName = "SQL2008_841902_tr";
		String username = "SQL2008_841902_tr_user";
		String password = "52645264hrm";
		connectionString = server + ";databasename=" + databaseName + ";username=" + username + ";password=" + password;
		System.out.println(connectionString);

		// Define database (this specifies whether SQL Server / MySQL / Oracle, etc)
		String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		// Write SQL statement to query the database
		String query = "select * from " + table;

		// Perform DB operations
		try {
			Class.forName(dbDriver);
			Connection oConnection = DriverManager.getConnection(connectionString);
			Statement oStatement = oConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet oResult = oStatement.executeQuery(query);

			// Set the size of the array
			oResult.last();
			numRows = oResult.getRow();
			dataTable = new String[numRows][numCols];

			// Read the DB file while there is a next element
			oResult.beforeFirst();
			int row = 0;
			while (oResult.next()) {
				dataTable[row][0] = oResult.getString(1);
				dataTable[row][1] = oResult.getString(2);
				dataTable[row][2] = oResult.getString(3);
				dataTable[row][3] = oResult.getString(4);
				dataTable[row][4] = oResult.getString(5);
				row++;
			}

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("ERROR Handling SQL");
			e.printStackTrace();
		}

		return dataTable;
	}
	

}
