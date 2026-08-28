package exam.ojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {
	public ArrayList<ProductVO> productSelect(){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
        
        try {
            con = DBConnect.getConnection();
            String query = "select * from product";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String productNo = rs.getString("productNo");
                String productName = rs.getString("productName");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                
                ProductVO vo = new ProductVO();
                vo.setProductNo(productNo);
                vo.setProductName(productName);
                vo.setPrice(price);
                vo.setStock(stock);

                productList.add(vo);
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return productList;	
    }
}
