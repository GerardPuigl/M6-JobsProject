package com.jobs.application;

import javax.swing.DefaultRowSorter;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	//Increment 50% a empleat Boss càlcul brut i net mensual
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double payGross(double salaryPerMonth) {
				return salaryPerMonth*1.5;
			}
			@Override
			public double payNet(double salaryPerMonth) {
				return salaryPerMonth*1.5-salaryPerMonth*1.5*0.32;
			}			
		};
	}
	
	//Reducció 5% a Empleats Senior càlcul brut i net mensual
	public static IPaymentRate createPaymentRateEmployeeSenior(){
		return new IPaymentRate() {
			@Override
			public double payGross(double salaryPerMonth) {
				return salaryPerMonth*0.95;
			}
			@Override
			public double payNet(double salaryPerMonth) {
				return salaryPerMonth*0.95-salaryPerMonth*0.95*0.24;
			}
		};
	}
	
	//Reducció 10% a Empleats Mid càlcul brut i net mensual
	public static IPaymentRate createPaymentRateEmployeeMid(){
		return new IPaymentRate() {
			@Override
			public double payGross(double salaryPerMonth) {
				return salaryPerMonth*0.90;
			}
			@Override
			public double payNet(double salaryPerMonth) {
				return salaryPerMonth*0.90-salaryPerMonth*0.90*0.15;
			}
		};
	}
	
	//Reducció 15% a Empleats junior càlcul brut i net mensual
	public static IPaymentRate createPaymentRateEmployeeJunior(){
		return new IPaymentRate() {
			@Override
			public double payGross(double salaryPerMonth) {
				return salaryPerMonth*0.85;
			}
			@Override
			public double payNet(double salaryPerMonth) {
				return salaryPerMonth*0.85-salaryPerMonth*0.85*0.02;
			}
		};
	}
		
	//Augment 10% als managers càlcul brut i net mensual
	public static IPaymentRate createPaymentRateManager(){
		return new IPaymentRate() {
			@Override
			public double payGross(double salaryPerMonth) {
				return salaryPerMonth*1.10;
			}
			@Override
			public double payNet(double salaryPerMonth) {
				return salaryPerMonth*1.10-salaryPerMonth*1.10*0.26;
			}
		};
	}
}
