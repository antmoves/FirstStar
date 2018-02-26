package vo;
/*
 * 导入对象
 */
import java.io.Serializable;
import java.sql.ResultSet;

import mapper.RowMapper;
import vo.TblKnowledgeVO;

public class TblKnowledgeMapperVO implements RowMapper<TblKnowledgeVO> ,Serializable{

	@Override
	public TblKnowledgeVO rowMapper(ResultSet rs) throws Exception {
		TblKnowledgeVO vo =new TblKnowledgeVO();
		vo.getKnowledgeModel().setId(rs.getInt("id"));
		vo.getKnowledgeModel().setTitle(rs.getString("title"));
		vo.getKnowledgeModel().setContent(rs.getString("content"));
		vo.getKnowledgeModel().setCreateDate(rs.getTimestamp("createDate"));
		vo.getKnowledgeModel().setIsPublish(rs.getInt("isPublish"));
		vo.getKnowledgeModel().setFromName(rs.getString("fromName"));
		vo.getKnowledgeModel().setTypeId(rs.getInt("typeId"));
		vo.getTypeModel().setTypeName(rs.getString("typeName"));
		vo.getTypeModel().setTypeDesc(rs.getString("typeDesc"));
		return vo;
	}

}