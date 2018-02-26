package vo;

import java.sql.ResultSet;

import mapper.RowMapper;
import vo.TblTypeCountVO;

public class TblTypeCountMapperVO implements RowMapper<TblTypeCountVO> {

	@Override
	public TblTypeCountVO rowMapper(ResultSet rs) throws Exception {
		TblTypeCountVO vo =new TblTypeCountVO();
		vo.setCount(rs.getInt("count"));
		vo.setTypeId(rs.getInt("typeId"));
		vo.setTypeName(rs.getString("typeName"));
		return vo;
	}

}
