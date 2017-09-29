package com.mass.test;

public class Variable {
	private String ID;
	private String name = null;
	private double miniBudget;
	private double maxBudget;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public double getMaxBudget() {
		return maxBudget;
	}
	public void setMaxBudget(double maxBudget) {
		this.maxBudget = maxBudget;
	}
	public double getMiniBudget() {
		return miniBudget;
	}
	public void setMiniBudget(double miniBudget) {
		this.miniBudget = miniBudget;
	}
	
}
