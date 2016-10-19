package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.repositories.RepositoryProgrameGoalIndicator;

@Repository
public class DaoProgrammeGoalIndicator {

	@Autowired
	private RepositoryProgrameGoalIndicator repoProgrammeGoalIndicator;
	
	public Page<ProgrammeGoalIndicator> findAll() {
		Page<ProgrammeGoalIndicator> page = new PageImpl<>(repoProgrammeGoalIndicator.findAll());
		return page;
	}
	
	public ProgrammeGoalIndicator save(ProgrammeGoalIndicator programmeGoalIndicator) {
		return repoProgrammeGoalIndicator.save(programmeGoalIndicator);
	}

}