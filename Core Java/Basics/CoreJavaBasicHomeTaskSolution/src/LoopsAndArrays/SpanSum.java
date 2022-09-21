package LoopsAndArrays;

public class SpanSum {
	
	public static int maxSpan(int[] nums) {
	    int max = 0;
	    
	    for(int i = 0; i < nums.length; i++) {
	        int j = nums.length - 1;
	              
	        while(nums[i] != nums[j])
	            j--;
	                              
	        int span = j - i + 1;
	                                      
	        if(span > max)
	            max = span;
	    }
	                                                    
	    return max;
	}

	public static void main(String[] args) {
		
		int nums[] = {1, 4, 2, 1, 4, 4, 4};
		
		System.out.println(maxSpan(nums));
		
	}

}
