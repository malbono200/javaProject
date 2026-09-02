package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.Util;

public class ProductDAO {
	public ArrayList<ProductDTO> productSelect(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ProductDTO> productList = new ArrayList<ProductDTO>();
		
		try {
			con = Util.getConn();
			String query = "select * from product";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String prdNo = rs.getString("PRODUCTNO");
				String prdName = rs.getString("PRODUCTNAME");
				int price = rs.getInt("PRICE");
				int stock = rs.getInt("STOCK");
				
				ProductDTO dto = new ProductDTO();
				dto.setPrdNo(prdNo);
				dto.setPrdName(prdName);
				dto.setPrice(price);
				dto.setStock(stock);
				productList.add(dto);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return productList;	
	}
}
