package LoopsAndArrays;

public class CountClump {
	
	public static int countClumps(int[] nums) {
		  
		  int left=0;
		  int right=1;
		  int clump = 0;
		  boolean flag = false;
		  
		  while(right<nums.length) {
		    
		    if(nums[left] == nums[right]) {
		      right++;
		      flag = true;
		      continue;
		    }
		    
		    if(flag) {
		      clump++;
		      flag = false;
		      left = right;
		      right++;
		      continue;
		    }
		    
		    left++;
		    right++;
		    
		  }
		  
		  if(flag) {
		    return clump+1;
		  }
		  
		  return clump;
		}

	public static void main(String[] args) {
	
		int[] nums = {1, 2, 2, 3, 4, 4};
		System.out.println(countClumps(nums));

	}

}
