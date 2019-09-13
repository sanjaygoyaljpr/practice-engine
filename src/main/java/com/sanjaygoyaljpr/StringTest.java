package com.sanjaygoyaljpr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StringTest {

	public static void main(String[] args) {

		//int deletionCharCount = makeAnagram("defabcc", "aabc");
		//System.out.println("makeAnagram : " + deletionCharCount);
		
		//int deletionCharCount = alternatingCharacters("ABABAA");
		//System.out.println("makeAnagram : " + deletionCharCount);
		
		System.out.println("isValid : " + isValid("aaabbbccc"));

	}
	
	static String isValid(String s) {
		String isValid = "YES";
		
		int[] countArray = new int[26];
		
		for (char c1 : s.toCharArray()) {
			countArray[c1-'a']++;
		}
		
		List<Integer> countList = Arrays.stream(countArray).boxed().filter(i -> i > 0).collect(Collectors.toList());
		List<Integer> uniqueCount = new ArrayList<Integer>();
		
		for (int i = 0; i < 26; i++) {
			if(countArray[i] > 0 && !uniqueCount.contains(countArray[i])) {
				uniqueCount.add(countArray[i]);
			}
		}
		
		if(uniqueCount.size() > 2) {
			return "NO";
		} else if(Math.abs(uniqueCount.get(0) - uniqueCount.get(1)) > 1){
			return "NO";
		} else {
			int max = Math.max(uniqueCount.get(0), uniqueCount.get(1));
			if(countList.indexOf(max) != countList.lastIndexOf(max)) {
				return "NO";
			}
		}
		
		return isValid;
	}
	
	static int alternatingCharacters(String s) {
		int deletionCharCount = 0;
		
		if(s.length() == 0) {
			return deletionCharCount;
		}
		
		char[] charArray = s.toCharArray();
		char currentChar = charArray[0];
		
		for (int i = 1; i < charArray.length; i++) {
			if(charArray[i] == currentChar) {
				deletionCharCount++;
			} else {
				currentChar = charArray[i];
			}
		}
		
		return deletionCharCount;
    }

	static int makeAnagram(String a, String b) {
		int deletionCharCount = 0;

		Map<Character, Integer> charCountMapA = new HashMap<Character, Integer>();
		Map<Character, Integer> charCountMapB = new HashMap<Character, Integer>();

		for (char c1 : a.toCharArray()) {
			if (b.indexOf(c1) >= 0) {
				if (charCountMapA.get(c1) != null) {
					charCountMapA.put(c1, charCountMapA.get(c1) + 1);
				} else {
					charCountMapA.put(c1, 1);
				}
			} else {
				deletionCharCount++;
			}
		}
		
		for (char c2 : b.toCharArray()) {
			if (a.indexOf(c2) >= 0) {
				if (charCountMapB.get(c2) != null) {
					charCountMapB.put(c2, charCountMapB.get(c2) + 1);
				} else {
					charCountMapB.put(c2, 1);
				}
			} else {
				deletionCharCount++;
			}
		}
		
		for (Entry<Character, Integer> entry : charCountMapA.entrySet()) {
			int diff = Math.abs(entry.getValue().intValue() - charCountMapB.get(entry.getKey()));
			if(diff > 0) {
				deletionCharCount += diff;
			}
		}

		return deletionCharCount;
	}

}
