package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;
import com.ict.db.MVO;
import com.ict.db.VO;

public class ViewcartCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MVO mvo = (MVO)request.getSession().getAttribute("m_vo");
		String id=mvo.getId();
		// 해당 id가 전체 카트정보를 가져오기
		List<CVO> clist = DAO.getAllCart(id);
		
		request.setAttribute("clist", clist);
		return "view/viewcart.jsp";
	}
}