package mapper;

import java.sql.ResultSet;

/**
 * ����rsӳ�䵽model
 * */
public interface RowMapper<T> {
	public abstract T rowMapper(ResultSet rs) throws Exception;
}

