package exam.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnection() {
        Connection con = null;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            String url = "jdbc:oracle:thin:@192.168.219.110:1521/xepdb1";
            String user = "sql_select";
			String pwd = "1234";
            con = DriverManager.getConnection(url, user, pwd);
            
            if(con != null) {
                System.out.println("DB 연결 성공");
            } else {
                System.out.println("DB 연결 실패");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
