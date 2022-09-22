package Oops2;


public class Chocolate implements Sweet {

	Gift gift;

	public Chocolate(Gift gift) {
		super();
		this.gift = gift;
	}

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}

	@Override
	public int compareTo(Sweet o) {
		if(this.getGift().getCandies() > o.getGift().getCandies()) {
			return 1;
		}
		
		if(this.getGift().getCandies() < o.getGift().getCandies()) {
			return -1;
		}
		
		return 0;
	}

	@Override
	public String toString() {
		return gift.toString();
	}

}
