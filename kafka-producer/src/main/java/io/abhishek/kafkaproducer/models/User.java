package io.abhishek.kafkaproducer.models;

public class User {
	
	private String name;
	private String dept;
	private double pointer;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String dept, double pointer) {
		super();
		this.name = name;
		this.dept = dept;
		this.pointer = pointer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public double getPointer() {
		return pointer;
	}
	public void setPointer(double pointer) {
		this.pointer = pointer;
	}
	
	

}
