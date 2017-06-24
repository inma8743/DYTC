package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.dto.Board;
import member.util.DBUtil;

public class BoardDAO {
	// �̱��� ����--------------------------------------
	private static BoardDAO dao = new BoardDAO();
	private BoardDAO(){}
	public static BoardDAO getInstance(){
		return dao;
	}
		
	// �۾���
	public int insert(Board board) throws SQLException{
		String sql = "insert into board values(board_seq.nextval,?,?,?,?,default,default)";
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getId());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getFileName());
			
			result = pstmt.executeUpdate();
		}finally{//������ ����
			DBUtil.close(pstmt, con);
		}
		return result;
	}
	// ����Ʈ
	public List<Board> selectAll() throws SQLException{
		String sql = "select * from board order by num desc";
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();
	
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Board board = new Board();
				board.setNumber(rs.getInt("num"));
				board.setId(rs.getString("id"));
				board.setSubject(rs.getString("subject"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setReadCount(rs.getInt("read_count"));
				list.add(board);
			}
		}finally{//������ ����
			DBUtil.close(rs,pstmt, con);
		}

		return list;	
	}
	//�� ������
	public Board selectByNum(int num) throws SQLException{
		String sql = "select * from board where num= ?";
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				Board board = new Board();
				board.setContent(rs.getString("content"));
				board.setFileName(rs.getString("file_name"));
				board.setId(rs.getString("id"));
				board.setNumber(rs.getInt("num"));
				board.setReadCount(rs.getInt("read_count"));
				board.setSubject(rs.getString("subject"));
				board.setWriteDate(rs.getDate("write_date"));
				return board;
			}
		} finally{//������ ����
			DBUtil.close(rs,pstmt, con);
		}
		return null;
	}
	public int deleteByNum(int num) throws SQLException{
		String sql = "delete from board where num = ?";
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
		} finally{//������ ����
		DBUtil.close(pstmt, con);
	}
		return result;
	}
	public void updateReadCount(int num) throws SQLException {
		String sql = "update board set read_count = read_count + 1 where num = ?";
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} finally{
			DBUtil.close(pstmt, con);
		}
	}
}
