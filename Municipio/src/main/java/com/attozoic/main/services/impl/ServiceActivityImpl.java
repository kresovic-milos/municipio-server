package com.attozoic.main.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivity;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.dto.DtoActivityEconomicAccount;
import com.attozoic.main.services.ServiceActivity;

@Service
public class ServiceActivityImpl extends ServiceEntityImpl implements ServiceActivity {

	@Autowired
	private DaoActivity daoActivity;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoActivity;
	}
	
	@Override
	public List<Activity> getActivitiesByAuthority(String authorityCode) {
		return ((DaoActivity) getDaoEntity()).getActivitiesByAuthority(authorityCode);
	}
	
//	@Override
//	public DtoFinanceFooter getActivityFinancialSourceFooter(Long uid) {
//		return ((DaoActivity) getDaoEntity()).getActivityFinancialSourceFooter(uid);
//	}
	
	@Override
	public List<SuperEconomicAccount> getActivityExpences(Long uid) {
		return ((DaoActivity) getDaoEntity()).getActivityExpences(uid);
	}
	
//	@Override
//	public List<ActivityFinancialSource> getActivityFinances(Long uid) {
//		return ((DaoActivity) getDaoEntity()).getActivityFinances(uid);
//	}
	
	@Override
	public Map<String, double[]> getActivityFinancialSourceMap(Long uid) {
		return ((DaoActivity) getDaoEntity()).getActivityFinancialSourceMap(uid);
	}
	
	@Override
	public List<Double> getActivityExpencesFooter(Long uid) {
		return ((DaoActivity) getDaoEntity()).getActivityExpencesFooter(uid);
	}
	
//	@Override
//	public SuperEconomicAccount getActivityEconomicAccountFooter(Long uid) {
//		return ((DaoActivity) getDaoEntity()).getActivityEconomicAccountFooter(uid);
//	}

	@Override
	public List<DtoActivityEconomicAccount> getActivityExpencesList(Long uid) {
		return ((DaoActivity) getDaoEntity()).getActivityExpencesList(uid);
	}
	
	@Override
	public ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal) {
		return ((DaoActivity) getDaoEntity()).addActivityGoal(uid, activityGoal);
	}

	@Override
	public ActivityEconomicAccount addActivityEconomicAccount(Long uid, ActivityEconomicAccount activityEconomicAccount) {
		return ((DaoActivity) getDaoEntity()).addActivityEconomicAccount(uid, activityEconomicAccount);
	}

	@Override
	public List<ActivityGoal> getActivityGoals(Long uid) {
		return ((DaoActivity) getDaoEntity()).getActivityGoals(uid);
	}

//	@Override
//	public List<Object> getActivityFinancesB(Long uid) {
//		return ((DaoActivity) getDaoEntity()).getActivityFinancesB(uid);
//	}
//
//	@Override
//	public List<Object> getActivityFinancesO(Long uid) {
//		return ((DaoActivity) getDaoEntity()).getActivityFinancesO(uid);
//	}

	@Override
	public List<Object> getActivityFinancial(Long uid) {
		return ((DaoActivity) getDaoEntity()).getActivityFinancial(uid);
	}

	@Override
	public List<Object> getActivityFinancesTest(Long activityUid) {
		return ((DaoActivity) getDaoEntity()).getActivityFinancesTest(activityUid);
	}
	
}
