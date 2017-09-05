package cn.zhku.jsjs.haofeng.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zhku.jsjs.haofeng.dao.SearchHibernateDao;


@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class StrutsSearchService {
	SearchHibernateDao searchHibernateDao ;

	public void setSearchHibernateDao(SearchHibernateDao searchHibernateDao) {
		this.searchHibernateDao = searchHibernateDao;
	}

	public List<String> SearchHname(String content) {
		//调用dao层查询方法
		List<String> list = searchHibernateDao.searchHname(content);
		System.out.println("service"+list);
		return list;
	}
	
}
