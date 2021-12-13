package com.exam.serviceImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Category;
import com.exam.repository.CategoryRepo;
import com.exam.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category addCategory(Category category) {
		return this.categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return this.categoryRepo.save(category);
	}

	@Override
	public Set<Category> getCategoies() {
		
		return new LinkedHashSet<>(this.categoryRepo.findAll());
	}

	@Override
	public Category getCategory(Long cid) {
		
		return this.categoryRepo.findById(cid).get();
	}

	@Override
	public void deleteCategory(Long cid) {
		Category cate = new Category();
		cate.setId(cid);
		this.categoryRepo.delete(cate);
		
		
	}

}
