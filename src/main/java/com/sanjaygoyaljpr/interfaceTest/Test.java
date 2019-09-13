package com.sanjaygoyaljpr.interfaceTest;

public class Test implements A, B {

	@Override
	public void print() {
		System.out.println("Print Method");
	}
	
	public static void main(String [] args) {
		
		Test t = new Test();
		t.print();
		
		A a = new Test();
		a.print();
		
		B b = new Test();
		b.print();
		
	}

}
