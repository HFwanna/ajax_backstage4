package cn.zhku.jsjs.haofeng.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zhku.jsjs.haofeng.utils.DataBase;

public class SearchDao extends DataBase {

	public List<String> search(String content) throws SQLException {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		String sql = "select * from cst_linkman where lkm_name like '%"+content+"%'" ;
		rs = commonQuery(sql);
		while(rs.next()){
			list.add(rs.getString("lkm_name"));
		}
		return list;
	}

}
