package services;

import java.util.List;

import dao.TblTypeDao;
import models.TblTypeModel;

public class TblTypeService {
	private TblTypeDao dao =new TblTypeDao();
	public List<TblTypeModel> findAll() throws Exception{
		try {
			return dao.findAll();
		} catch (Exception e) {
			throw e;
		}finally{
			dao.close();
		}
	}
}
