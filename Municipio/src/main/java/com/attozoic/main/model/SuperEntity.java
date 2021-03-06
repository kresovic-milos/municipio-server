package com.attozoic.main.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@EqualsAndHashCode(of="uid")
@Data
public abstract class SuperEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected Long uid;
	
	@Enumerated(EnumType.ORDINAL)
	private ActiveState activeState = ActiveState.ACTIVE;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "create_date")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "update_date")
	private Date updateDate;
	
}
