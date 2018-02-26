package cn.itlaobing.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cn.itlaobing.dao.AutoDao;
import cn.itlaobing.model.AutoModel;

public class AutoService {
	private AutoDao dao =new AutoDao();
	//添加车辆方法
	public int save(AutoModel model) throws Exception{
		//1:验证车牌是否存在（等于NULL就对车辆信息进行保存）
		if(dao.findByAutoNO(model.getAutono())!=null) {
			return -1;
		}
		//2：保存车辆信息
		else {
			return dao.save(model);
		}
	}
	
	//修改汽车信息
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
	
	//删除指定车辆
	public int delete(int id) throws Exception{
		return dao.delete(id);
	}
	//查询所有车辆
	public List<AutoModel> findAll() throws Exception{
		return dao.findAll();
	}
	//通过id查询车辆
	public AutoModel findById(int id) throws Exception{
		return dao.findById(id);
	}
}