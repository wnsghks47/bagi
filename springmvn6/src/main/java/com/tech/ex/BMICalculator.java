package com.tech.ex;

public class BMICalculator {
	private double lowWeight;
	private double nomal;
	private double overweight;
	private double obesity;
	
	public void bmiCalculator(double weight,double height) {
		double h=height*0.01;
		double result=weight/(h*h);
		System.out.println("BMI ���� : "+(int)result);
		
		if (result>obesity) {
			System.out.println("��");
		}else if (result>overweight) {
			System.out.println("��ü��");
		}else if (result>nomal) {
			System.out.println("���");
		}else {
			System.out.println("��ü��");
		}
		
	}

	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}

	public void setNomal(double nomal) {
		this.nomal = nomal;
	}

	public void setOverweight(double overweight) {
		this.overweight = overweight;
	}

	public void setObesity(double obesity) {
		this.obesity = obesity;
				
				
				
				
				
	}
	
}