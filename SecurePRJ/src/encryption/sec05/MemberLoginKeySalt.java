package encryption.sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

//로그인 시 salt값은 db에 저장되어 있는 상태임
//회원정보와 동일 테이블에 저장되어 있으면 취약한 정보저장임 (단, 연습용이어서 동일 테이블에 저장했음)
//로그인 시 에는 해시기능 메소드만 필요함(개발자는 회원가입시 진행한 스트레칭 수는 개발자는 알고 있음)
public class MemberLoginKeySalt {
	public static void main(String[] args) {
		DBConn dbCon = new DBConn();
		Connection con = dbCon.getConnection();
		PreparedStatement pstmt =null;
		PreparedStatement saltStmt = null;
		
		ResultSet rs = null; //select 구문
		ResultSet saltRs = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("ID 입력 : ");
			String memID = sc.nextLine();
			String saltSql = "select salt from member where memID = ?";
			saltStmt = con.prepareStatement(saltSql);
			saltRs = saltStmt.executeQuery();
			
			String salt = null;
			if (saltRs.next()) {
				salt = saltRs.getString("salt");
			}
			System.out.print("비밀번호 입력 : ");
			String memPass = sc.nextLine();
			
			for (int i = 0; i < 10; i++) {
				memPass = MemberJoinKeySalt.sha256(memPass, salt);
			}
			System.out.println(memPass);
			
			//select 쿼리문 작성
			String sql = "select * from member where memID = '" + memID + "'" +  "and memPWD = '" + memPass + "'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			//회원가입시 중복 아이디는 허용하지 않음
			//위 쿼리의 결과는 레코드가 1개거나 아니면 없거나
			if(rs.next()) {
				System.out.println("로그인 되었습니다");
				//웹에서는 로그인 자격증명(session)을 구성하고 쿠키를 통해 자격증명을 클라이언트에게 전달(sessionid)
			} else {
				System.out.println("로그인 실패");
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
