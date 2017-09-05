package cn.zhku.jsjs.haofeng.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import cn.zhku.jsjs.haofeng.utils.HibernateUtils;

public class SearchHibernateDao {
	public List<String> searchHname(String content){
		Session session = HibernateUtils.getCurrentSession();
		String sql = "select h_name from my_hibernate where h_name like '%"+content+"%'";
		SQLQuery query = session.createSQLQuery(sql);
		List<String> list = query.list();
		System.out.println("dao:"+list);
		return list;
	}
}
