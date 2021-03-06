package com.attozoic.main.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.dao.DaoProject;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.dto.DtoEconomicAccountTwoObjects;
import com.attozoic.main.model.dto.DtoProjectEconomicAccount;
import com.attozoic.main.services.ServiceProject;
import com.attozoic.main.services.ServiceThreeDigitEconomicAccount;

@RestController
@RequestMapping("/projects")
public class ControllerProject {

	@Autowired
	private ServiceProject serviceProject;
	
	@Autowired
	private ServiceThreeDigitEconomicAccount serviceThreeDigitEconomicAccount;
	
	@Autowired
	public DaoProject daoProject;
	
	//getProjectsByAuthority{authorityCode}
	@RequestMapping(value="/{autorityCode}/r", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Project> getProjectsByAuthority(@PathVariable(value="autorityCode") String autorityCode) {
		return serviceProject.getProjectsByAuthority(autorityCode);
	}
	
	//getProjectEconomicAccounts{uid}
	@RequestMapping(value="/updateAll", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateAll() {
		serviceProject.updateAll();
	}
	
	//getProjectEconomicAccounts{uid}
	@RequestMapping(value="/{uid}/economicAccounts", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<SuperEconomicAccount> getProjectEconomicAccounts(@PathVariable(value="uid") Long uid) {
		return serviceProject.getProjectExpences(uid);
	}
	
	//getProjectGoals{uid}
	@RequestMapping(value="/{uid}/goals", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<ProjectGoal> getProjectGoals(@PathVariable(value="uid") Long uid) {
		return serviceProject.getProjectGoals(uid);
	}
	
	//getProjectFinancialSourceFooter{uid}
	@RequestMapping(value="/{uid}/financesFooter", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Double> getProjectFinancialSourceFooter(@PathVariable(value="uid") Long uid) {
		return serviceProject.getProjectExpencesFooter(uid);
	}
	
	//getProjectFinancialSourceMap{uid}
	@RequestMapping(value="/{uid}/finances", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, double[]> getProjectFinancialSourceMap(@PathVariable(value="uid") Long uid) {
		return serviceProject.getProjectFinancialSourceMap(uid);
	}
	
	//getProjectEconomicAccountFooter{uid}
	@RequestMapping(value="/{uid}/expencesFooter", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Double> getProjectEconomicAccountFooter(@PathVariable(value="uid") Long uid) {
		return serviceProject.getProjectExpencesFooter(uid);
	}
	
	//getProjectEconomicAccountsList{uid}
	@RequestMapping(value="/{uid}/expences", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<DtoProjectEconomicAccount> getProjectEconomicAccountsList(@PathVariable(value="uid") Long uid) {
		return serviceProject.getProjectExpencesList(uid);
	}
	
	//addProjectGoal to Project{uid}
	@RequestMapping(value="/{uid}/projectGoals", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectGoal addProjectGoal(@PathVariable(value="uid") Long uid, @RequestBody ProjectGoal goal) {
		return serviceProject.addProjectGoal(uid, goal);
	}
	
	//addProjectEconomicAccount to Project{uid}
	@RequestMapping(value="/{uid}/projectEconomicAccounts", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectEconomicAccount addProjectEconomicAccount(@PathVariable(value="uid") Long uid, @RequestBody DtoEconomicAccountTwoObjects dto) {
		if (!(dto.getThreeDigitEconomicAccount()==null)) {
			serviceThreeDigitEconomicAccount.save(dto.getThreeDigitEconomicAccount());
		}
		ProjectEconomicAccount projectEconomicAccount = (ProjectEconomicAccount)dto.getSuperEconomicAccount();
		return serviceProject.addProjectEconomicAccount(uid, projectEconomicAccount);
	}
	
	//getAllProjects
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getAllProjects() {
		return serviceProject.findAll();
	}
	
	//getProject{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Project getProject(@PathVariable(value="uid") Long uid) {
		return (Project) serviceProject.findOne(uid);
	}
	
	//getActiveProjects
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveProjects() {
		return serviceProject.findActive();
	}
	
	//getArchivedProjects
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedProjects() {
		return serviceProject.findArchived();
	}
	
//	//saveProject
//	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public Project save(@RequestBody Project project) {
//		return (Project) serviceProject.save(project);
//	}
	
	//updateProject
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Project update(@RequestBody Project project) {
		return (Project) serviceProject.update(project);
	}
	
	//deleteProject{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceProject.delete(uid);
	}
	
	//archiveProject{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceProject.archive(uid);
	}
	
	//unarchiveProject{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceProject.unarchive(uid);
	}
	
	////////////////matrix //////////////
	
	@RequestMapping(value="/{uid}/expencesGroups", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
		public List<ProjectEconomicAccount> getExpencesGroups(@PathVariable(value="uid") Long uid) {
		return daoProject.getProjectExpencesGroups(uid);
	}
	
}
