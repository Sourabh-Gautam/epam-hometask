package Oops2;

public class Gift {
	int candies;

	public Gift(int candies) {
		super();
		this.candies = candies;
	}

	public int getCandies() {
		return candies;
	}

	public void setCandies(int candies) {
		this.candies = candies;
	}

	@Override
	public String toString() {
		return candies+"";
	}
}
