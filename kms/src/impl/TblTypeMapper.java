package impl;

import java.sql.ResultSet;

import mapper.RowMapper;
import models.TblTypeModel;

public class TblTypeMapper implements RowMapper<TblTypeModel> {

	@Override
	public TblTypeModel rowMapper(ResultSet rs) throws Exception {
		TblTypeModel model =new TblTypeModel();
		model.setId(rs.getInt("id"));
		model.setTypeName(rs.getString("typeName"));
		model.setTypeDesc(rs.getString("typeDesc"));
		return model;
	}
}
