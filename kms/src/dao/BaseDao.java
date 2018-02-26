package dao;

public class BaseDao {
	protected DBhelper db=new DBhelper();
	public void close(){
		db.close();
	}
}
