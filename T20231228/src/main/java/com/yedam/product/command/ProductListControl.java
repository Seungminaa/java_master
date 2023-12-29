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

public class ProductListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		ProductService svc = new ProductServiceImpl();
		List<ProductVO> relist = svc.productList(); //데이터 받음
		List<ProductVO> list = new ArrayList<ProductVO>(); //최종으로 보낼줌
		for(ProductVO p : relist) {
			ProductVO setList = new ProductVO();
			setList.setProductCode(p.getProductCode());
			setList.setProductName(p.getProductName());
			setList.setProductDesc(p.getProductDesc());
			setList.setOriginPrice(p.getOriginPrice());
			setList.setSalePrice(p.getSalePrice());
			setList.setLikeIt(p.getLikeIt());
			setList.setImage("images/"+p.getImage());
			list.add(setList);
		}
		
		req.setAttribute("productList", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("product/productList.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
