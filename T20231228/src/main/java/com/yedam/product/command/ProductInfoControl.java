package com.yedam.product.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;
import com.yedam.product.vo.ProductVO;

public class ProductInfoControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String pCode = req.getParameter("pcode");
		ProductService svc = new ProductServiceImpl();
		ProductVO vo = svc.getProduct(pCode);
		
		List<ProductVO> relist = svc.productList(); //데이터 받음
		List<ProductVO> list = new ArrayList<ProductVO>();
		if(relist.size() <=4) {
			for(ProductVO p : relist) {
				list.add(p);
			}
		}else {
			for(int i = 0;i<4;i++) {
				list.add(relist.get(i));
			}
		}
		
		req.setAttribute("list", list);
		req.setAttribute("vo", vo);
		
		//페이지 이동(forward)
				RequestDispatcher rd = req.getRequestDispatcher("product/productInfo.tiles");
				try {
					rd.forward(req, resp);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
		
		
		
	}

}
