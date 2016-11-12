package com.attozoic.main.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class DtoProgrammeExpencesItem {
// Activity || Project ExpencesDto
	
	private String type;
	private String categoryName;
	private String name;

	// 2016
	private double expenseBaseYearBudget;
	private double expenseBaseYearOthers;
	
	// 2017
	private double expenseBaseYearPlus1Budget1;
	private double expenseBaseYearPlus1Budget2;
	private double expenseBaseYearPlus1Budget3;
	private double expenseBaseYearPlus1Budget4;
	
	private double sumExpensesBaseYearPlus1Budget;
	
	private double expenseBaseYearPlus1Others1;
	private double expenseBaseYearPlus1Others2;
	private double expenseBaseYearPlus1Others3;
	private double expenseBaseYearPlus1Others4;
	
	private double sumExpensesBaseYearPlus1Others;
	
	// 2018
	private double expenseBaseYearPlus2Budget;
	private double expenseBaseYearPlus2Others;
	// 2019
	private double expenseBaseYearPlus3Budget;
	private double expenseBaseYearPlus3Others;
	
	// Sum od Plus1 do Plus3
	private double sumExpenses123Budget;
	private double sumExpenses123Others;
	
	private List<DtoRebalanceTwoFields> dtoRebalanceTwoFieldsList = new ArrayList<>();
	
	public DtoProgrammeExpencesItem() {}
	
	// List<DtoRebalanceTwoFields> + List<DtoRebalanceTwoFields>
	public List<DtoRebalanceTwoFields> sumDtoRebalancesTwoFieldsLists(List<DtoRebalanceTwoFields> l) {
		List<DtoRebalanceTwoFields> list = new ArrayList<>();
		if(l.isEmpty()) {
			return this.dtoRebalanceTwoFieldsList;
		}
		for (int i = 0; i < l.size(); i++) {
			if (this.dtoRebalanceTwoFieldsList.isEmpty()) {
				list = l;
			} else {
				this.dtoRebalanceTwoFieldsList.get(i).sum(l.get(i));
				list.add(this.dtoRebalanceTwoFieldsList.get(i));
			}
		}
		return list;
	}
	
	// DtoProgrammeExpencesItem + DtoProgrammeExpencesItem
	public void sumDtoProgrammeExpencesItems(DtoProgrammeExpencesItem dto) {
		this.setExpenseBaseYearBudget(this.getExpenseBaseYearBudget() + dto.getExpenseBaseYearBudget());
		this.setExpenseBaseYearOthers(this.getExpenseBaseYearOthers() + dto.getExpenseBaseYearOthers());
		this.setExpenseBaseYearPlus1Budget1(this.getExpenseBaseYearPlus1Budget1() + dto.getExpenseBaseYearPlus1Budget1());
		this.setExpenseBaseYearPlus1Budget2(this.getExpenseBaseYearPlus1Budget2() + dto.getExpenseBaseYearPlus1Budget2());
		this.setExpenseBaseYearPlus1Budget3(this.getExpenseBaseYearPlus1Budget3() + dto.getExpenseBaseYearPlus1Budget3());
		this.setExpenseBaseYearPlus1Budget4(this.getExpenseBaseYearPlus1Budget4() + dto.getExpenseBaseYearPlus1Budget4());
		this.setExpenseBaseYearPlus1Others1(this.getExpenseBaseYearPlus1Others1() + dto.getExpenseBaseYearPlus1Others1());
		this.setExpenseBaseYearPlus1Others2(this.getExpenseBaseYearPlus1Others2() + dto.getExpenseBaseYearPlus1Others2());
		this.setExpenseBaseYearPlus1Others3(this.getExpenseBaseYearPlus1Others3() + dto.getExpenseBaseYearPlus1Others3());
		this.setExpenseBaseYearPlus1Others4(this.getExpenseBaseYearPlus1Others4() + dto.getExpenseBaseYearPlus1Others4());
		this.setExpenseBaseYearPlus2Budget(this.getExpenseBaseYearPlus2Budget() + dto.getExpenseBaseYearPlus2Budget());
		this.setExpenseBaseYearPlus2Others(this.getExpenseBaseYearPlus2Others() + dto.getExpenseBaseYearPlus2Others());
		this.setExpenseBaseYearPlus3Budget(this.getExpenseBaseYearPlus3Budget() + dto.getExpenseBaseYearPlus3Others());
		this.setExpenseBaseYearPlus3Others(this.getExpenseBaseYearPlus3Others() + dto.getExpenseBaseYearPlus3Others());
		this.setSumExpenses123Budget(this.getSumExpenses123Budget() + dto.getSumExpenses123Budget());
		this.setSumExpenses123Others(this.getSumExpenses123Others() + dto.getSumExpenses123Others());
		this.setSumExpensesBaseYearPlus1Budget(this.getSumExpensesBaseYearPlus1Budget() + dto.getSumExpensesBaseYearPlus1Budget());
		this.setSumExpensesBaseYearPlus1Others(this.getSumExpensesBaseYearPlus1Others() + dto.getSumExpensesBaseYearPlus1Others());
		this.setDtoRebalanceTwoFieldsList(this.sumDtoRebalancesTwoFieldsLists(dto.getDtoRebalanceTwoFieldsList()));
	}
	
}