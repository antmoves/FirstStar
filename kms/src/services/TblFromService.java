package services;

import java.util.List;

import dao.TblFromDao;
import models.TblFromModel;

public class TblFromService {
	private TblFromDao dao =new TblFromDao();
	
	/**
	 * ��ѯ���е�֪ʶ��Դ
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
