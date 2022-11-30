package com.example.demo_project.vo;

public class Basic {
	
	private static int count = 0;
	
	public int serialNo = 0;
	
	public Basic() {
		serialNo = ++Basic.count;
	}
	
	public static void main(String[] args) {
		Basic b01 = new Basic();
		Basic b02 = new Basic();
		Basic b03 = new Basic();
		
		System.out.println(b01.serialNo);
		System.out.println(b02.serialNo);
		System.out.println(b03.serialNo);
	}

}
