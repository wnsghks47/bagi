package com.tech.ex;

public class BMICalculator {
	private double lowWeight;
	private double nomal;
	private double overweight;
	private double obesity;
	
	public void bmiCalculator(double weight,double height) {
		double h=height*0.01;
		double result=weight/(h*h);
		System.out.println("BMI 지수 : "+(int)result);
		
		if (result>obesity) {
			System.out.println("비만");
		}else if (result>overweight) {
			System.out.println("과체중");
		}else if (result>nomal) {
			System.out.println("평균");
		}else {
			System.out.println("저체중");
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