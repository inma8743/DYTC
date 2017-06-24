package member.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//데이터 베이스 서버 연결, 종료하는 기능을 하는 클래스
public class DBUtil {
	static {
		//1. JDBC 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// 데이터 베이스 서버 연결
	public static Connection getConnection() {
		//2. Connection 객체 생성 - DB 서버 연결
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
	// DB 종료 - 자원반납
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
	//select 용 executeQuery
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
