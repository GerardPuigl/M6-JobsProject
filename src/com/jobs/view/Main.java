package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	
	
	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		
		controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 10000);
		controller.createEmployeeSenior("Pedro Senior", "Dirección molona 2", "665266666", 3000.00);
		controller.createEmployeeJunior("Laura Junior", "Dirección molona 3", "625266666", 1500);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666");
		controller.createManagerEmployee("Pedro Employee", "Dirección molona 2", "665226666", 4000);
		
		//Setter Bonus in %
		controller.bonus(10);
		
		//Getter informació empleats
		String allEmployees=controller.getAllEmployees();
		
		//Getter desglosat salari empleats
		String payAllEmployees = controller.payAllEmployees();
		
		//Getter total a pagar per l'empresa
		String totalPay = controller.totalPay();
		
		//Getter ajudes voluntaris
		String payAllVolunteers = controller.payAllVolunteers();
		
		System.out.println("EMPLOYEES: \n" + allEmployees + " \n");
		System.out.println("SALARIES: \n" + payAllEmployees);
		System.out.println(totalPay);
		System.out.println(payAllVolunteers);

	}

}
