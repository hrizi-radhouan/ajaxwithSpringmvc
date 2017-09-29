package com.mass.test;

import java.util.ArrayList;

import java.util.List;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class VariablesListModel {

	private static final Logger logger = Logger.getLogger(VariablesListModel.class);
	private List<Variable> listVaraibles;
	private List<Variable> listSelectedVaraibles;
	private int numberSelectedVariables;

	public VariablesListModel() {

	}

	public List<Variable> getListVaraibles() {
		return listVaraibles;
	}

	public void setListVaraibles(List<Variable> listVaraibles) {
		this.listVaraibles = listVaraibles;
	}

	public int getNumberSelectedVariables() {
		return numberSelectedVariables;
	}

	public void setNumberSelectedVariables(int numberSelectedVariables) {
		this.numberSelectedVariables = numberSelectedVariables;
	}

	public void initialize() {
		listVaraibles = new ArrayList<Variable>();
		listSelectedVaraibles = new ArrayList<Variable>();
		Variable var = new Variable();
		var.setID("name123");
		var.setName("Youtube spend 2016");
		var.setMiniBudget(1000);
		var.setMaxBudget(50000);
		listVaraibles.add(var);
		Variable var2 = new Variable();
		var2.setID("name124");
		var2.setName("Facebook spend 2016");
		var2.setMiniBudget(2000);
		var2.setMaxBudget(60000);
		listVaraibles.add(var2);
		Variable var3 = new Variable();
		var3.setID("name129");
		var3.setName("NatGeo spend 2015");
		var3.setMiniBudget(1500);
		var3.setMaxBudget(40000);
		listVaraibles.add(var3);
		Variable var4 = new Variable();
		var4.setID("name127");
		var4.setName("Fr2 spend 2017");
		var4.setMiniBudget(1500);
		var4.setMaxBudget(40000);
		listVaraibles.add(var4);
		
	}

	public boolean addSelectedVariable(Variable variable) {
		boolean res=false;
		
		if(this.listSelectedVaraibles.add(variable)) {
			
			incre();
			res=true;
		}
		
		return res;
	}
	
	public boolean removeSelectedVariable(Variable variable) {
		int count=0;
		boolean test =true;
			while(test && count <listSelectedVaraibles.size()) {
			 if(!(variable.getID().equals(listSelectedVaraibles.get(count).getID()))) {
				 count++;
			 }else {
				 test=false;
				 
				 listSelectedVaraibles.remove(count);
				 System.out.println(" Delete done"+listSelectedVaraibles.toString());
				 decre();
				 
			 }
			}
			
			
		return !test;
	}

	public String getListVaraiblesSelectedJSON() {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = "";
		try {
			json = ow.writeValueAsString(listSelectedVaraibles);
			
		} catch (JsonProcessingException e) {
			logger.error("Internal Error " + e.getMessage());
		}
		
		String res="";
		for(Variable item : listSelectedVaraibles) {
			res=res+item.getID()+":"+item.getName()+":"+item.getMiniBudget()+":"+item.getMaxBudget()+";";
		}
		
		res=res.substring(0, res.length()-1);
		return res;
	}
	
	public void incre() {
		this.numberSelectedVariables++;
	}
	public void decre() {
		this.numberSelectedVariables--;
	}

}
