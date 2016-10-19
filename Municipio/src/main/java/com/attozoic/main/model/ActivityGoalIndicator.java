package com.attozoic.main.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.attozoic.categories.model.CategoryActivityGoalIndicator;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Table(name="activity_goal_indicators")
@Data
public class ActivityGoalIndicator {

	@Id
	@GeneratedValue
	private Long uid;
	
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    // @JoinColumn(name="USER_ID", nullable=false)
    @PrimaryKeyJoinColumn
	private CategoryActivityGoalIndicator categoryActivityGoalIndicator;
	
    @ManyToOne
	@JoinColumn(name="activityGoal_uid")
	@JsonBackReference
    private ActivityGoal activityGoal;
    
	private long valueBase; // 2016
	private long targetValuePlus1; // 2017
	private long targetValuePlus1Rebalance1;
	private long targetValuePlus1Rebalance2;
	private long targetValuePlus1Rebalance3;
	private long targetValuePlus1Rebalance4;
	private long targetValuePlus2; // 2018
	private long targetValuePlus3; // 2019
	private long verificationSource;

	@CreationTimestamp
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Column(name = "update_date")
	private Date updateDate;
	
	public ActivityGoalIndicator() {}

	public ActivityGoalIndicator(CategoryActivityGoalIndicator categoryActivityGoalIndicator, long valueBase,
			long targetValuePlus1, long targetValuePlus1Rebalance1, long targetValuePlus1Rebalance2,
			long targetValuePlus1Rebalance3, long targetValuePlus1Rebalance4, long targetValuePlus2,
			long targetValuePlus3, long verificationSource) {
		this.categoryActivityGoalIndicator = categoryActivityGoalIndicator;
		this.valueBase = valueBase;
		this.targetValuePlus1 = targetValuePlus1;
		this.targetValuePlus1Rebalance1 = targetValuePlus1Rebalance1;
		this.targetValuePlus1Rebalance2 = targetValuePlus1Rebalance2;
		this.targetValuePlus1Rebalance3 = targetValuePlus1Rebalance3;
		this.targetValuePlus1Rebalance4 = targetValuePlus1Rebalance4;
		this.targetValuePlus2 = targetValuePlus2;
		this.targetValuePlus3 = targetValuePlus3;
		this.verificationSource = verificationSource;
	}
	
}