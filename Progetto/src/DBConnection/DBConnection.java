package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static DBConnection instance;
	private Connection connection=null;
	private final String USERNAME = "postgres";
    private final String PASSWORD = "password";
	private final String url = "jdbc:postgresql://progettomcking.cfwkm0wydepu.eu-west-3.rds.amazonaws.com:5432/postgres";
	

	
	
	
	 private DBConnection() throws SQLException{
		
		try {
			 Class.forName("org.postgresql.Driver");
		}
		catch (Exception e) {
			System.out.println("Errore di connesione ad DB");
		}
		
	}
	 
	 public Connection getConnection() {
		 return connection;
	 }
	 
	 public static DBConnection getInstance() throws SQLException {
	        if (instance == null)
	        {
	            instance = new DBConnection();
	        }
	        else
	            if (instance.getConnection().isClosed())
	            {
	                instance = new DBConnection();
	            }

	        return instance;
	  }
	 public void avviaConnessione() throws SQLException{
		 connection = DriverManager.getConnection(url, USERNAME, PASSWORD);		 
	 }
	  

}