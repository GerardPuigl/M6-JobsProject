package com.jobs.domain;

public interface IPaymentRate {
	public double payNet(double salaryPerMonth);
	public double payGross(double salaryPerMonth);
}
