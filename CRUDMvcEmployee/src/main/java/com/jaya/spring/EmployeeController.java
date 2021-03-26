package com.jaya.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jaya.spring.model.Employee;
import com.jaya.spring.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired(required=true)
	@Qualifier(value="employeeService")
	public void setEmployeeService(EmployeeService es){
		this.employeeService = es;
	}
	
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String index(Model model) {
	     return "redirect:/employees";
	    }

	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployees", this.employeeService.listEmployees());
		return "employee";
	}
	
	//For add and update person both
	@RequestMapping(value= "/employee/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee e){
		
		if(e.getEmpid() == 0){
			//new person, add it
			this.employeeService.addEmployee(e);
		}else{
			//existing person, call update
			this.employeeService.updateEmployee(e);
		}
		
		return "redirect:/employees";
		
	}
	
	@RequestMapping("/remove/{empid}")
    public String removePerson(@PathVariable("empid") int empid){
		
        this.employeeService.removeEmployee(empid);
        return "redirect:/employees";
    }
 
    @RequestMapping("/edit/{empid}")
    public String editEmployee(@PathVariable("empid") int empid, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(empid));
        model.addAttribute("listEmployees", this.employeeService.listEmployees());
        return "employee";
    }
	
}