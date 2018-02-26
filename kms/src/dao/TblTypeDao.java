package dao;
/**
 * ���TblType�����ݰ�
 */
import java.util.List;

import impl.TblTypeMapper;
import models.TblFromModel;
import models.TblTypeModel;
import vo.TblTypeCountVO;

public class TblTypeDao extends BaseDao{
	
	/**
	 * ��ѯ���е�֪ʶ���
	 * */
	public List<TblTypeModel> findAll() throws Exception{
		String sql = "select * from tbl_type";
		return super.db.excuteQuery(sql, new TblTypeMapper());
	}
	
	/**
	 * ����ָ����֪ʶ���
	 * */
	public TblTypeModel findByID(int id) throws Exception{
		String sql = "select * from tbl_type where id=?";
		List<TblTypeModel> list = super.db.excuteQuery(sql, new TblTypeMapper(),id);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
}

