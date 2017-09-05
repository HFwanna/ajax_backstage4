package cn.zhku.jsjs.haofeng.domain;

import java.util.Set;

public class MyTable {
//	 create table my_table(
//			 `t_id` integer not null,
//			 `t_name` varchar(255) null,
//			 primary key (`t_id`)
//			 );
	private Integer t_id;
	private String t_name;
	public Integer getT_id() {
		return t_id;
	}
	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	private Set<MyHibernate> myHibernate;
	public Set<MyHibernate> getMyHibernate() {
		return myHibernate;
	}
	public void setMyHibernate(Set<MyHibernate> myHibernate) {
		this.myHibernate = myHibernate;
	}
	
	
}
