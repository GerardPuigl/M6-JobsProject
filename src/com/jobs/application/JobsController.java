package com.jobs.application;

import java.util.ArrayList;
import java.util.Map;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController(){
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee Employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(Employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(boss);
		
	}


	public void payAllEmployeers() {
		// TODO Auto-generated method stub
	
	}

	public String getAllEmployees() {
		
		ArrayList<String> nameEmployees=new ArrayList();
		
		for (AbsStaffMember name:repository.getAllMembers()) {
			nameEmployees.add(name.getName());
		}
		
		return nameEmployees.toString();
	}

	public void createVolunteer(String name, String address, String phone) throws Exception{
		Volunteer vol = new Volunteer(name, address, phone);
		repository.addMember(vol);
		
	}
	
	
	
}
