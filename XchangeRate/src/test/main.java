package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		Logger logger=new Logger();
		try {
			List<Staff> list = new ArrayList<Staff>();
			Staff staff;
			String sqlQuery = "select * from test.company_staff";
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.connectDB(DBConnection.db_path, DBConnection.db_user, DBConnection.db_pass);
			ResultSet rs = dbConnection.runSQL(con, sqlQuery);
			while (rs.next()) {
				staff = new Staff(rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(staff);
			}
			logger.logMessage.append("Database is now disconnected \n");
			for (Staff stf : list) {
				System.out.println("Name: [" + stf.getName() + "] Surname:[" + stf.getSurname() + "] ID:" + stf.getID()
						+ "] Department :[" + stf.getDepartment() + "]");
			}

			rs.close();
			con.close();
		} catch (SQLException e) {
			Logger.logMessage.append(e.getMessage());
			Logger.Log(Logger.logMessage.toString());
		}

	}

}
