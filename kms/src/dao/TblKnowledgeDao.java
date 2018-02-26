package dao;
/**
 * 针对TblKnowledge的数据包
 */
import java.text.SimpleDateFormat;
import java.util.List;

import impl.TblKnowledgeMapper;
import vo.TblKnowledgeMapperVO;
import vo.TblTypeCountMapperVO;
import models.TblKnowledgeModel;
import vo.TblKnowledgeVO;
import vo.TblTypeCountVO;

public class TblKnowledgeDao extends BaseDao {
	/**
	 * 保存知识条目
	 * */
	public int save(TblKnowledgeModel model) throws Exception{
		String sql = "INSERT INTO tbl_knowledge(title,createDate,isPublish,fromName,typeId,content) VALUES(?,?,?,?,?,?)";
		String createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(model.getCreateDate());
		return super.db.excuteUpdate(sql, model.getTitle(),createDate,model.getIsPublish(),model.getFromName(),model.getTypeId(),model.getContent());
	}
	/**
	 * 更新知识条目
	 * */
	public int update(TblKnowledgeModel model) throws Exception{
		String sql = "update tbl_knowledge set title=?,createDate=?,isPublish=?,fromName=?,typeId=?,content=? where id=?";
		return super.db.excuteUpdate(sql, model.getTitle(), model.getCreateDate(),model.getIsPublish(),model.getFromName(),model.getTypeId(),model.getContent(),model.getId());
	}
	
	/**
	 * 删除知识条目
	 * */
	public int delete(int id) throws Exception{
		String sql = "delete from tbl_knowledge where id=?";
		return super.db.excuteUpdate(sql, id);
	}
	
	/**
	 *  查找指定的知识条目
	 * */
	public TblKnowledgeModel findById(int id) throws Exception{
		String sql = "SELECT * FROM tbl_knowledge where id=?";
		List<TblKnowledgeModel> list = super.db.excuteQuery(sql, new TblKnowledgeMapper(), id);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 查询指定的知识条目
	 * */
	public TblKnowledgeVO findVOById(int id) throws Exception{
		String sql = "SELECT tbl_knowledge.*,tbl_type.typeName,tbl_type.typeDesc FROM tbl_knowledge INNER JOIN tbl_type ON tbl_knowledge.typeId = tbl_type.id  where tbl_knowledge.id=?";
		List<TblKnowledgeVO> list = super.db.excuteQuery(sql, new TblKnowledgeMapperVO(),id);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 查询所有的知识条目
	 * */
	public List<TblKnowledgeModel> findAll() throws Exception{
		String sql = "SELECT * FROM tbl_knowledge order by id";
		return super.db.excuteQuery(sql, new TblKnowledgeMapper());
	}
	
	/**
	 * 查询所有的知识条目
	 * */
	public List<TblKnowledgeVO> list() throws Exception{
		String sql = "SELECT tbl_knowledge.*,tbl_type.typeName,tbl_type.typeDesc FROM tbl_knowledge INNER JOIN tbl_type ON tbl_knowledge.typeId = tbl_type.id order by tbl_knowledge.id";
		return super.db.excuteQuery(sql, new TblKnowledgeMapperVO());
	}
	
	/**
	 * 查询满足条件的所有的知识条目
	 * */
	public List<TblKnowledgeVO> list(String where) throws Exception{
		String sql = "SELECT tbl_knowledge.*,tbl_type.typeName,tbl_type.typeDesc FROM tbl_knowledge INNER JOIN tbl_type ON tbl_knowledge.typeId = tbl_type.id where 1=1 "+ where +" order by tbl_knowledge.id";
		return super.db.excuteQuery(sql, new TblKnowledgeMapperVO() );
	}
	
	/**
	 * 统计每种知识类别中知识条目的数量
	 * */
	public List<TblTypeCountVO> counted() throws Exception{
		String sql = "SELECT typeid ,COUNT(*) AS `count`,'' AS typeName FROM tbl_knowledge GROUP BY typeId";
		return super.db.excuteQuery(sql, new TblTypeCountMapperVO());
	}
}
