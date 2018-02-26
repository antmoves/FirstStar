package cn.itlaobing.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import cn.itlaobing.exception.BusinessException;
import cn.itlaobing.model.AutoModel;

public class AutoDao {
	//����DB���������ݿ�
	private DBhelper db =new DBhelper();
	//���������Ϣ
	public int save(AutoModel model) throws Exception{
		int i = 0;
		try {
			String sql ="INSERT INTO auto(autotype,pailiang,autono,price) VALUES(?,?,?,?)";
			Object []values=new Object[] {
					model.getAutotype(),
					model.getPailiang(),
					model.getAutono(),
					model.getPrice()
			};
			i = db.excuteUpdate(sql, values);
		}catch(Exception e) {
			e.printStackTrace();
			throw new BusinessException("��ӳ�����Ϣ����", e);
		}finally {
			db.close();
		}
		return i;
	}
	
	//�޸�������Ϣ
	public int update(AutoModel model) throws Exception{
		int i = 0;
		try {
			String sql ="UPDATE auto SET autotype=?,pailiang=?,autono=?,price=? WHERE id=?";
			Object []values=new Object[] {
					model.getAutotype(),
					model.getPailiang(),
					model.getAutono(),
					model.getPrice(),
					model.getId()
			};
			i = db.excuteUpdate(sql, values);
		}catch(Exception e) {
			e.printStackTrace();
			throw new BusinessException("�޸�������Ϣʧ��", e);
		}finally {
			db.close();
		}
		return i;
	}
	
	//ɾ��ָ������
	public int delete(int id) throws Exception{
		int i = 0;
		try {
			String sql ="delete from auto WHERE id=?";
			i = db.excuteUpdate(sql, id);
		}catch(Exception e) {
			e.printStackTrace();
			throw new BusinessException("ɾ����������", e);
		}finally {
			db.close();
		}
		return i;
	}
	//��ѯ���г���
	public List<AutoModel> findAll() throws Exception{
		List<AutoModel> list =new ArrayList<AutoModel>();
		AutoModel model=null;
		try {
			String sql = "select * from auto";
			ResultSet rs = db.excuteQuery(sql);
			while(rs.next()) {
				model =new AutoModel();
				model.setId(rs.getInt("id"));
				model.setAutotype(rs.getString("autotype"));
				model.setPailiang(rs.getString("pailiang"));
				model.setAutono(rs.getString("autono"));
				model.setPrice(rs.getDouble("price"));
				list.add(model);
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new BusinessException("��ѯ���г�������", e);
		}finally {
			db.close();
		}
		return list;
	}
	//ͨ��id��ѯ����
	public AutoModel findById(int id) throws Exception{
		//�Ƚ���ѯ���������
		AutoModel model =null;
		try {
			String sql = "select * from auto where id=?";
			ResultSet rs = db.excuteQuery(sql, id);
			if(rs.next()) {
				model =new AutoModel();
				model.setId(rs.getInt("id"));
				model.setAutotype(rs.getString("autotype"));
				model.setPailiang(rs.getString("pailiang"));
				model.setAutono(rs.getString("autono"));
				model.setPrice(rs.getDouble("price"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new BusinessException("��ѯID��������", e);
		}finally {
			db.close();
		}
		return model;
	}
	//ͨ�����Ʋ�ѯ����
	public AutoModel findByAutoNO(String autono)throws Exception {
		AutoModel model=null;
		String sql="select * from auto where autono=?";
		try {
			ResultSet rs=db.excuteQuery(sql, autono);
			if(rs.next()) {
				model =new AutoModel();
				model.setId(rs.getInt("id"));
				model.setAutotype(rs.getString("autotype"));
				model.setPailiang(rs.getString("pailiang"));
				model.setAutono(rs.getString("autono"));
				model.setPrice(rs.getDouble("price"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new BusinessException("��ѯ������������", e);
		}finally {
			db.close();
		}
		return model;
	}
}
