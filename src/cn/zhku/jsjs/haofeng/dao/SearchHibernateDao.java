package cn.zhku.jsjs.haofeng.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.zhku.jsjs.haofeng.domain.MyHibernate;


public class SearchHibernateDao extends HibernateDaoSupport {
	

	public List<String> searchHname(final String content){
		return getHibernateTemplate().execute(new HibernateCallback<List<String>>() {

			@Override
			public List<String> doInHibernate(Session session) throws HibernateException {
				String sql = "select h_name from my_hibernate where h_name like '%"+content+"%'";
				SQLQuery query = session.createSQLQuery(sql);
				List<String> list = query.list();
				System.out.println("dao:"+list);
				return list;
			}
		});
	}
}
