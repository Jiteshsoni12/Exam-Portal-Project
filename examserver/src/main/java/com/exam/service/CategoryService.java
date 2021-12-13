package com.exam.service;

import java.util.Set;

import com.exam.model.exam.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public Set<Category> getCategoies();
	
	public Category getCategory(Long cid);
	
	public void deleteCategory(Long cid);

}