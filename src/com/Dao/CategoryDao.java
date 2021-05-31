package com.Dao;

import java.util.List;

import com.Model.*;

public interface CategoryDao {
	public Integer addCategory(Category category);
	public List<Category> getCategory();
	public Integer deleteCategory(Integer id);
	public Integer getIdByCategory(String name);
    public Category getCategoryById(int id);
    public Integer updateCategory(Category category);


}
