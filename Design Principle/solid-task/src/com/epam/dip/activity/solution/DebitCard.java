package com.epam.dip.activity.solution;

public class DebitCard implements PaymentCard {

	public void doTransaction(int amount) {
		System.out.println("Payment done through debit card : RS. "+amount);
	}

}
