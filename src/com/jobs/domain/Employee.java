package com.jobs.domain;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();

				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	//c�lculo bruto mensual sobreescrit la classe PaymentFactory
	@Override
	public double payGross() {
		return totalPaid=paymentRate.payGross(salaryPerMonth);
	}

	//c�lculo neto mensual sobreescrit la classe PaymentFactory
	@Override
	public double payNet() {
		return totalPaid=paymentRate.payNet(salaryPerMonth);
	}
}
