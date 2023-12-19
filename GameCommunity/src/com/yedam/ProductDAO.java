package com.yedam;

import java.sql.*;
import java.util.*;
import java.sql.Date;

public class ProductDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private PreparedStatement psmt2;
	private ResultSet rs;
	private MemberDAO mdao = new MemberDAO();
	private ArrayList<Product> prods;
	private ArrayList<ProductAdmin> prodAdmins;

	ArrayList<ProductAdmin> prodList() { // 상품구매 리스트
		conn = mdao.getConn();
		prodAdmins = new ArrayList<ProductAdmin>();
		String sql = "select * from product_admin order by 1";
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

	boolean prodBuy(int prodOQ, String id, int buyNum) { // 구매수량 체크
		conn = mdao.getConn();
		int qo = 0;
		int pCode =0;
		int pCount = 0;
		String sql = "select p_price,p_code,p_count from product_admin where p_code=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, buyNum);
			rs = psmt.executeQuery();

			if (rs.next()) {
				qo = rs.getInt("p_price");
				pCode = rs.getInt("p_code");
				pCount = rs.getInt("p_count");
			}
		} catch (Exception e) {
			System.out.println("상품목록에 없는 상품입니다.");
			return false;
		}
		if(pCode!=buyNum) {
			System.out.println("상품목록에 없는 상품입니다.");
			return false;
		}
		if((pCount-prodOQ) < 0) {
			System.out.println("재고가 부족합니다.");
			return false;
		}
		sql = "select point from member where id=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				if (rs.getInt("point") >= (qo * prodOQ)) {
					return true;
				} else {
					System.out.println("해당 수량을 사기엔 포인트가 부족합니다.");
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mdao.disConn();
		}
		return false;
	}

	void prodBuyComplet(int prodOQ, String id, int buyNum, String prodAddr) { // 상품 구매완료
		conn = mdao.getConn();
		String pName = "";
		int pPrice = 0;
		String sql = "select p_name,p_price,p_count from product_admin where p_code=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, buyNum);
			rs = psmt.executeQuery();
			if (rs.next()) {
				pName = rs.getString("p_name");
				pPrice = rs.getInt("p_price");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sql = "insert into product(p_code,p_id,p_names,p_addr,p_oq) values(?,?,?,?,?)";
		String sql2 = "update product_admin set p_count=((select p_count from product_admin where p_code =?)-?) where p_code=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt2 = conn.prepareStatement(sql2);
			psmt.setInt(1, buyNum);
			psmt.setString(2, id);
			psmt.setString(3, pName);
			psmt.setString(4, prodAddr);
			psmt.setInt(5, prodOQ);
			psmt2.setInt(1, buyNum);
			psmt2.setInt(2, prodOQ);
			psmt2.setInt(3, buyNum);

			int r = psmt.executeUpdate();
			int r2 = psmt2.executeUpdate();
			if (r == 1 && r2 == 1) {
				sql = "update member set point=((select point from member where id=?)-?) where id=?";
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, id);
					psmt.setInt(2, (pPrice * prodOQ));
					psmt.setString(3, id);
				
					r = psmt.executeUpdate();
					if (r == 1 ) {
						System.out.println("주문이 접수되었습니다.");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println("상품목록에 없거나 매진된 상품입니다.");
		}finally {
			mdao.disConn();
		}

	}

	void prodBuyList(String id) {
		conn = mdao.getConn();
		String sql = "select to_date(p.p_date,'yy/mm/dd')as dates,sysdate from product p,product_admin a where p.p_code = a.p_code and p.p_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				if(rs.getDate("dates").before(rs.getDate("sysdate"))) {
					Date delDate = rs.getDate("dates");
					sql = "delete from product where p_id=? and p_date=?";
					try {
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, id);
						psmt.setDate(2, delDate);
						rs = psmt.executeQuery();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sql = "select p.p_code,p.p_names,a.p_price,p.p_oq,(a.p_price * p.p_oq) as total,p.p_addr,p.p_date from product p,product_admin a "
				+ "where p.p_code = a.p_code and p.p_id=? order by 1";
		System.out.println("상품코드 \t상품명 \t가격 \t수량 \t총 가격 \t배송위치 \t예상도착날짜");
		System.out.println("========================================================");
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("p_code")+"\t"+rs.getString("p_names")+"\t"+rs.getInt("p_price")+"\t"
						+ rs.getInt("p_oq")+"\t"+rs.getInt("total")+"\t"+rs.getString("p_addr")+"\t"+rs.getString("p_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("========================================================");
	}

	boolean prodAdd(String pName,int pPrice,int pCount) {
		conn = mdao.getConn();
		String sql = "insert into product_admin values(p_num_seq.NEXTVAL,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pName);
			psmt.setInt(2, pPrice);
			psmt.setInt(3, pCount);
			int r = psmt.executeUpdate();
			if(r==1) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			mdao.disConn();
		}
		return false;
	}

	boolean prodDel(int seq) {
		conn = mdao.getConn();
		String sql = "delete from product_admin where p_code=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			
			int r = psmt.executeUpdate();
			if(r >0 ) {
				return true;
			}else {
				System.out.println("존재하지 않는 코드입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			mdao.disConn();
		}
		return false;
	}

	boolean prodMod(int seq, String pName, int pPrice, int pCount) {
		conn = mdao.getConn();
		String sql = "update product_admin set p_name=?,p_price=?,p_count=? where p_code=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pName);
			psmt.setInt(2, pPrice);
			psmt.setInt(3, pCount);
			psmt.setInt(4, seq);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		} finally {
			mdao.disConn();
		}
		return false;
	}
	ArrayList<ProductAdmin> prodListAdmin() { //글 리스트 보기
		conn = mdao.getConn();
		prodAdmins = new ArrayList<ProductAdmin>();
		String sql = "select * from product_admin order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductAdmin prods = new ProductAdmin();
				prods.setProdCode(rs.getInt("p_code"));
				prods.setProdName(rs.getString("p_name"));
				prods.setProdPrice(rs.getInt("p_price"));
				prods.setProdCount(rs.getInt("p_count"));
				// 배열의 빈곳에 한건 저장
				prodAdmins.add(prods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			mdao.disConn();
		}
		return prodAdmins;
		
	}
}
