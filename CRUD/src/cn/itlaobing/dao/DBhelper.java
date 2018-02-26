package cn.itlaobing.dao;

import java.sql.*;

public class DBhelper {
	private Connection conn=null;
	private PreparedStatement stat=null;
	private ResultSet rs=null;
	private final static String PASS="root";
	private final static String URL="jdbc:mysql://localhost:3306/crud";
	private final static String PASSWORD="root";
	//静态块只加载一次
	static {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//连接方法(并对连接对象进行初始化)
	private void getConnection() throws ClassNotFoundException, SQLException{
		if(conn==null||conn.isClosed()==true){
			conn=DriverManager.getConnection(URL,PASS,PASSWORD);
		}
	}
	//为占位符进行赋值
	private void setParameters(Object ...values) throws SQLException{
		if(values!=null&&values.length>0){
			for (int i = 0; i < values.length; i++) {
				stat.setObject(i+1, values[i]);
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
	//查方法
	public ResultSet excuteQuery(String sql,Object ...values) throws SQLException, ClassNotFoundException{
		getConnection();
		stat=conn.prepareStatement(sql);
		setParameters(values);
		ResultSet rs=stat.executeQuery();
		return rs;
	}
	
	//删除方法
	public void close(){
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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