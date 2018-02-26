package mapper;

import java.sql.ResultSet;

/**
 * °ïÖúrsÓ³Éäµ½model
 * */
public interface RowMapper<T> {
	public abstract T rowMapper(ResultSet rs) throws Exception;
}

