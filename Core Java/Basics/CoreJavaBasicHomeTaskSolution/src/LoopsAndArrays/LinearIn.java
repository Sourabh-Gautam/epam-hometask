package LoopsAndArrays;

public class LinearIn {

	public static boolean linearIn(int[] outer, int[] inner) {

		int j = 0;

		for (int i = 0; i < outer.length; i++) {
			if (j < inner.length) {
				if (outer[i] == inner[j]) {
					j++;
				}
			} else {
				return true;
			}
		}

		if (j == inner.length) {
			return true;
		}

		return false;

	}

	public static void main(String[] args) {
		
		int []outer = {1, 2, 4, 6};
		int []inner = {2, 4};
		
		System.out.println(linearIn(outer, inner));

	}

}
