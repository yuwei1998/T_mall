package com.form;

public class Property {
    private Integer id;

    private String name;

    private Integer category_id;

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

	@Override
	public String toString() {
		return "Property [id=" + id + ", name=" + name + ", category_id=" + category_id + "]";
	}
    
}