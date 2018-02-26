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
	//��������d
	private Connection conn=null;
	private PreparedStatement stat=null;
	private ResultSet rs=null;
	private final static String PASS="root";
	private final static String PASSWORD="root";
	private final static String URL="jdbc:mysql://localhost:3306/kmdb";
	//ʹ�þ�̬����г�������
	static {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//���ӷ���(�������Ӷ�����г�ʼ��)
	private void getConnection() throws ClassNotFoundException, SQLException{
		//�����Ӷ���ΪNULL���������ǹرյ����������
		if(conn==null||conn.isClosed()==true){
			conn=DriverManager.getConnection(URL,PASS,PASSWORD);
		}
	}
	//Ϊռλ�����и�ֵ
	private void setParameters(Object ...values) throws SQLException{
		if(values!=null&&values.length>0){
			for (int i = 0; i < values.length; i++) {
				stat.setObject(i+1, values[i]);//������1��ʼ
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
	//�鷽�����ü������洢���ݣ�
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
		
	//ɾ������
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
