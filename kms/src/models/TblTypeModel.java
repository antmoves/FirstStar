package models;
/**
 * TblType µÃÂ¿‡
 */
import java.io.Serializable;

public class TblTypeModel implements Serializable {
	private int id;
	private String typeName;
	private String typeDesc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	
	
}
