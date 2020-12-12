package com.jobs.application;

import java.util.ArrayList;
import java.util.Map;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repositoryEmployees = new EmployeeRepository();
	private EmployeeRepository repositoryVolunteers = new EmployeeRepository();
	private double bonus =0;
	
	public JobsController(){
		
	}
	
	//Creació Empleats i forquilles de sou
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		try {
			if(salaryPerMonth<8000) throw new Exception();
			repositoryEmployees.addMember(boss);
		} catch (Exception e) {
			System.out.println("Error al introducir el salario de " + name + ".\nEl salairo debe ser superior a 8000 €\n");
		}
	}
	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		try {
			if(salaryPerMonth>5000 || salaryPerMonth<3000) throw new Exception();
			repositoryEmployees.addMember(manager);
		} catch (Exception e) {
			System.out.println("Error al introducir el salario de " + name + ".\nEl salairo debe estrar entre 3000 y 5000 €\n");
		}
	}
	public void createEmployeeSenior(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployeeJunior());
		try {
			if(salaryPerMonth>4000 || salaryPerMonth<2700) throw new Exception();
			repositoryEmployees.addMember(employee);
		} catch (Exception e) {
			System.out.println("Error al introducir el salario de " + name + ".\nEl salairo debe estrar entre 2700 y 4000 €\n");
		}
	}
	public void createEmployeeMid(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployeeJunior());
		try {
			if(salaryPerMonth>2500 || salaryPerMonth<1800) throw new Exception();
			repositoryEmployees.addMember(employee);
		} catch (Exception e) {
			System.out.println("Error al introducir el salario de " + name + ".\nEl salairo debe estrar entre 1800 y 2500 €\n");
		}
	}
	public void createEmployeeJunior(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployeeJunior());
		try {
			if(salaryPerMonth>1600 || salaryPerMonth<900) throw new Exception();
			repositoryEmployees.addMember(employee);
		} catch (Exception e) {
			System.out.println("Error al introducir el salario de " + name + ".\nEl salairo debe estrar entre 900 y 1600 €\n");
		}
	}
	public void createVolunteer(String name, String address, String phone) throws Exception{
		Volunteer vol = new Volunteer(name, address, phone);
		repositoryVolunteers.addMember(vol);
		
	}	
	public String getAllEmployees() {
		
		String infoAllMembers="";
		
		for (AbsStaffMember m:repositoryEmployees.getAllMembers()) {
			infoAllMembers=infoAllMembers + m.getInfo() + "\n";
		}
		for (AbsStaffMember m:repositoryVolunteers.getAllMembers()) {
			infoAllMembers=infoAllMembers + m.getInfo() + "\n";
		}
		return infoAllMembers;
	}
		
	//Llistat pagament de tots els empleats
	public String payAllEmployees() {
		
		String payAllEmployees="";
		
		for (AbsStaffMember m:repositoryEmployees.getAllMembers()) {
			payAllEmployees = payAllEmployees + m.getName()	+ "\n Gross month Salary " + m.payGross() + " €"
															+ "\n Net month Salary " + m.payNet() + " €"
															+ "\n Gross anual Salary " + m.payGross()*12 + " €"
															+ "\n Net anual Salary " + m.payNet()*12 + " €"
															+ "\n Anual bonus of " + bonus + "%: " + m.payGross()*12*(bonus/100) +" €"+ "\n" ;
		}
		return payAllEmployees;
	}

	//Llistat pagament ajuda governamental Voluntaris
	public String payAllVolunteers() {
		
		String payAllVolunteers="";
		
		for (AbsStaffMember m:repositoryVolunteers.getAllMembers()) {
			payAllVolunteers = payAllVolunteers + m.getName()	+ "\n Monthly government aid :" + m.payGross() + " €"
																+ "\n Anual government aid: " + m.payGross()*12 + " € \n" ;
		}
		return payAllVolunteers;
	}
	
	//total a pagar per l'empresa
	public String totalPay() {
		
		String stringTotalPay="";
		double totalPay=0;
		
		for (AbsStaffMember m:repositoryEmployees.getAllMembers()) {
			totalPay=totalPay+m.payGross();
		}
			stringTotalPay = stringTotalPay 	+ "Total to paid each month: " + totalPay + " €" + "\n"
												+ "Total to paid each year + " + bonus + "% bonus: " + (totalPay*12+totalPay*12*(bonus/100)) + " €" + "\n";
		return stringTotalPay;
	}

	//bonus anual empleats

	public void bonus(double bonus) {
		this.bonus=bonus;
	}
	
}
