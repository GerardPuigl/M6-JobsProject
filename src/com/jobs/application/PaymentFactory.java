package com.jobs.application;

import javax.swing.DefaultRowSorter;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.5;
			}
		};
	}
	
<<<<<<< HEAD
	public static IPaymentRate createPaymentRateEmployeeSenior(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*0.95;
			}
		};
	}
	
	public static IPaymentRate createPaymentRateEmployeeMid(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*0.90;
			}
		};
	}
	
	public static IPaymentRate createPaymentRateEmployeeJunior(){
=======
	//Reducció 15% als empleats
	public static IPaymentRate createPaymentRateEmployee(){
>>>>>>> refs/heads/Fase_1
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*0.85;
			}
		};
	}
	
	//Augment 10% als managers
	public static IPaymentRate createPaymentRateManager(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.10;
			}
		};
	}
}
