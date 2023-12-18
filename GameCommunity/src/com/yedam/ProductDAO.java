package com.yedam;

import java.sql.*;
import java.util.*;

public class ProductDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private MemberDAO mdao = new MemberDAO();
	private ArrayList<Product> prods;
	private ArrayList<ProductAdmin> prodAdmins;

	ArrayList<ProductAdmin> prodList() {
		conn = mdao.getConn();
		prodAdmins = new ArrayList<ProductAdmin>();
		String sql = "select * from product_admin";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ProductAdmin prodAdmin = new ProductAdmin();
				prodAdmin.setProdCode(rs.getInt("p_code"));
				prodAdmin.setProdName(rs.getString("p_name"));
				prodAdmin.setProdPrice(rs.getInt("p_price"));
				prodAdmin.setProdCount(rs.getInt("p_count"));
				// 배열의 빈곳에 한건 저장
				prodAdmins.add(prodAdmin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mdao.disConn();
		}
		return prodAdmins;
	}

}
