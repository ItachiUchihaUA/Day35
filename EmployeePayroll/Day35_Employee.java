import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Day35_Employee {

	static String userN = "ujjwal";
	static String password = "ujjwal123";
	static String databaseURL = "jdbc:mysql://localhost:3306/payroll_service";
	static String tableN = "employee_payroll";

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(databaseURL, userN, password);
		
			try{
				if (conn != null) {
					conn.setAutoCommit(false);
					System.out.println("connected!");
					showtable(conn, tableN);
											// Id, Name, Salary, Date, gender, phone, address, department,....
					Emp emp = new Emp(1, "kakashi", 564321, "2019-6-10", "m", 98765432, "sd45", "BD", 65432, 432, 55432, 5432, 5432 );
				
					insertSQL(conn, tableN, emp);
					showtable(conn, tableN);
				
					update(conn, tableN, 67, "Nanuto");
					showtable(conn, tableN);
				
					delete(conn, tableN, 45);
					showtable(conn, tableN);
					conn.commit();
				}

			} catch (Exception e) {
				conn.rollback();
				System.out.println(e.getMessage());
			}finally {
				conn.setAutoCommit(true);
			}

		}catch (Exception ed) {
			System.out.println(ed.getMessage());}
		}
	
	
	public static void insertSQL(Connection c, String table, Emp emp) throws Exception  {

			PreparedStatement p = c.prepareStatement("insert into " + table + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			p.setInt(1, emp.getId());
			p.setString(2, emp.getName());
			p.setInt(3, emp.getSalary());
			p.setString(4, emp.getStart());
			p.setString(5, emp.getGender());
			p.setInt(6, emp.getPhone());
			p.setString(7, emp.getAddress());
			p.setString(8, emp.getDepartment());
			p.setInt(9, emp.getBasicPay());
			p.setInt(10, emp.getDeduction());
			p.setInt(11, emp.getTaxable());
			p.setInt(12, emp.getIncomeTax());
			p.setInt(13, emp.getNetPay());
			p.execute();
			System.out.println("Added!");
		
	}

	public static void showtable(Connection c, String table) throws Exception {
	
			String str = ("select * from " + table);
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(str);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int sal = rs.getInt(3);
				String date = rs.getString(4);
				String gender = rs.getString(5);
				System.out.printf("%3d | %10s | %8d | %12s | %2s | %7d | %7s | %7s | %7d | %7d | %7d | %7d | %7d%n", id,
						name, sal, date, gender, rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9),
						rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13));
			}
			System.out.println();
		
	}

	public static void delete(Connection c, String table, int id) throws Exception  {
		String str = "delete from " + table + " where id = " + id;
		
			Statement s = c.createStatement();
			s.execute(str);
			System.out.println("Deleted!");

	}

	public static void update(Connection c, String table, int id, String newN) throws Exception  {
		String str = "Update " + table + " set name = '" + newN + "' where id = " + id;
		
			Statement s = c.createStatement();
			s.execute(str);
			System.out.println("Updated!");
		}
	}

