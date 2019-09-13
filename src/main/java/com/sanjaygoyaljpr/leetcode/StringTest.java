package com.sanjaygoyaljpr.leetcode;

import java.util.LinkedList;

public class StringTest {

	public static void main(String[] args) {

		System.out.println(superReducedStringWithStack("aabba"));
		System.out.println(superReducedStringWithStack("abaab"));
		System.out.println(superReducedStringWithStack("aa"));
		System.out.println(superReducedStringWithStack("aaabccddd"));
		
		System.out.println(Integer.valueOf('Z'));
		
		System.out.println(camelcase("oneTwoThree"));
		System.out.println(camelcase("saveChangesInTheEditor"));

	}
	
	// CamelCase
    static int camelcase(String s) {
    	char[] array = s.toCharArray();
    	int i = 0;
    	for (char c : array) {
			if(c >= 65 && c <= 90) {
				i++;
			}
		}
    	return ++i;
    }

	// Super Reduced String
	static String superReducedString(String s) {
		StringBuilder builder = new StringBuilder();
		char[] array = s.toCharArray();

		int i = 0;
		int j = -1;
		while (i <= array.length - 1) {
			if (!(i == array.length - 1) && array[i] == array[i + 1]) {
				i = i + 2;
			} else {
				if (j > -1 && builder.charAt(j) == array[i]) {
					builder.deleteCharAt(j--);
				} else {
					builder.insert(++j, array[i]);
				}
				i++;
			}
		}

		if (j > -1) {
			return builder.toString();
		} else {
			return "Empty String";
		}
	}

	// Super Reduced String with Stack
	static String superReducedStringWithStack(String s) {
		LinkedList<Character> stack = new LinkedList<Character>();
		
		char[] array = s.toCharArray();

		int i = 0;
		while (i < array.length) {
			if(stack.size() > 0 && stack.peek() == array[i]) {
				stack.pop();
			} else {
				stack.push(array[i]);
			}
			i++;
		}

		if (stack.size() > 0) {
			return stack.toString();
		} else {
			return "Empty String";
		}
	}

}
