package ev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EVdatabase {
	String url = "jdbc:mysql://localhost:3306/ev";
	String user = "root";
	String password = "admin";

	public Details getDetails(String username, String password1) {
		String query = "SELECT * FROM EV WHERE USERNAME=? AND PASSWRD=?";
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, username);
			ps.setString(2, password1);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String name = rs.getString("naam");
				String vehicle = rs.getString("vehicleno");
				int balance = rs.getInt("balance");
				String Passwrd = rs.getString("passwrd");
				String username1 = rs.getString("username");

				return new Details(name, vehicle, balance, Passwrd, username1);

			}

		} catch (SQLException e) {
			System.err.println("Database error " + e.getMessage());
		}
		return null;
	}

	public void update(Details detail) {
		String query = "UPDATE EV SET BALANCE=? WHERE NAAM=?";
		try (Connection c = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = c.prepareStatement(query)) {
			ps.setInt(1, detail.getBalance());
			ps.setString(2, detail.getName());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());

		}
	}

	public void updateTransactionc(Details detail, int amountcre) {
		String query = "INSERT INTO TRANS1 (username, credit, debit, balance) VALUES (?, ?, ?, ?)";
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, detail.getUsername());
			ps.setInt(2, amountcre);
			ps.setInt(3, 0);
			ps.setInt(4, detail.getBalance());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	public void updateTransactiond(Details detail, int amount) {
		String query = "INSERT INTO TRANS1 (username, credit, debit, balance) VALUES (?, ?, ?, ?)";
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, detail.getUsername());
			ps.setInt(2, 0);
			ps.setInt(3, amount);
			ps.setInt(4, detail.getBalance());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	public void gettransaction(Details detail) {
		String query = "SELECT * FROM TRANS1 WHERE USERNAME=?";
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, detail.getUsername());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int credit = rs.getInt("credit");
				int debit = rs.getInt("debit");
				int balance = rs.getInt("balance");
				System.out.println("credit :" + credit + " " + "debit :" + debit + " " + "balance :" + balance);

			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	public void updatepassword(Details detail) {
		String query = "UPDATE EV SET PASSWRD=? WHERE NAAM=?";
		try (Connection c = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = c.prepareStatement(query)) {
			ps.setString(1, detail.getPassword());
			ps.setString(2, detail.getName());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());

		}

	}

}
