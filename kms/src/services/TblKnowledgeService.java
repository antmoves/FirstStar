package services;

import java.util.List;

import dao.TblKnowledgeDao;
import dao.TblTypeDao;
import models.TblKnowledgeModel;
import models.TblTypeModel;
import vo.TblKnowledgeVO;
import vo.TblTypeCountVO;

public class TblKnowledgeService {
	private TblKnowledgeDao dao =new TblKnowledgeDao();
	
	/**
	 * ����֪ʶ��Ŀ
	 * */
	public int save(TblKnowledgeModel model) throws Exception{
		try {
			return dao.save(model);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.close();
		}
	}
	
	/**
	 * ����֪ʶ��Ŀ
	 * */
	public int update(TblKnowledgeModel model) throws Exception{
		try {
			TblKnowledgeModel temp = dao.findById(model.getId());
			temp.setContent(model.getContent());
			temp.setFromName(model.getFromName());
			temp.setIsPublish(model.getIsPublish());
			temp.setTitle(model.getTitle());
			temp.setTypeId(model.getTypeId());
			return dao.update(temp);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.close();
		}
	}
	
	/**
	 * ɾ��֪ʶ��Ŀ
	 * */
	public int delete(int id) throws Exception{
		try {
			return dao.delete(id);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.close();
		}
	}
	
	/**
	 *  ����ָ����֪ʶ��Ŀ
	 * */
	public TblKnowledgeModel findById(int id) throws Exception{
		try {
			return dao.findById(id);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.close();
		}
	}
	
	/**
	 * ��ѯָ����֪ʶ��Ŀ
	 * */
	public TblKnowledgeVO findVOById(int id) throws Exception{
		try {
			return dao.findVOById(id);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.close();
		}
	}
	
	/**
	 * ��ѯ���е�֪ʶ��Ŀ
	 * */
	public List<TblKnowledgeModel> findAll() throws Exception{
		try {
			return dao.findAll();
		} catch (Exception e) {
			throw e;
		}finally{
			dao.close();
		}
	}
	
	/**
	 * ��ѯ���е�֪ʶ��Ŀ
	 * */
	public List<TblKnowledgeVO> list() throws Exception{
		try {
			return dao.list();
		} catch (Exception e) {
			throw e;
		}finally{
			dao.close();
		}
	}
	
	/**
	 * ��ѯ�������������е�֪ʶ��Ŀ
	 * */
	public List<TblKnowledgeVO> list(String where) throws Exception{
		try {
			return dao.list(where);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.close();
		}
	}
	
	/**
	 * ͳ��ÿ��֪ʶ�����֪ʶ��Ŀ������
	 * */
	public List<TblTypeCountVO> counted() throws Exception{
		TblTypeDao typeDao =new TblTypeDao();
		List<TblTypeCountVO> vos = dao.counted();
		if(vos!=null && vos.size()>0){
			for (int i = 0; i <vos.size(); i++) {
				TblTypeModel typeModel = typeDao.findByID(vos.get(i).getTypeId());
				vos.get(i).setTypeName(typeModel.getTypeName());
			}
		}
		return vos;
	}
}
