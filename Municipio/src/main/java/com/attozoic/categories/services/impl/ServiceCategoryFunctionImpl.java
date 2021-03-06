package com.attozoic.categories.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.dao.DaoCategoryFunction;
import com.attozoic.categories.services.ServiceCategoryFunction;

@Service
public class ServiceCategoryFunctionImpl extends ServiceCategoryEntityImpl implements ServiceCategoryFunction {

	@Autowired
	private DaoCategoryFunction daoCategoryFunction;

	@Override
	public DaoCategoryEntity getDaoCategoryEntity() {
		return daoCategoryFunction;
	}

	@Override
	public Map<String, String> getOneDigits() {
		return ((DaoCategoryFunction)getDaoCategoryEntity()).getOneDigits();
	}

}
