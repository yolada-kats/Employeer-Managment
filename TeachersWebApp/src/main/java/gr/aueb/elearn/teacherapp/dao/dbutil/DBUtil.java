package gr.aueb.elearn.teacherapp.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

    private static Connection conn;

    // Ιδιωτικός constructor για να μην δημιουργούνται στιγμιότυπα
    private DBUtil() {}

    public static Connection openConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/StudentsDB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String username = "thanos2";
        String password = "Thanos12";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }

        return DriverManager.getConnection(url, username, password);
    }

    public static void closeConnection() {
        try {
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   

    public static void closeStmt(PreparedStatement stmt) {
        try {
            if (stmt != null) stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static void closeRS(ResultSet rs) throws SQLException {
		try {
			if (rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	}
	
	
