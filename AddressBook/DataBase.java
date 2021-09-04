package workshop_AddressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {

	protected static Connection newC;

	protected static void connectionToDatabase(String URL) {
		try {
			newC = DriverManager.getConnection(URL, "ujjwal", "ujjwal123");
			if (newC != null) {
				System.out.println("Connected to Database");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected static void insertSQL(String table, Contact c) {

		try {
			PreparedStatement p = newC.prepareStatement("insert into " + table + "(firstName, lastName, address, city, state, zip, phone, email) values(?,?,?,?,?,?,?,?)");
			p.setString(1, c.getFirstName());
			p.setString(2, c.getLastName());
			p.setString(3, c.getAddress());
			p.setString(4, c.getCity());
			p.setString(5, c.getState());
			p.setString(6, c.getZip());
			p.setString(7, c.getPhone());
			p.setString(8, c.getEmail());
			p.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected static void showtable(String table) {
		if (newC == null) {
			System.out.println("Not Found");
			return;
		}

		try {
			String str = ("select * from " + table);
			Statement st = newC.createStatement();
			ResultSet rs = st.executeQuery(str);
			while (rs.next()) {
				System.out.printf("%8s | %8s | %8s | %8s | %8s | %8s | %8s | %8s%n", rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8));
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected static void countByCity(String table) {
		if (newC == null) {
			System.out.println("Not Found");
			return;
		}
		String str = "select city, count(city) from " + table + " order by city";
		try {
			Statement s = newC.createStatement();
			ResultSet rs = s.executeQuery(str);
			while (rs.next()) {
				System.out.printf("%8s | %8d%n", rs.getString(1), rs.getInt(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void countByState(String table) {
		if (newC == null) {
			System.out.println("Not Found");
			return;
		}
		String str = "select state, count(state) from " + table + " order by state";
		try {
			Statement s = newC.createStatement();
			ResultSet rs = s.executeQuery(str);
			while (rs.next()) {
				System.out.printf("%8s | %8d%n", rs.getString(1), rs.getInt(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void delete(String table, String name) {
		if (newC == null) {
			System.out.println("Not Found");
			return;
		}
		String str = "Delete from " + table + " where firstName= '" + name + "';";
		try {
			Statement s = newC.createStatement();
			s.execute(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
