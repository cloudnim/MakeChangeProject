package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {

		/*
		 * This program will imitate a cash register. It will accept input of values of
		 * items, create a total, prompt the total and method of payment. If it is cash
		 * payment it will calculate change and return the amount of change in largest
		 * denomination type needed (eg. x dollars, x cents).
		 */

		Scanner sc = new Scanner(System.in);
		registerHeader();

		// Make a new MakeChange object and load the data from user input.

		MakeChange mc = new MakeChange();
		mc.itemPrice = mc.getItemCost(sc);
		System.out.println();

		// Have MakeChange prompt for how much was tendered by customer.

		mc.amountTendered = mc.getTendered(sc);
		System.out.printf("Amount tendered was: $%.2f%n%n", mc.amountTendered);

		// Check to make sure we received enough tendered or if customer gave exact change
		if (mc.amountTendered < mc.itemPrice) {
			{
				System.out.println(
						"I know you'd like to think you'd \"gladly pay me Tuesday for a hamburger today\",\nbut it appears you're a little short. Reach deep down in those pockets.\n");
				mc.amountUpdated = 0;
				while (mc.amountUpdated < mc.itemPrice) {
					mc.amountUpdated = mc.needAdditional(mc.amountUpdated);
					mc.amountTendered = mc.amountUpdated;
				}
				if (mc.amountUpdated == mc.itemPrice) {
					mc.exactChange();
					registerFooter();
					System.exit(0);
				} else {
					System.out.printf("Ok, I now have $%.2f, looks good. Let me get your change...%n", mc.amountUpdated);
				}
			}

		} else if (mc.amountTendered == mc.itemPrice) {
			mc.exactChange();
			registerFooter();
			System.exit(0);
		}

		else {
		}
		
		mc.returnDollarType();
		mc.returnCentsType();
		mc.printResults();
		registerFooter();
		
	}

	private static void registerHeader() {
		// create a register header
		System.out.println("*****************************************");
		System.out.println("**   Cashbot Register - version 1.0    **");
		System.out.println("*****************************************");
		System.out.println();

	}

	private static void registerFooter() {
		System.out.println();
		System.out.println("*****************************************");
		System.out.println("**      Thank you!! Come Again!!       **");
		System.out.println("*****************************************");
	}

}
