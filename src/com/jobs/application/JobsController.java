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
	
	//Afegit sou mínim Boss.
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		try {
			if(salaryPerMonth<8000) throw new Exception();
			repository.addMember(boss);
		} catch (Exception e) {
			System.out.println("Error al introducir el salario de " + name + ".\nEl salairo debe ser superior a 8000 €\n");
		}
			
	}
	
	//Afegit subclase Senior i forquilla de sou.
	public void createEmployeeSenior(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployeeJunior());
		try {
			if(salaryPerMonth>4000 || salaryPerMonth<2700) throw new Exception();
			repository.addMember(employee);
		} catch (Exception e) {
			System.out.println("Error al introducir el salario de " + name + ".\nEl salairo debe estrar entre 2700 y 4000 €\n");
		}
	}
	
	//Afegit subclase Mid i forquilla de sou.
	public void createEmployeeMid(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployeeJunior());
		try {
			if(salaryPerMonth>2500 || salaryPerMonth<1800) throw new Exception();
			repository.addMember(employee);
		} catch (Exception e) {
			System.out.println("Error al introducir el salario de " + name + ".\nEl salairo debe estrar entre 1800 y 2500 €\n");
		}
	}

	//Afegit subclase Junior i forquilla de sou.
	public void createEmployeeJunior(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployeeJunior());
		try {
			if(salaryPerMonth>1600 || salaryPerMonth<900) throw new Exception();
			repository.addMember(employee);
		} catch (Exception e) {
			System.out.println("Error al introducir el salario de " + name + ".\nEl salairo debe estrar entre 900 y 1600 €\n");
		}
	}
	
	//Afegit subclase Manager i forquilla de sou.
	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		try {
			if(salaryPerMonth>5000 || salaryPerMonth<3000) throw new Exception();
			repository.addMember(manager);
		} catch (Exception e) {
			System.out.println("Error al introducir el salario de " + name + ".\nEl salairo debe estrar entre 3000 y 5000 €\n");
		}
		
	}

	public String payAllEmployees() {
		
		String payAllEmployees="";
		double totalPay=0;
		
		for (AbsStaffMember m:repository.getAllMembers()) {
			payAllEmployees = payAllEmployees + m.pay() + " € paid to " + m.getName() + "\n";
			totalPay=totalPay+m.pay();
		}
			payAllEmployees = payAllEmployees + "\nTotal paid: " + totalPay + " €" + "\n";
		return payAllEmployees;
	}
		
	public String getAllEmployees() {
		
		String infoAllEmployees="";
		
		for (AbsStaffMember m:repository.getAllMembers()) {
			infoAllEmployees=infoAllEmployees + m.getInfo() + "\n";
		}		
		return infoAllEmployees;
	}

	public void createVolunteer(String name, String address, String phone) throws Exception{
		Volunteer vol = new Volunteer(name, address, phone);
		repository.addMember(vol);
		
	}	
	
}
