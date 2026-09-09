package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;

	public ProductDAO() {
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			this.dataFactory = (DataSource) envCtx.lookup("jdbc/oracle");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ProductVO> listProducts() {
		List<ProductVO> productList = new ArrayList();

		try {
			conn = dataFactory.getConnection();
			String query = "select * from product order by PRODUCTNO";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String prdNo = rs.getString("PRODUCTNO");
				String prdName = rs.getString("PRODUCTNAME");
				int price = rs.getInt("PRICE");
				int stock = rs.getInt("STOCK");

				ProductVO prdVO = new ProductVO(prdNo, prdName, price, stock);
				productList.add(prdVO);
			}
			rs.close();
			pstmt.close();
			conn.close(); // connection pool로 반환

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	public void addProduct(ProductVO p) {
		try {
			conn = dataFactory.getConnection();
			String prdNo = p.getPrdNo();
			String prdName = p.getPrdName();
			int price = p.getPrice();
			int stock = p.getStock();
			String query = "INSERT INTO product (productno, productname, price, stock)" + " VALUES(?, ?, ?, ?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prdNo);
			pstmt.setString(2, prdName);
			pstmt.setInt(3, price);
			pstmt.setInt(4, stock);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ProductVO findProduct(String _prdNo) {
		ProductVO prdInfo = null;
		try {
			conn = dataFactory.getConnection();
			String query = "select * from product where productno=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _prdNo);
			System.out.println(query);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String prdNo = rs.getString("productno");
			String prdName = rs.getString("productname");
			int price = rs.getInt("price");
			int stock = rs.getInt("stock");
			prdInfo = new ProductVO(prdNo, prdName, price, stock);
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prdInfo;
	}

	public void modProduct(ProductVO productVO) {
		String prdNo = productVO.getPrdNo();
		String prdName = productVO.getPrdName();
		int price = productVO.getPrice();
		int stock = productVO.getStock();
		try {
			conn = dataFactory.getConnection();
			String query = "update product set productname=?, price=?, stock=? where productno=?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prdName);
			pstmt.setInt(2, price);
			pstmt.setInt(3, stock);
			pstmt.setString(4, prdNo);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delProduct(String prdNo) {
		try {
			conn = dataFactory.getConnection();
			String query = "delete from product where productno=?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prdNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
