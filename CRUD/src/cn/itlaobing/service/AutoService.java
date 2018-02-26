package cn.itlaobing.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cn.itlaobing.dao.AutoDao;
import cn.itlaobing.model.AutoModel;

public class AutoService {
	private AutoDao dao =new AutoDao();
	//��ӳ�������
	public int save(AutoModel model) throws Exception{
		//1:��֤�����Ƿ���ڣ�����NULL�ͶԳ�����Ϣ���б��棩
		if(dao.findByAutoNO(model.getAutono())!=null) {
			return -1;
		}
		//2�����泵����Ϣ
		else {
			return dao.save(model);
		}
	}
	
	//�޸�������Ϣ
	public int update(AutoModel model) throws Exception{
		AutoModel model1 = dao.findById(model.getId());
		if(model.getAutono()!=null ) {
			model1.setAutono(model.getAutono());
		}
		if(model.getAutotype()!=null) {
			model1.setAutotype(model.getAutotype());
		}
		if(model.getPailiang()!=null) {
			model1.setPailiang(model.getPailiang());
		}
		return dao.update(model1);
	}
	
	//ɾ��ָ������
	public int delete(int id) throws Exception{
		return dao.delete(id);
	}
	//��ѯ���г���
	public List<AutoModel> findAll() throws Exception{
		return dao.findAll();
	}
	//ͨ��id��ѯ����
	public AutoModel findById(int id) throws Exception{
		return dao.findById(id);
	}
}