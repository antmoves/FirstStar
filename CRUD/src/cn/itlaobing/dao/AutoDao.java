package cn.itlaobing.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import cn.itlaobing.exception.BusinessException;
import cn.itlaobing.model.AutoModel;

public class AutoDao {
	//创建DB类链接数据库
	private DBhelper db =new DBhelper();
	//添加汽车信息
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
			throw new BusinessException("添加车辆信息出错", e);
		}finally {
			db.close();
		}
		return i;
	}
	
	//修改汽车信息
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
			throw new BusinessException("修改汽车信息失败", e);
		}finally {
			db.close();
		}
		return i;
	}
	
	//删除指定车辆
	public int delete(int id) throws Exception{
		int i = 0;
		try {
			String sql ="delete from auto WHERE id=?";
			i = db.excuteUpdate(sql, id);
		}catch(Exception e) {
			e.printStackTrace();
			throw new BusinessException("删除车辆有误", e);
		}finally {
			db.close();
		}
		return i;
	}
	//查询所有车辆
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
			throw new BusinessException("查询所有车辆有误", e);
		}finally {
			db.close();
		}
		return list;
	}
	//通过id查询车辆
	public AutoModel findById(int id) throws Exception{
		//先将查询结果集置零
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
			throw new BusinessException("查询ID车辆有误", e);
		}finally {
			db.close();
		}
		return model;
	}
	//通过车牌查询车辆
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
			throw new BusinessException("查询车辆车牌有误", e);
		}finally {
			db.close();
		}
		return model;
	}
}
