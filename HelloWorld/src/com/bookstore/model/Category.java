/**
 * 
 */
package com.bookstore.model;
/**
 * @author Phuc
 *
 */
public class Category {
	private long id;
	private String categoryDescription;
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public String getCategory() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDesc)
	{
		this.categoryDescription = categoryDesc;
	}
	public String toString()
	{
		return "Category Id - " + id + " Category Description - " + categoryDescription;
	}
}
