package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.DtoActivityProject;
import com.attozoic.main.model.DtoProgrammeFinancialSource;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceActivity;

@RestController
@RequestMapping("/activities")
public class ControllerActivity {

	@Autowired
	private ServiceActivity serviceActivity;
	
	//getActivityFinanceDto{uid}
	@RequestMapping(value="/{uid}/dtoFinance", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DtoProgrammeFinancialSource getActivityFinanceDto(@PathVariable(value="uid") Long uid) {
		return serviceActivity.buildActivityFinanceDto(uid);
	}
	
	//getActivityDto{uid}
	@RequestMapping(value="/{uid}/dto", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DtoActivityProject getActivityDto(@PathVariable(value="uid") Long uid) {
		return serviceActivity.buildActivityDto(uid);
	}
	
	//getAllActivities
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllActivities() {
		return serviceActivity.findAll();
	}
	
	//getActivity{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getActivity(@PathVariable(value="uid") Long uid) {
		return serviceActivity.findOne(uid);
	}
	
	//getActiveActivities
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveActivities() {
		return serviceActivity.findActive();
	}
	
	//getArchivedActivities
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedActivities() {
		return serviceActivity.findArchived();
	}
	
//	//saveActivity
//	@RequestMapping(method = RequestMethod.POST)
//	public SuperEntity save(@RequestBody Activity activity) {
//		return serviceActivity.save(activity);
//	}
	
	//updateActivity
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Activity update(@RequestBody Activity activity) {
		return (Activity) serviceActivity.update(activity);
	}
	
	//deleteActivity{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceActivity.delete(uid);
	}
	
	//archiveActivity{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceActivity.archive(uid);
	}
	
	//unarchiveActivity{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceActivity.unarchive(uid);
	}
	
	//addActivityGoal to Activity{uid}
	@RequestMapping(value="/{uid}/activityGoals", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ActivityGoal addActivityGoal(@PathVariable(value="uid") Long uid, @RequestBody ActivityGoal activityGoal) {
		return serviceActivity.addActivityGoal(uid, activityGoal);
	}
	
	//addActivityFinancialSource to Activity{uid}
	@RequestMapping(value="/{uid}/activityFinancialSources", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ActivityFinancialSource addActivityFinancialSource(@PathVariable(value="uid") Long uid, @RequestBody ActivityFinancialSource activityFinancialSource) {
		return serviceActivity.addActivityFinancialSource(uid, activityFinancialSource);
	}
	
	//addActivityEconomicAccount to Activity{uid}
	@RequestMapping(value="/{uid}/activityEconomicAccounts", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ActivityEconomicAccount addActivityEconomicAccount(@PathVariable(value="uid") Long uid, @RequestBody ActivityEconomicAccount activityEconomicAccount) {
		return serviceActivity.addActivityEconomicAccount(uid, activityEconomicAccount);
	}

}
