package com.sanjaygoyaljpr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

abstract class ConfusingOverloading{
	  
    public boolean hasDuplicates (List collection){
        System.out.println("overloaded method with Type List ");
        return true;
    }
  
    public boolean hasDuplicates (ArrayList collection){
        System.out.println("overloaded method with Type ArrayList ");
        return true;
    }
  
  
    public boolean hasDuplicates (LinkedList collection){
        System.out.println("overloaded method with Type LinkedList ");
        return true;
    }
  
}

public class StaircaseTest {
	
	public static void main(String[] args) {

		int n = 6;

		// staircase(n);
		// staircase1(n);

		// timeConversion("01:00:00AM");

		// int[] arr = { -4, 3, -9, 0, 4, 1 };
		// plusMinus(arr);

		List<List<Integer>> arr = new ArrayList<List<Integer>>();
		Map<String, String> map = new HashMap<String, String>();
		
		Queue<String> queue = new LinkedList<String>();
		// arr.add(Arrays.asList(11, 2, 4));
		// arr.add(Arrays.asList(4, 5, 6));
		// arr.add(Arrays.asList(10, 8, -12));

		// int result = diagonalDifference(arr);
		// System.out.println(result);

		// Scanner scan = new Scanner(System.in);

		/* Declare second integer, double, and String variables. */
		// int i = 4;
		// double d = 4.0;
		// String s = "HackerRank ";

		// int j = scan.nextInt();
		// double e = scan.nextDouble();
		// scan.nextLine();
		// String t = scan.nextLine();

		// System.out.println(i+j);
		// System.out.println(d+e);
		// System.out.println(s+t);

		// int[] arr = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		// int count = sockMerchant(9, arr);
		// System.out.println("Socks Count " + count);

		// countingValleys();

		// int[] arr = { 0};
		// int countJumps = jumpingOnClouds(arr);
		// System.out.println("Count Jumps " + countJumps);

		//long countA = repeatedString("aba", 10);
		//System.out.println("Count A " + countA);
		
		//int[] a = { 1, 2, 3, 4, 5 };
		//a = rotLeft(a, 4);
		//System.out.println(Arrays.toString(a));
		
		/*
		 * int[][] a = {{ -1, -1, 0, -9, -2, -2 }, {-2, -1, -6, -8, -2, -5},
		 * {-1, -1, -1, -2, -3, -4}, {-1, -9, -2, -4, -4, -5}, {-7, -3, -3, -2,
		 * -9, -9}, {-1, -3, -1, -2, -4, -5}};
		 * 
		 * int result = hourglassSum(a); System.out.println(result);
		 */
		
		//int[] a = { 1, 2, 3, 4, 5 };
		//int[] ab = { 3, 2, 5, 4, 1 };
		//minimumBribes(a);
		
		int[] a = { 1, 3, 2, 4 };
		int[] b = { 1, 9, 9, 9 };
		addByOne(b);
		
		fun(null);
		
	}
	
	static void addByOne(int[] a) {

		int n = a.length;

		for (int i = n-1; i >= 0; i--) {
			if (a[i] == 9) {
				a[i] = 0;
				continue;
			} else {
				a[i] += 1;
				break;
			}
		}
		
		System.out.println(Arrays.toString(a));
	}
	
	static void minimumBribes(int[] q) {

		int bribeCount = 0;
		int n = q.length;

		for (int i = 0; i < n; i++) {
			
			if (q[i] - (i + 1) > 2) {
				System.out.println("Too chaotic");
				return;
			}
			
			for (int j = Math.max(0, q[i] - 2); j < i; j++) {
				if (q[j] > q[i]) {
					bribeCount++;
				}
			}
		}
		
		System.out.println(bribeCount);
	}
	
	static int hourglassSum(int[][] a) {
		int maxHourGlass = -63;
		
		for (int i = 0; i < a.length - 2; i++) {
			
			for (int j = 0; j < a.length - 2; j++) {
				int sum = a[i][j] + a[i][j+1] +a[i][j+2] +a[i+1][j+1] +a[i+2][j] +a[i+2][j+1] + a[i+2][j+2];
				
				if(maxHourGlass < sum) {
					maxHourGlass = sum;
				}
			}
		}
		return maxHourGlass;
    }
	
	
    static int[] rotLeft(int[] a, int d) {
    	
    	int length = a.length;
    	
    	for (int i = 0; i < d; i++) {
    		int temp = a[0];
    		
    		for (int j = 0; j < length-1; j++) {
        		a[j] = a[j+1];
    		}
    		
    		a[length-1] = temp;
		}
    	
    	return a;
    }

