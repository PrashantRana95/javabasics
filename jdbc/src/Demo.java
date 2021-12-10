import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		//Database Driver
//		Oracle = oracle.jdbc.driver.OracleDriver
//		postgres = org.postgres.Driver
//		mysql = com.mysql.jdbc.Driver
		Class.forName("com.mysql.jdbc.Driver");
		
//		jdbc:oracle:thin:@hostname:port:ServiceId 1521
//		jdbc:postgresl://hostname:port/dbname 5432
		
		String url = "jdbc:mysql://localhost:3306/billingdb";
		Connection connection = DriverManager.getConnection(url,"root","root");
		Statement stmt = (Statement) connection.createStatement();
		String query = "select * from customer";
		
		ResultSet resultSet = stmt.executeQuery(query);
		
		boolean isFound = false;
		while(resultSet.next()) {
			isFound = true;
			System.out.println("Data Found = "+resultSet.getString("name"));
		}
		if(!isFound) {
			System.out.println("No Record Found");
		}
		
		resultSet.close();
		stmt.close();
		connection.close();
		
	}

}
