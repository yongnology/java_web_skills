package sec04.ex03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			System.out.println("MemberDAO에서 Context 실시");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("DataSource 가져오기 실패");
		}
	}
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		System.out.println("리스트 객체 생성");
		try {
			// connDB();	// 데이터베이스 연결
			con = dataFactory.getConnection();
			String query = "select * from t_member order by joindate desc";	// 쿼리문 작성
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);	// 쿼리문을 rs에 저장
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연결 실패");
		}
		return list;
	}
	
	public void addMember(MemberVO memberVO) {
		System.out.println("addMember메소드 호출");
		try {
			con = dataFactory.getConnection();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			String query = "insert into t_member";
			System.out.println("MemberDAO에서 String으로 변수 선언");
			query += " (id, pwd, name, email)";
			query += " values(?, ?, ?, ?)";
			System.out.println("prepareStatement : " + query + "쿼리 호출");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();	// 회원 정보를 테이블에 추가
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("addMember실패");
		}
	}
	public void delMember(String id) {
		System.out.println("delMember 메소드 호출");
		try {
			con = dataFactory.getConnection();
			String query = "delete from t_member" + " where id=?";
			System.out.println("prepareStatement :" + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch(Exception e) {
			System.out.println("삭제중 오류 발생");
			e.printStackTrace();
		}
	}
	
	
}