	static long repeatedString(String s, long n) {
		long countA = 0;

		int length = s.length();

		long mainStringCopy = n / length;
		long charRequired = n % length;

		// Calculate number of a
		for (char c : s.toCharArray()) {
			if (c == 'a') {
				countA++;
			}
		}
		
		countA = countA * mainStringCopy;

		if (charRequired > 0) {
			s = s.substring(0, (int) charRequired);
			
			for (char c : s.toCharArray()) {
				if (c == 'a') {
					countA++;
				}
			}
		}

		return countA;
	}

	static int jumpingOnClouds(int[] c) {
		int countJumps = 0;

		int n = c.length;
		int i = 0;

		while (i < n - 1) {
			if ((i + 2) <= (n - 1) && c[i + 2] == 0) {
				countJumps++;
				i = i + 2;
			} else {
				countJumps++;
				i = i + 1;
			}
		}

		return countJumps;
	}

	static void countingValleys() {

		String terrain = "UDDDUDUU";
		int n = terrain.length();
		int level = 0;
		int valleys = 0;
		boolean isSeaLevel = false;

		for (int i = 0; i < n; i++) {
			char slope = terrain.charAt(i);
			if (slope == 'U') {
				level++;
			} else {
				level--;
			}

			if (!isSeaLevel && level < 0) {
				valleys++;
				isSeaLevel = true;
			}

			if (level >= 0) {
				isSeaLevel = false;
			}
		}
		System.out.println(valleys);

	}

	static int sockMerchant(int n, int[] ar) {

		int countSocks = 0;

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			if (list.contains(ar[i])) {
				countSocks++;
				list.remove(Integer.valueOf(ar[i]));
			} else {
				list.add(ar[i]);
			}
		}

		return countSocks;

	}

	public static int diagonalDifference(List<List<Integer>> arr) {

		int leftToRightDiagonal = 0;
		int rightToLeftDiagonal = 0;
		int length = arr.size();

		for (int i = 0; i < length; i++) {
			leftToRightDiagonal += arr.get(i).get(i);
			rightToLeftDiagonal += arr.get(i).get(length - 1 - i);
		}

		return Math.abs(leftToRightDiagonal - rightToLeftDiagonal);

	}

	static void plusMinus(int[] arr) {

		int length = arr.length;

		int positiveCount = 0;
		int negativeCount = 0;
		int zeroCount = 0;

		for (int i = 0; i < length; i++) {
			if (arr[i] > 0) {
				positiveCount += 1;
			} else if (arr[i] < 0) {
				negativeCount += 1;
			} else {
				zeroCount += 1;
			}
		}

		System.out.printf("%.6f\n", (float) positiveCount / length);
		System.out.printf("%.6f\n", (float) negativeCount / length);
		System.out.printf("%.6f\n", (float) zeroCount / length);

	}

	static String timeConversion(String s) {
		String result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ssa");
			Date inputDate = sdf.parse(s);
			result = new SimpleDateFormat("HH:mm:ss").format(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	static void staircase1(int n) {

		StringBuilder sb = new StringBuilder(n);
		String fmt = "%" + n + "s\n";
		for (int i = 1; i <= n; i++) {
			sb.append('#');
			System.out.printf(fmt, sb);
		}

	}

	static void staircase(int n) {
		if (n > 0 && n <= 100) {

			for (int i = n; i > 0; i--) {
				for (int j = 1; j <= n; j++) {
					if (j < i) {
						System.out.print(" ");
					} else {
						System.out.print("#");
					}
				}
				System.out.println();
			}

		} else {
			return;
		}

	}
	
	static void fun(Object abc) {
		System.out.println("Object");
	}
	
	static void fun(List<Integer> abc) {
		System.out.println("List");
	}
	

}
