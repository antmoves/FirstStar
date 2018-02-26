package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mapper.RowMapper;

public class DBhelper {
	//声明定义d
	private Connection conn=null;
	private PreparedStatement stat=null;
	private ResultSet rs=null;
	private final static String PASS="root";
	private final static String PASSWORD="root";
	private final static String URL="jdbc:mysql://localhost:3306/kmdb";
	//使用静态块进行初步连接
	static {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//连接方法(并对连接对象进行初始化)
	private void getConnection() throws ClassNotFoundException, SQLException{
		//若链接对象为NULL或者链接是关闭的则进行链接
		if(conn==null||conn.isClosed()==true){
			conn=DriverManager.getConnection(URL,PASS,PASSWORD);
		}
	}
	//为占位符进行赋值
	private void setParameters(Object ...values) throws SQLException{
		if(values!=null&&values.length>0){
			for (int i = 0; i < values.length; i++) {
				stat.setObject(i+1, values[i]);//索引从1开始
			}
		}
	}
	//增删改，的方法
	public int excuteUpdate(String sql,Object ...values) throws ClassNotFoundException, SQLException{
		getConnection();
		stat=conn.prepareStatement(sql);
		setParameters(values);
		int count=stat.executeUpdate();
		return count;
	}
	//查方法（用集合来存储数据）
	public <T>List<T> excuteQuery(String sql,RowMapper<T> mapper,Object ...values) throws Exception{
		getConnection();
		stat=conn.prepareStatement(sql);
		setParameters(values);
		ResultSet rs=stat.executeQuery();
		List<T> tlist = new ArrayList<>();

		while (rs.next()) {
			T t =mapper.rowMapper(rs);
			tlist.add(t);
		}
		return tlist;
	}
		
	//删除方法
	public void close(){
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stat!=null){
					stat.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
