package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	public static final String db_user = "root";
	public static final String db_pass = "root";
	public static final String db_path = "jdbc:mysql://localhost:3306/test";
    public String logMessage="";
	public Connection connectDB(String path, String user, String pass) {
		Connection con = null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(path, user, pass);
			if(con!=null) Logger.logMessage.append("Database connection successful ! \n");
		} catch (Exception ex) {
			Logger.logMessage.append("Database connection Failed ! \n");
			Logger.logMessage.append("Error:"+ex.getMessage()+" \n");
		}
	
		return con;
	}

	public ResultSet runSQL(Connection con, String sqlQuery) {
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			} catch (Exception ex) {
			Logger.logMessage.append("Database connection Failed in runSQL function! \n");
			Logger.logMessage.append("Error:"+ex.getMessage()+" \n");
		}
		return rs;

	}

}
