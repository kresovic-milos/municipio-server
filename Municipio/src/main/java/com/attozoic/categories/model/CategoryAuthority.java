package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "category_authority")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryAuthority extends CategorySuperEntity {

	private String code;
	private String jbbk;
	private String name;
	private String authority;
	
	public CategoryAuthority() {}
	
}
