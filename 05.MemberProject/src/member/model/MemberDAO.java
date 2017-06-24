package member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.dto.Member;
import member.util.DBUtil;

// DAO(Data Access Object) =VO(Vaulue Object)
// member 테이블 데이터 관리하는 클래스
public class MemberDAO {
	// 싱글턴 패턴--------------------------------------
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO(){}
	public static MemberDAO getInstance(){
		return dao;
	} 
	//--------------------------------------------------
	//회원가입
	public int insert(Member member) throws SQLException {
		String sql = "insert into member values(?,?,?,?,?,?,default)";
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getAddr());
			
			result = pstmt.executeUpdate();
		}finally{//무조건 실행
			DBUtil.close(pstmt, con);
		}
		return result;
	}
	//로그인
	public String login (String id, String pwd) throws  SQLException {
		String sql = "select * from member where id = ? and password = ? ";
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getString("name");
			}
		} finally{//무조건 실행
			DBUtil.close(rs,pstmt, con);
		}
		return null;
	}
	//리스트
	public List<Member> selectAll() throws SQLException {
		String sql = "select * from member order by id"; //String sql = "select * from member order by id desc"; 내림차순(z부터)
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
	
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Member member = new Member();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
				member.setAddr(rs.getString("addr"));
				member.setRegDate(rs.getDate("regDate"));
				list.add(member);
			}
		}finally{//무조건 실행
			DBUtil.close(rs,pstmt, con);
		}
		
		
		return list;
	}
	//상세리스트
	public Member selectById(String id) throws SQLException{
		String sql = "select * from member where id =?";
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				Member member = new Member();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
				member.setAddr(rs.getString("addr"));
				member.setRegDate(rs.getDate("regDate"));
				
				return member;
			}
			
		} finally{//무조건 실행
			DBUtil.close(rs,pstmt, con);
		}
		return null;
		
	}
	//삭제
	public void deleteById(){
		
	}
}
