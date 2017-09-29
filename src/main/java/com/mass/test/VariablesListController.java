package com.mass.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VariablesListController {
    private VariablesListModel variablesListModel;

    @RequestMapping(value="/AddUser.htm",method=RequestMethod.GET)
    
    public String showForm(){
    	//add("variablesListModel",variablesListModel);
        return "AddUser";
    }
    
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String showHome(Model model){
    	variablesListModel = new VariablesListModel();
    	variablesListModel.initialize();
    	model.addAttribute("variablesListModel", variablesListModel);
        return "AddUser";
    }
    
    @RequestMapping(value="/AddUser.htm",method=RequestMethod.POST)
    public @ResponseBody String addUser(@ModelAttribute(value="selectedVar") String selectedVar, BindingResult result ){
        String returnText;
        Variable variable = new Variable();
        String[] res;
        res = selectedVar.split(":");
        if(!result.hasErrors()){
        	String id = res[0];
        	variable.setID(id);
        	String name = res[1];
        	variable.setName(name);
        	double miniBudget =Double.parseDouble(res[2]);
        	variable.setMiniBudget(miniBudget);
        	
        	double maxBudget =Double.parseDouble(res[3]);
        	variable.setMaxBudget(maxBudget);        	
        	
            variablesListModel.addSelectedVariable(variable);
            System.out.println(variable);
            System.out.println("selectedVar ="+selectedVar);
            returnText =variablesListModel.getListVaraiblesSelectedJSON();
            System.out.println(" this is our selected variables  :"+returnText);
        }else{
            returnText = "An error has occur.";
        }
        return returnText;
    }
    
    @RequestMapping(value="/DeleUser.htm",method=RequestMethod.POST)
    public @ResponseBody String DeleUser(@ModelAttribute(value="selectedVar") String selectedVar, BindingResult result ){
        String returnText;
        Variable variable = new Variable();
        String[] res;
        res = selectedVar.split(":");
        if(!result.hasErrors()){
        	String id = res[0];
        	variable.setID(id);
        	String name = res[1];
        	variable.setName(name);
        	double miniBudget =Double.parseDouble(res[2]);
        	variable.setMiniBudget(miniBudget);
        	
        	double maxBudget =Double.parseDouble(res[3]);
        	variable.setMaxBudget(maxBudget);        	
        	// remove dn't work ...........
        	 System.out.println(" Number of variables"+variablesListModel.getListVaraibles().size());
        	 variablesListModel.removeSelectedVariable(variable);
        	 
        	 System.out.println(" Number of selected Varaiable"+variablesListModel.getNumberSelectedVariables());
             System.out.println("selectedVar ="+selectedVar);
            
        	 returnText =variablesListModel.getListVaraiblesSelectedJSON();
        	 System.out.println(" this is our selected variables  :"+returnText);
        }else{
            returnText = "An error has occur.";
        }
        return returnText;
    }

//    @RequestMapping(value="/ShowUsers.htm",method=RequestMethod.GET)
//    public String showUsers(ModelMap model){
//        model.addAttribute("Users", userList);
//        return "ShowUsers";
//    }
}
