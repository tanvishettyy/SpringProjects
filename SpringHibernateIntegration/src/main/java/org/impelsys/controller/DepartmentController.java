package org.impelsys.controller;

import java.util.List;

import org.impelsys.model.Department;
import org.impelsys.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


//@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping("/add/{dname}/{hodName}")       //"/add/{dname}/{hodName}"
	public void update(@PathVariable String dname, @PathVariable String hodName, Model model)
	{
		Department dept= new Department();
		dept.setDeptName(dname);
		dept.setHodName(hodName);
		int rowsAdded = departmentService.addDepartment(dept);
		departmentService.getAllDepartments();
		if(rowsAdded>=1)
			System.out.println("Department created");
		
	}
	
	@RequestMapping("/view")
	public String display(Model model)
	{
		List<Department> deptList = departmentService.getAllDepartments();
		model.addAttribute("deptList",deptList);
		return "viewDept";
	}

}
