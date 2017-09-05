package cn.zhku.jsjs.haofeng.domain;

import java.util.Set;

public class MyHibernate {
//	create table my_hibernate(
//			`h_id` integer not null auto increatment,
//			`h_name` varchar (255) null,
//			primary key (`h_id`)
//		) 
	
	private Integer h_id;
	private String h_name;
	
	public Integer getH_id() {
		return h_id;
	}
	public void setH_id(Integer h_id) {
		this.h_id = h_id;
	}
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	private Set<MyTable> myTable;
	public Set<MyTable> getMyTable() {
		return myTable;
	}
	public void setMyTable(Set<MyTable> myTable) {
		this.myTable = myTable;
	} 
	
}
