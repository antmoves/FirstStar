package impl;

import java.sql.ResultSet;

import mapper.RowMapper;
import models.TblKnowledgeModel;

public class TblKnowledgeMapper implements RowMapper<TblKnowledgeModel>{

	@Override
	public TblKnowledgeModel rowMapper(ResultSet rs) throws Exception {
		TblKnowledgeModel model =new TblKnowledgeModel();
		model.setId(rs.getInt("id"));
		model.setTitle(rs.getString("title"));
		model.setContent(rs.getString("content"));
		model.setCreateDate(rs.getTimestamp("createDate"));
		model.setIsPublish(rs.getInt("isPublish"));
		model.setFromName(rs.getString("fromName"));
		model.setTypeId(rs.getInt("typeId"));
		return model;
	}
}
