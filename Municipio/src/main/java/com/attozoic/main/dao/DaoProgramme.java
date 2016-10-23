package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActiveState;
import com.attozoic.main.model.Programme;
import com.attozoic.main.repositories.RepositoryProgramme;

@Repository
public class DaoProgramme {
//	@Autowired
//		private SessionFactory sessionFactory;
	
	@Autowired
	private RepositoryProgramme repoProgramme;
	
	public Page<Programme> findAll() {	
//		try{
//			Session sesion = sessionF.openSession();
//			Criteria nekiCrit = sesion.createCriteria(Programme.class);
//			// nekiCrit.add(Restrictions.eq("name", "pera"))
//			List<Programme> asdf = nekiCrit.list();
//			System.out.println("Total: " + asdf.size());
//		}catch (Exception e) {
//			System.out.println("Ex: "  + e.getMessage());
//			e.printStackTrace();
//		}

		Page<Programme> page = new PageImpl<>(repoProgramme.findAll());
		return page;
	}
	
	public Programme findOne(Long uid) {
		return repoProgramme.findOne(uid);
	}
	
	public Programme save(Programme programme) {
		return repoProgramme.save(programme);
	}
	
	public Programme update(Programme programme) {
		return repoProgramme.save(programme);
	}
	
	public void delete(Long uid) {
		repoProgramme.delete(uid);
	}
	
	public void archive(Long uid) {
		//sessionFactory.openSession().create
		Programme programme = repoProgramme.findOne(uid);
		programme.setActiveState(ActiveState.ARCHIVED);
		repoProgramme.save(programme);
	}
	
	public void unarchive(Long uid) {
		Programme programme = repoProgramme.findOne(uid);
		programme.setActiveState(ActiveState.ACTIVE);
		repoProgramme.save(programme);
	}
	
}
