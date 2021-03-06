package com.attozoic.categories.controllers;

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

import com.attozoic.categories.model.CategoryFunction;
import com.attozoic.categories.model.CategorySuperEntity;
import com.attozoic.categories.services.ServiceCategoryFunction;

@RestController
@RequestMapping("/categoryFunctions")
public class ControllerCategoryFunction {

	@Autowired
	ServiceCategoryFunction serviceFunction;
	
	@RequestMapping(value="/addAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAllFunctionCategories(@RequestBody List<CategoryFunction> categoryFunctions) {
		for (CategoryFunction categoryFunction : categoryFunctions) {
			serviceFunction.save(categoryFunction);
		}
	}
	
	@RequestMapping(value="/oneDigit", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> getOneDigits() {
		return serviceFunction.getOneDigits();
	}
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getAllFunctions() {
		return serviceFunction.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategorySuperEntity getCategoryFunction(@PathVariable(value="uid") Long uid) {
		return serviceFunction.findOne(uid);
	}

	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getActiveFunctions() {
		return serviceFunction.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getArchivedFunctions() {
		return serviceFunction.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryFunction addCategoryFunction(@RequestBody CategoryFunction categoryFunction) {
		return (CategoryFunction) serviceFunction.save(categoryFunction);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryFunction updateCategoryFunction(@RequestBody CategoryFunction categoryFunction) {
		return (CategoryFunction) serviceFunction.save(categoryFunction);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceFunction.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceFunction.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceFunction.unarchive(uid);
	}
	
}
