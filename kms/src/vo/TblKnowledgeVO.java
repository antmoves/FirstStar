package vo;

import java.io.Serializable;

import models.TblFromModel;
import models.TblKnowledgeModel;
import models.TblTypeModel;

public class TblKnowledgeVO implements Serializable{
	private TblKnowledgeModel knowledgeModel =new TblKnowledgeModel();
	private TblTypeModel typeModel =new TblTypeModel();
	public TblKnowledgeModel getKnowledgeModel() {
		return knowledgeModel;
	}
	public void setKnowledgeModel(TblKnowledgeModel knowledgeModel) {
		this.knowledgeModel = knowledgeModel;
	}
	public TblTypeModel getTypeModel() {
		return typeModel;
	}
	public void setTypeModel(TblTypeModel typeModel) {
		this.typeModel = typeModel;
	}
}
