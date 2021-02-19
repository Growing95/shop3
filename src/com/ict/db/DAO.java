package com.ict.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class DAO {
	private static SqlSession ss;

	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = DBService.getFactory().openSession(false);
		}
		return ss;
	}
	public static List<VO> getList(String category){
		List<VO> list=new ArrayList<VO>();
		list=getSession().selectList("list", category);
	
		return list;
	}
	
	public static MVO getLogIn(MVO mvo) {
		MVO m_vo=new MVO();
		m_vo=getSession().selectOne("login", mvo);
		
		return m_vo;
	}
	public static VO getOneList(String idx) {
		VO vo= new VO();
		vo=getSession().selectOne("onelist", idx);
		return vo;
	}
	
	public static int getProductInsert(VO vo) {
		int result=0;
		result=getSession().insert("productadd", vo);
		ss.commit();
		return result;
	}
	// id와 제품번호를 받아서 카트정보를 구하자
	public static CVO getCartList(String id, String p_num) {
		CVO cvo=new CVO();
		CVO c_vo=new CVO();
		c_vo.setId(id);
		c_vo.setP_num(p_num);
		cvo=getSession().selectOne("search_cart", c_vo);
		return cvo;
	}
	
	public static int getCartInsert(CVO c_vo) {
		int result=0;
		result=getSession().insert("cartInsert", c_vo);
		ss.commit();
		return result;
	}
	
	public static int getCartUpdate(CVO cvo) {
		int result=0;
		result=getSession().update("cartUpdate", cvo);
		ss.commit();
		return result;
	}
	public static List<CVO> getAllCart(String id){
		List<CVO> clist= new ArrayList<CVO>();
		clist=getSession().selectList("allCart", id);
		return clist;
		
	}
	public static int getCartAmountUpdate(CVO cvo) {
		int result=0;
		result=getSession().update("cartAmountUpdate", cvo);
		ss.commit();
		return result;
	}
	public static int getCartDelete(CVO cvo) {
		int result=0;
		result=getSession().update("cartDelete", cvo);
		ss.commit();
		return result;
	}
	public static int getChkDelete(String c_idx) {
		int result=0;
		result=getSession().delete("chkDelete", c_idx);
		ss.commit();
		return result;
	}
}
