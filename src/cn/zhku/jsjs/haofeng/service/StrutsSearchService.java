package cn.zhku.jsjs.haofeng.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.zhku.jsjs.haofeng.dao.SearchHibernateDao;
import cn.zhku.jsjs.haofeng.utils.HibernateUtils;

public class StrutsSearchService {

	public List<String> SearchHname(String content) {
		// 管理事务
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//调用dao层查询方法
		SearchHibernateDao ssd = new SearchHibernateDao();
		List<String> list = ssd.searchHname(content);
		System.out.println("service"+list);
		tx.commit();
		return list;
	}
	
}
