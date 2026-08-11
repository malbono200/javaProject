package exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BookEx {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@192.168.219.110:1521/xepdb1";
		String user = "sql_select";
		String pwd = "1234";
		
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner scanner = new Scanner(System.in);
        
        try {
            conn = DriverManager.getConnection(url, user, pwd);

            String sqlCount = "SELECT COUNT(*) AS total_count FROM book";
            pstmt = conn.prepareStatement(sqlCount);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("총 도서 권수: " + rs.getInt("total_count") + "권\n");
            }
            rs.close();
            pstmt.close();

            System.out.print("검색할 발행 연도를 입력하세요 : ");
            String inputYear = scanner.nextLine();
            
            String sqlYear = "SELECT bookNo, bookName, bookAuthor, bookDate " +
                             "FROM book WHERE TO_CHAR(bookDate, 'YYYY') >= ? " +
                             "ORDER BY bookDate ASC";
            pstmt = conn.prepareStatement(sqlYear);
            pstmt.setString(1, inputYear); // 입력받은 연도를 쿼리의 '?' 위치에 바인딩
            rs = pstmt.executeQuery();
            
            System.out.println("--- [" + inputYear + "년 이후 발행된 도서 목록] ---");
            while (rs.next()) {
                System.out.println("도서번호: " + rs.getString("bookNo") + 
                                   ", 도서명: " + rs.getString("bookName") + 
                                   ", 저자: " + rs.getString("bookAuthor") + 
                                   ", 발행일: " + rs.getString("bookDate").substring(0, 10));
            }
            System.out.println();
            rs.close();
            pstmt.close();

            System.out.print("검색할 저자 이름의 일부를 입력하세요 (예: 길동): ");
            String inputAuthor = scanner.nextLine();
            
            String sqlAuthor = "SELECT bookName, bookAuthor FROM book WHERE bookAuthor LIKE ?";
            pstmt = conn.prepareStatement(sqlAuthor);
            pstmt.setString(1, "%" + inputAuthor + "%"); // 앞뒤로 와일드카드 추가
            rs = pstmt.executeQuery();
            
            System.out.println("--- ['" + inputAuthor + "' 저자 검색 결과] ---");
            while (rs.next()) {
                System.out.println("도서명: " + rs.getString("bookName") + 
                                   ", 저자명: " + rs.getString("bookAuthor"));
            }
            System.out.println();
            rs.close();
            pstmt.close();

            System.out.print("4. 검색할 기준 가격을 입력하세요 (예: 30000): ");
            int inputPrice = scanner.nextInt();
            
            String sqlPrice = "SELECT bookName, bookAuthor, bookPrice FROM book WHERE bookPrice >= ?";
            pstmt = conn.prepareStatement(sqlPrice);
            pstmt.setInt(1, inputPrice); // 입력받은 정수 가격 바인딩
            rs = pstmt.executeQuery();
            
            System.out.println("--- [" + inputPrice + "원 이상인 도서 목록] ---");
            while (rs.next()) {
                System.out.println("도서명: " + rs.getString("bookName") + 
                                   ", 저자명: " + rs.getString("bookAuthor") + 
                                   ", 가격: " + rs.getInt("bookPrice") + "원");
            }
            System.out.println();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 실패: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("데이터베이스 처리 중 오류 발생: " + e.getMessage());
        } finally {
            // 5. 사용한 자원(Resource) 반납 (메모리 누수 방지)
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                if (scanner != null) scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

}
