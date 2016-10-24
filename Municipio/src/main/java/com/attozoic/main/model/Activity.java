package com.attozoic.main.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.attozoic.categories.model.CategoryActivity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activities")
@Data
@EqualsAndHashCode(callSuper=true)
public class Activity extends SuperEntity { 
    
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activity")
	@JsonManagedReference
    private List<ActivityGoal> activityGoals;
	
    @ManyToOne
	@JoinColumn(name="programme_uid")
	@JsonBackReference
    private Programme programme;
	
    @ManyToOne
    @JoinColumn(name="function_id")
    @JsonBackReference(value = "secondParent")
    private Function function;
    
    @ManyToMany
    @JoinTable(
    		name="activity_finance",
    		joinColumns={@JoinColumn(name="activity_id")},
    		inverseJoinColumns={@JoinColumn(name="activityFinancialSource_id")}
    		)
    private List<ActivityFinancialSource> activityFinancialSources;
    
    private String budgetUser;
    private String purpose;
	private String rudiment;
	private String description;
	private String anex;
	private String responsibleAuthority;
	
	private Long sumExpenses;
	private Long sumFinancialSources;
	
	public Activity() {}

	public Activity(String budgetUser, String purpose, String rudiment,
			String description, String anex, String responsibleAuthority, Long sumExpenses, Long sumFinancialSources) {
		super();
		this.budgetUser = budgetUser;
		this.purpose = purpose;
		this.rudiment = rudiment;
		this.description = description;
		this.anex = anex;
		this.responsibleAuthority = responsibleAuthority;
		this.sumExpenses = sumExpenses;
		this.sumFinancialSources = sumFinancialSources;
	}


    
}
