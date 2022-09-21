package ArrayAndString;

//Write a program to find biggest and smallest number in a array.

public class ArrayProblem2 {
	public static void main(String[] args) {
		int[] arr = {1,4,2,5,6,56,43,34, -1};
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		
		System.out.println("Biggest value is "+max);
		System.out.println("Smallest value is "+min);
		
	}
}
