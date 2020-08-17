package com.briup.estore.bean;

import java.util.List;
/**
 * 分类
 * 一对多
 */
public class Category {
	private Integer id;
	private String name;
	private String description;
	//一级分类底下的所有二级分类
	private List<Category> categories;
	
	public Category() {
		
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", categories=" + categories
				+ "]";
	}

}
