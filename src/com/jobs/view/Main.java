package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	
	
	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		
		controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 9000);
		controller.createEmployeeSenior("Pedro Employee Senior", "Dirección molona 2", "665266666", 2500.00);
		controller.createEmployeeJunior("Laura Employee Junior", "Dirección molona 3", "625266666", 1500);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666");
		controller.createManagerEmployee("Pedro Employee", "Dirección molona 2", "665226666", 4000);
				
		String allEmployees=controller.getAllEmployees();
		String payAllEmployees = controller.payAllEmployees();

		System.out.println("EMPLOYEES: \n" + allEmployees + " \n");
		System.out.println("PAYS: \n" + payAllEmployees);
	}

}
