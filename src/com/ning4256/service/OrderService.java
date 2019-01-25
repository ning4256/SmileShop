package com.ning4256.service;

import java.sql.Connection;
import java.util.Map;

import com.ning4256.dao.Vi_detailOrderDAO;
import com.ning4256.po.OrderPO;
import com.ning4256.utils.C3P0Util;


public class OrderService {

	public Map<String, OrderPO> findOrderByLoginId(Object ologinId) {
		// TODO Auto-generated method stub
		Map<String, OrderPO> order=null;
		String loginId = (String) ologinId;
		Connection con = C3P0Util.getConnection();
		Vi_detailOrderDAO view = new Vi_detailOrderDAO();
		order=view.findAllByLoginId(con,loginId);
		
		C3P0Util.close(con);
		return order;
	}

}
