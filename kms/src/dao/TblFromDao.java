package dao;
/**
 * ���TblFrom���������ݰ�
 */
import java.util.List;

import impl.TblFromMapper;
import models.TblFromModel;

public class TblFromDao extends BaseDao{
	
	/**
	 * ��ѯ���е�֪ʶ��Դ
	 * */
	public List<TblFromModel> findAll() throws Exception{
		String sql="select * from tbl_from";
		return super.db.excuteQuery(sql, new TblFromMapper());
	}
}
