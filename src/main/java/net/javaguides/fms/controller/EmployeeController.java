package net.javaguides.fms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.fms.VM.CustomerVM;
import net.javaguides.fms.VM.EmployeesVM;
import net.javaguides.fms.model.Customer;
import net.javaguides.fms.model.Employees;
import net.javaguides.fms.services.Employeesservice;

@Controller
@CrossOrigin("*")
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private Employeesservice employeesService;

	@GetMapping("/employees")
	public ResponseEntity<List<EmployeesVM>> getEmployees() {
		
		List<Employees> employeesList = employeesService.findAll();
		
		List<EmployeesVM> employeesListVMs = new ArrayList<EmployeesVM>();
		employeesList.stream().forEach(employees ->{
			
			EmployeesVM employeesVM = new EmployeesVM();
			
			employeesVM.setEmployeeName(employees.getEmployeeName());
			employeesVM.setAddress(employees.getAddress());
			employeesVM.setJoiningDate(employees.getJoiningDate());
			employeesVM.setPrimaryContact(employees.getPrimaryContact());
			employeesVM.setSecondaryContact(employees.getSecondaryContact());
			employeesVM.setEmployeeSalaryType(employees.getEmployeeSalaryType());
			employeesVM.setId(employees.getId());
			
			
			employeesListVMs.add(employeesVM);
		});
		return ResponseEntity.ok().body(employeesListVMs);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employees> saveEmployees(@RequestBody EmployeesVM employeesVM) {
		
		Employees employees = new Employees();
		if(employeesVM.getId()!= null&&employeesVM.getId()!=0) {
			employees.setId(employeesVM.getId());
		}
		
		employees.setEmployeeName(employeesVM.getEmployeeName());
		employees.setAddress(employeesVM.getAddress());
		employees.setPrimaryContact(employeesVM.getPrimaryContact());
		employees.setSecondaryContact(employeesVM.getSecondaryContact());
		employees.setEmployeeSalaryType(employeesVM.getEmployeeSalaryType());
		employees.setJoiningDate(employeesVM.getJoiningDate());
		employees.setDeleted(false);
		
		
		
		
		Employees result = employeesService.saveEmployees(employees);
		
		
		
		
		
    return  ResponseEntity.ok().body(result);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employees> searchEmployees(@PathVariable Long id){
		
		Optional<Employees> employeesview= employeesService.findById(id);
		

		if(employeesview.isPresent()) {
			return ResponseEntity.ok().body(employeesview.get());
		}
		
		return null;
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employees> deleteEmployees(@PathVariable Long id){
		
		Optional<Employees> employeesdelete= employeesService.findById(id);
		
		if(employeesdelete.isPresent()) {
			Employees employees= employeesdelete.get(); 
			employees.setDeleted(true);
			
			Employees result = employeesService.saveEmployees(employees);
		}
		
		
		return null;
	}
	

}
