package com.assingment.assingment.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="assets")
public class Assets {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique=true)
	private String name;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "cat_id"), name = "cat_id")
	private Category category;
	
	@Column(name="assigned")
	private String assigned;
	
	@Column(name="recoverd")
	private String recoverd;
	
	@Column(name="avalable")
	private String avalable;
	
	public Assets() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Assets(int id, String name, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}
	public String getRecoverd() {
		return recoverd;
	}

	public void setRecoverd(String recoverd) {
		this.recoverd = recoverd;
	}

	public String getAvalable() {
		return avalable;
	}

	public void setAvalable(String avalable) {
		this.avalable = avalable;
	}

	@Override
	public String toString() {
		return "Assets [id=" + id + ", name=" + name + ", category=" + category + ", assigned=" + assigned
				+ ", recoverd=" + recoverd + ", avalable=" + avalable + "]";
	}
	
	

}
