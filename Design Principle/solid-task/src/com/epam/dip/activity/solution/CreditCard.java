package com.epam.dip.activity.solution;

public class CreditCard implements PaymentCard {

	public void doTransaction(int amount) {
		System.out.println("Payment done through credit card : RS. "+amount);
	}

}
