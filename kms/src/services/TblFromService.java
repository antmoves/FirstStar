package services;

import java.util.List;

import dao.TblFromDao;
import models.TblFromModel;

public class TblFromService {
	private TblFromDao dao =new TblFromDao();
	
	/**
	 * 查询所有的知识来源
	 * */
	public List<TblFromModel> findAll() throws Exception{
		try {
			return dao.findAll();
		} catch (Exception e) {
			throw e;
		}finally{
			dao.close();
		}
	}
}
