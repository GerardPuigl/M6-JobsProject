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
	
	//Reducció 5% a Empleats Senior
	public static IPaymentRate createPaymentRateEmployeeSenior(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*0.95;
			}
		};
	}
	
	//Reducció 10% a Empleats Mid
	public static IPaymentRate createPaymentRateEmployeeMid(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*0.90;
			}
		};
	}
	
	//Reducció 15% a Empleats Mid
	public static IPaymentRate createPaymentRateEmployeeJunior(){
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
