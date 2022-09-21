package LoopsAndArrays;

public class CanBalance {

	public static boolean canBalance(int[] nums) {
		int sum = 0;
		for (int a : nums) {
			sum += a;
		}

		if (sum % 2 != 0) {
			return false;
		}

		int halfsum = sum / 2;

		int leftsum = 0;

		for (int i = 0; i < nums.length; i++) {
			leftsum = leftsum + nums[i];
			if (leftsum == halfsum) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		int nums[] = { 1, 1, 1, 2, 1 };
		System.out.println(canBalance(nums));

	}

}
