package cn.zhku.jsjs.haofeng.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.zhku.jsjs.haofeng.dao.SearchHibernateDao;
import cn.zhku.jsjs.haofeng.utils.HibernateUtils;

public class SearchHibernateService {
	public List<String> SearchHname(String content){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		SearchHibernateDao shd = new SearchHibernateDao();
		List<String> list = shd.searchHname(content);
		tx.commit();
		return list;
		
		
		
	}
}
