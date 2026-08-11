package ex1;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ProductMain {

	public static void main(String[] args) {
		PrdJDBConn dbCon = new PrdJDBConn();
		Connection con = dbCon.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		if(con == null) {
			System.out.println("DB 연결 실패");
		} else {
			System.out.println("DB 연결 성공");
			
			try {
				String query = "SELECT * FROM product";

				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				
				System.out.println("-------------------------------- 전체 상품 정보 조회 --------------------------------");
				System.out.println("상품번호 \t 상품명 \t\t\t 가격 \t\t 제조사 \t\t 색상 \t 카테고리번호");
				
				while (rs.next()) {
					String prdNo = rs.getString(1);
					String prdName = rs.getString(2);
					int prdPrice = rs.getInt(3);
					String prdMaker = rs.getString(4);
					String prdColor = rs.getString(5);
					int ctgNo = rs.getInt(6);

					System.out.format("%-5s\t %-20s\t %8d\t %-15s\t %-10s\t %3d\n",
							prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
				}
				
				rs.close();
				stmt.close();
				con.close();
			} catch(Exception e) {
				System.out.println("오류발생");
				e.printStackTrace();
			}
		}

	}

}
