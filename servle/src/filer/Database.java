package filer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public boolean login(User user) throws SQLException {
		// TODO Auto-generated method stub
		/*if (user.getName().equalsIgnoreCase("maren") && user.getPass().equals("somers"))
			return true;*/
		Connection con=null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			// here sonoo is database name, root is username and password
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM test.login where user_id='"+user.getName()+"' and password='"+user.getPass()+"'");
			if(rs.next())
				return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			stmt.close();
			con.close();
		}
		return false;
	}

	public void record() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from login");
			while (rs.next())
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void prepareStatement() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			String str = "select * from login where type=?";
			PreparedStatement stmt = con.prepareStatement(str);
			stmt.setString(1, "student");
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] agr) {
		new Database().prepareStatement();
	}

}
