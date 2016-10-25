package com.attozoic.main.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activity_goal_indicators")
@Data
@EqualsAndHashCode(callSuper=true)
public class ActivityGoalIndicator extends SuperEntity {

	private String name;
	
    @ManyToOne
	@JoinColumn(name="activityGoal_uid")
	@JsonBackReference
    private ActivityGoal activityGoal;
    
	private long valueBase; // 2016
	private long targetValuePlus1; // 2017
	private long targetValuePlus2; // 2018
	private long targetValuePlus3; // 2019
	private long verificationSource;

	public ActivityGoalIndicator() {}

	public ActivityGoalIndicator(String name, long valueBase, long targetValuePlus1, long targetValuePlus2,
			long targetValuePlus3, long verificationSource) {
		super();
		this.name = name;
		this.valueBase = valueBase;
		this.targetValuePlus1 = targetValuePlus1;
		this.targetValuePlus2 = targetValuePlus2;
		this.targetValuePlus3 = targetValuePlus3;
		this.verificationSource = verificationSource;
	}
	
}
