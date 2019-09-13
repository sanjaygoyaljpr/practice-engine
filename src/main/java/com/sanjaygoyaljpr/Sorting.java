package com.sanjaygoyaljpr;

import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		
		int[] array = {22, 11, 11, 0, -9, -1, 0};
		System.out.println("Array before sorting:  " + Arrays.toString(array));
		selectionSort(array);
		System.out.println("Array after sorting:  " + Arrays.toString(array));

	}

	private static void selectionSort(int[] a) {
		int minValueIndex = 0;
		for (int i = 0; i < a.length; i++) {
			minValueIndex = i;
			for (int j = i+1; j < a.length; j++) {
				if(a[j] < a[minValueIndex]) {
					minValueIndex = j;
				}
			}
			if(i != minValueIndex) {
				int temp = a[i];
				a[i] = a[minValueIndex];
				a[minValueIndex] = temp;
			}
		}
	}

}
