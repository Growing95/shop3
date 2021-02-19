package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;

public class EditCommand implements Command{
@Override
public String exec(HttpServletRequest request, HttpServletResponse response) {
	String amount=request.getParameter("amount");
	String id=request.getParameter("id");
	String p_num=request.getParameter("p_num");
	CVO cvo= new CVO();
	cvo.setId(id);
	cvo.setAmount(amount);
	cvo.setP_num(p_num);
	// 수량이 변경되면 총 가격도 변경된다.
	int result=DAO.getCartAmountUpdate(cvo);
	return "MyController?cmd=viewcart";
}
}
