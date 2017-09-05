package cn.zhku.jsjs.haofeng.service;

import java.sql.SQLException;
import java.util.List;

import cn.zhku.jsjs.haofeng.dao.SearchDao;

public class SearchService {

	public List<String> search(String content) throws SQLException {
		// TODO Auto-generated method stub
		SearchDao sd = new SearchDao();
		List<String> list = sd.search(content);
		return list;
	}
	
}
