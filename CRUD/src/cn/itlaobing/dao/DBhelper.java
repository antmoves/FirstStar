package cn.itlaobing.dao;

import java.sql.*;

public class DBhelper {
	private Connection conn=null;
	private PreparedStatement stat=null;
	private ResultSet rs=null;
	private final static String PASS="root";
	private final static String URL="jdbc:mysql://localhost:3306/crud";
	private final static String PASSWORD="root";
	//��̬��ֻ����һ��
	static {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���ӷ���(�������Ӷ�����г�ʼ��)
	private void getConnection() throws ClassNotFoundException, SQLException{
		if(conn==null||conn.isClosed()==true){
			conn=DriverManager.getConnection(URL,PASS,PASSWORD);
		}
	}
	//Ϊռλ�����и�ֵ
	private void setParameters(Object ...values) throws SQLException{
		if(values!=null&&values.length>0){
			for (int i = 0; i < values.length; i++) {
				stat.setObject(i+1, values[i]);
			}
		}
	}
	//��ɾ�ģ��ķ���
	public int excuteUpdate(String sql,Object ...values) throws ClassNotFoundException, SQLException{
		getConnection();
		stat=conn.prepareStatement(sql);
		setParameters(values);
		int count=stat.executeUpdate();
		return count;
	}
	//�鷽��
	public ResultSet excuteQuery(String sql,Object ...values) throws SQLException, ClassNotFoundException{
		getConnection();
		stat=conn.prepareStatement(sql);
		setParameters(values);
		ResultSet rs=stat.executeQuery();
		return rs;
	}
	
	//ɾ������
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