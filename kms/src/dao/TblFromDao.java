package dao;
/**
 * 针对TblFrom建立的数据包
 */
import java.util.List;

import impl.TblFromMapper;
import models.TblFromModel;

public class TblFromDao extends BaseDao{
	
	/**
	 * 查询所有的知识来源
	 * */
	public List<TblFromModel> findAll() throws Exception{
		String sql="select * from tbl_from";
		return super.db.excuteQuery(sql, new TblFromMapper());
	}
}
