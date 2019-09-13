package com.sanjaygoyaljpr.interfaceTest;

public class ABCDTest {

	public static void main(String[] args) {
		
		//reverseNumber(1234);
		//reverseNumber(90);
		
		//reverseNumberRecursive(1234, 0);
		//reverseNumberRecursive(90, 0);
		
		printNumbers();
		

	}
	
	static void printNumbers() {

		for (int i = 1000; i < 9999; i++) {
			
			if(i*4 == reverseNumber(i)) {
				System.out.println(i);
			}

		}

	}
	
	static int reverseNumber(int num) {
		int rev = 0;
		
		while(num > 0) {
			int mod = num%10;
			rev = (rev*10) + mod;
			num = num/10;
		}
		return rev;
	}
	
	static int reverseNumberRecursive(int num, int rev) {
		
		if(num <= 0) {
			System.out.println(rev);
			return rev;
		}
		
		int mod = num%10;
		rev = (rev*10) + mod;
		return reverseNumberRecursive(num/10, rev);
		
	}

}
