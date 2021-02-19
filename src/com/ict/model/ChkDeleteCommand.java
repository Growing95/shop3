package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;

public class ChkDeleteCommand implements Command{
@Override
public String exec(HttpServletRequest request, HttpServletResponse response) {
	String c_idx=request.getParameter("c_idx");
	if (c_idx == null) {
		return "view/viewcart.jsp";
	}else {
		int result=DAO.getChkDelete(c_idx);
	}
	
	return "view/viewcart.jsp";
}
}
