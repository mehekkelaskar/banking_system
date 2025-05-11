package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class AccountDao {
	    private final String jdbcUrl = "jdbc:mysql://localhost:3306/bankdb";
	    private final String jdbcUsername = "root";
	    private final String jdbcPassword = "**********";

	        private Connection getConnection() throws SQLException {
	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");  // Load the JDBC driver
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	                throw new SQLException("MySQL JDBC Driver not found", e);
	            }
	            return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
	        }

	        // Check user by PIN
	        public Account checkPin(String pin) {
	            String sql = "SELECT * FROM accounts WHERE pin = ?";
	            try (Connection conn = getConnection();
	                 PreparedStatement stmt = conn.prepareStatement(sql)) {
	                stmt.setString(1, pin);
	                ResultSet rs = stmt.executeQuery();
	                if (rs.next()) {
	                    Account user = new Account();
	                    user.setName(rs.getString("name"));
	                    user.setDob(rs.getString("dob"));
	                    user.setAddress(rs.getString("address"));
	                    user.setPin(rs.getString("pin"));
	                    user.setAccountType(rs.getString("accountType"));
	                    user.setBalance(rs.getDouble("balance"));
	                    return user;
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            return null;
	        }

	        // Deposit money
	        public boolean deposit(String pin, double amount) {
	            String sql = "UPDATE accounts SET balance = balance + ? WHERE pin = ?";
	            try (Connection conn = getConnection();
	                 PreparedStatement stmt = conn.prepareStatement(sql)) {
	                stmt.setDouble(1, amount);
	                stmt.setString(2, pin);
	                return stmt.executeUpdate() > 0;
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            return false;
	        }

	        // Withdraw money
	        public boolean withdraw(String pin, double amount) {
	            String selectSql = "SELECT balance FROM accounts WHERE pin = ?";
	            String updateSql = "UPDATE accounts SET balance = balance - ? WHERE pin = ?";
	            try (Connection conn = getConnection();
	                 PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {

	                selectStmt.setString(1, pin);
	                ResultSet rs = selectStmt.executeQuery();
	                if (rs.next()) {
	                    double balance = rs.getDouble("balance");
	                    if (balance >= amount) {
	                        try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
	                            updateStmt.setDouble(1, amount);
	                            updateStmt.setString(2, pin);
	                            return updateStmt.executeUpdate() > 0;
	                        }
	                    }
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            return false;
	        }

	        // Create a new account
	        public boolean createAccount(Account acc) {
	            String INSERT_ACCOUNT_SQL = "INSERT INTO accounts (name, dob, address, pin, accountType) VALUES (?, ?, ?, ?, ?)";
	            try (Connection conn = getConnection();
	                 PreparedStatement ps = conn.prepareStatement(INSERT_ACCOUNT_SQL)) {

	                ps.setString(1, acc.getName());
	                ps.setString(2, acc.getDob());
	                ps.setString(3, acc.getAddress());
	                ps.setString(4, acc.getPin());
	                ps.setString(5, acc.getAccountType());

	                int rowsAffected = ps.executeUpdate();
	                return rowsAffected > 0;

	            } catch (SQLException e) {
	                e.printStackTrace();
	                return false;
	            }
	        }
	    }



