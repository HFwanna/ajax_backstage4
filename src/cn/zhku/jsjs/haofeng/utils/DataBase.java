package cn.zhku.jsjs.haofeng.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DataBase {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DRIVER_URL = "jdbc:mysql://127.0.0.1:3306/test";
	private static final String DRIVER_USER = "root";
	private static final String DRIVER_PWD = "123";
	protected Connection conn=null;
	protected PreparedStatement pst=null;
	protected ResultSet rs=null;
	
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//链接数据库
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DRIVER_URL,DRIVER_USER,DRIVER_PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//查询
	public ResultSet commonQuery(String sql,Object...params) throws SQLException{
		conn = getConnection();
		pst=conn.prepareStatement(sql);
		if(params !=null && params.length>0){
			setValue(pst,params);
		}
		rs=pst.executeQuery();
		return rs;
	}
	
	//增删改
	public int commonUpdate(String sql,Object...params) throws SQLException{
		int result =0;
		conn=getConnection();
		try {
			pst=conn.prepareStatement(sql);
			if(params !=null && params.length>0){
				setValue(pst,params);
			}
			result=pst.executeUpdate();
		}finally{
			closeAll(conn, pst, rs);
		}
		return result;
	}
		
	private void setValue(PreparedStatement pst2, Object[] params) throws SQLException {
		for(int i=0;i<params.length;i++){
			pst2.setObject(i+1, params[i]);
		}
	}

	//关闭数据库
	public void closeAll(Connection conn,PreparedStatement pst,ResultSet rs){
		try {
			if(rs !=null){
				rs.close();
			}
			if(pst !=null){
				pst.close();
			}
			if(conn !=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
