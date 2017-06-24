package member.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//������ ���̽� ���� ����, �����ϴ� ����� �ϴ� Ŭ����
public class DBUtil {
	static {
		//1. JDBC ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// ������ ���̽� ���� ����
	public static Connection getConnection() {
		//2. Connection ��ü ���� - DB ���� ����
			Connection con = null;	
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"system", "1234");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return con;
	}
	// DB ���� - �ڿ��ݳ�
	//insert, update, delete -> executeUpdate
	public static void close(PreparedStatement pstmt, Connection con) {
		if(pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//select �� executeQuery
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
