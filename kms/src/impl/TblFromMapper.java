package impl;

import java.sql.ResultSet;

import mapper.RowMapper;
import models.TblFromModel;

public class TblFromMapper implements RowMapper<TblFromModel> {

	@Override
	public TblFromModel rowMapper(ResultSet rs) throws Exception {
		TblFromModel model =new TblFromModel();
		model.setId(rs.getInt("id"));
		model.setFromName(rs.getString("fromName"));
		return model;
	}
}
