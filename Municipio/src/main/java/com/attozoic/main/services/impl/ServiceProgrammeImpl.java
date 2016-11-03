package com.attozoic.main.services.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoDtoActivityProject;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProgramme;
import com.attozoic.main.model.Activity;
import com.attozoic.main.model.DtoActivityProject;
import com.attozoic.main.model.ProgrammeFinancialSource;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;
import com.attozoic.main.services.ServiceProgramme;

@Service
public class ServiceProgrammeImpl extends ServiceEntityImpl implements ServiceProgramme {

	@Autowired
	private DaoProgramme dao;
	
	@Autowired
	private DaoDtoActivityProject daoDto;
	
	@Override
	public DaoEntity getDaoEntity() {
		return dao;
	}
	
	public DaoDtoActivityProject getDaoDto() {
		return daoDto;
	}

	@Override	
	public ProgrammeGoal addProgrammeGoal(Long uid, ProgrammeGoal programmeGoal) {
		return ((DaoProgramme) getDaoEntity()).addProgrammeGoal(uid, programmeGoal);
	}	

	@Override
	public Activity addActivity(Long uid, Activity activity) {
		return ((DaoProgramme) getDaoEntity()).addActivity(uid, activity);
	}
	
	@Override
	public Project addProject(Long uid, Project project) {
		return ((DaoProgramme) getDaoEntity()).addProject(uid, project);
	}

	@Override
	public ProgrammeFinancialSource addProgrammeFinancialSource(Long uid, ProgrammeFinancialSource programmeFinancialSource) {
		return ((DaoProgramme) getDaoEntity()).addProgrammeFinancialSource(uid, programmeFinancialSource);
	}

	@Override
	public HashMap<String, DtoActivityProject> getProgrammeDTOs(Long uid) {
		return getDaoDto().getProgrammeDTOs(uid);
	}

	
	
//	@Override
//	public ProgrammeFinancialSource addProgrammeFinancialSource(Long uid,
//			ProgrammeFinancialSource programmeFinancialSource) {
//		return ((DaoProgramme) getDaoEntity()).addProgrammeFinancialSource(uid, programmeFinancialSource);
//	}
}
