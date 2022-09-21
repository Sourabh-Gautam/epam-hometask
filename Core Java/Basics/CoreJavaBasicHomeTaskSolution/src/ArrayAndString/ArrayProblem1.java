package ArrayAndString;

import java.util.Arrays;

//Write a program to find the missing number in integer array of 1 to 100

public class ArrayProblem1 {
	
	public static void main(String[] args) {
		
		int[] arr = {1,4,2,5,6,56,43,34};
		
		Arrays.sort(arr);
		
		int p = 0;
		
		for(int i=0; i<=100; i++) {
			if(p!=arr.length) {
				if(arr[p]==i) {
					p++;
					continue;
				}
			}
			System.out.print(i+" ");
		}
	}

}
