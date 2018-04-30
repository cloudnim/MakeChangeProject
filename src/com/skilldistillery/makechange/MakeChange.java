package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {

	Scanner sc = new Scanner(System.in);

	public double itemPrice;
	public double amountTendered;
	public double amountUpdated;
	public int dollars[];
	public int cents[];
	public int dollarAmountBased;
	public int changeAmountBased;
	public int largestBill;
	public int amountOf100_Bills;
	public int amountOf50_Bills;
	public int amountOf20_Bills;
	public int amountOf10_Bills;
	public int amountOf5_Bills;
	public int amountOf1_Bills;
	public int checkNeedOf100_Bills;
	public int checkNeedOf50_Bills;
	public int checkNeedOf20_Bills;
	public int checkNeedOf10_Bills;
	public int checkNeedOf5_Bills;
	public int checkNeedOf1_Bills;
	public int amountOfPennies;
	public int amountOfNickels;
	public int amountOfDimes;
	public int amountOfQuarters;
	public int checkNeedOfPennies;
	public int checkNeedOfNickels;
	public int checkNeedOfDimes;
	public int checkNeedOfQuarters;

	public double getItemCost(Scanner sc) {
		System.out.println("Please input cost of item: ");
		System.out.print("Input: >");
		double costOfItem = sc.nextDouble();
		return costOfItem;
	}

	public double getTendered(Scanner sc) {
		System.out.println("Please enter amount tendered by customer: ");
		System.out.println("Input: >");
		double amountTendered = sc.nextDouble();
		return amountTendered;
	}

	public void exactChange() {
		System.out.println(
				"\nExact change!? This doesn't happen very often,\nbut it does make my life easier as now I won't\nhave to do more math! Here's your item.");
	}

	public double needAdditional(double needMore) {

		double remainingNeeded = itemPrice - amountTendered;
		System.out.printf("Looks like we need at least $%.2f more.%n%n", remainingNeeded);
		needMore = amountTendered + getTendered(sc);
		return needMore;
	}

	public void returnDollarType() {
		// Run checks to see how many dollars and in largest denominations we need.

		// First things first add values to dollar array to check denominations needed
		// against
		int dollars[] = { 1, 5, 10, 20, 50, 100 };

		// Calculate the change amount
		dollarAmountBased = (int) (amountTendered - itemPrice);
		checkNeedOf100_Bills = 0;
		checkNeedOf50_Bills = 0;
		checkNeedOf20_Bills = 0;
		checkNeedOf10_Bills = 0;
		checkNeedOf5_Bills = 0;
		checkNeedOf1_Bills = 0;

		// Run through a modified high / low loop to find the highest denomination value
		// needed first.
		for (int i = 0; i < dollars.length; i++) {
			if (dollars[i] < dollarAmountBased) {
				checkNeedOf100_Bills = dollars[i];
				if (checkNeedOf100_Bills == 1) {
					amountOf100_Bills = dollarAmountBased / 100;
					dollarAmountBased = dollarAmountBased - (amountOf100_Bills * 100);
				}
			}
			if (dollars[i] < dollarAmountBased) {
				checkNeedOf50_Bills = dollars[i];
				if (checkNeedOf50_Bills == 1) {
					amountOf50_Bills = dollarAmountBased / 50;
					dollarAmountBased = dollarAmountBased - (amountOf50_Bills * 50);
				}
			}
			if (dollars[i] < dollarAmountBased) {
				checkNeedOf20_Bills = dollars[i];
				if (checkNeedOf20_Bills == 1);
				{
					amountOf20_Bills = dollarAmountBased / 20;
					dollarAmountBased = dollarAmountBased - (amountOf20_Bills * 20);
				}
			}
			if (dollars[i] < dollarAmountBased) {
				amountOf10_Bills = dollars[i];
				if (checkNeedOf10_Bills == 1);
				{
					amountOf10_Bills = dollarAmountBased / 10;
					dollarAmountBased = dollarAmountBased - (amountOf10_Bills * 10);
				}
			}
			if (dollars[i] < dollarAmountBased) {
				checkNeedOf5_Bills = dollars[i];
				if (checkNeedOf5_Bills == 1) {
					amountOf5_Bills = dollarAmountBased / 5;
					dollarAmountBased = dollarAmountBased - (amountOf5_Bills * 5);
				}
			}
			if (dollars[i] <= dollarAmountBased) {
				checkNeedOf1_Bills = dollars[i];
				if (checkNeedOf1_Bills == 1) {
					amountOf1_Bills = dollarAmountBased / 1;
					dollarAmountBased = dollarAmountBased - (amountOf1_Bills * 1);
				}
			}

			else {
				break;
			}
		}
	}

	//
	public void returnCentsType() {
		// Run checks to see how many dollars and in largest denominations we need.

		// First things first add values to dollar array to check denominations needed
		// against
		int cents[] = { 1, 5, 10, 25 };

		// Grab the decimal portion of the amount tendered

		changeAmountBased = (int) (Math.round(((amountTendered - itemPrice) % 1) * 100));

		// Calculate the change amount

		checkNeedOfPennies = 0;
		checkNeedOfNickels = 0;
		checkNeedOfDimes = 0;
		checkNeedOfQuarters = 0;

		for (int i = 0; i < cents.length; i++) {

			if (cents[i] < changeAmountBased) {
				checkNeedOfQuarters = cents[i];
				if (checkNeedOfQuarters == 1) {
					amountOfQuarters = changeAmountBased / 25;
					changeAmountBased = changeAmountBased - (amountOfQuarters * 25);
				}
			}
			if (cents[i] < changeAmountBased) {
				checkNeedOfDimes = cents[i];
				if (checkNeedOfDimes == 1) {
					amountOfDimes = changeAmountBased / 10;
					changeAmountBased = changeAmountBased - (amountOfDimes * 10);
				}
			}
			if (cents[i] < changeAmountBased) {
				checkNeedOfNickels = cents[i];
				if (checkNeedOfNickels == 1) {
					amountOfNickels = changeAmountBased / 5;
					changeAmountBased = changeAmountBased - (amountOfNickels * 5);
				}
			}

			if (cents[i] <= changeAmountBased) {
				checkNeedOfPennies = cents[i];
				if (checkNeedOfPennies == 1) {
					amountOfPennies = changeAmountBased / 1;
					changeAmountBased = changeAmountBased - (amountOfPennies * 1);
				}
			}

		}

	}

	public void printResults() {
		System.out.printf("Amount: $%.2f, Tendered: $%.2f, Result: %n%n", itemPrice, amountTendered);
		System.out.println("Number of $100 bills:" + amountOf100_Bills);
		System.out.println("Number of $50 bills:" + amountOf50_Bills);
		System.out.println("Number of $20 bills:" + amountOf20_Bills);
		System.out.println("Number of $10 bills:" + amountOf10_Bills);
		System.out.println("Number of $5 bills:" + amountOf5_Bills);
		System.out.println("Number of $1 bills:" + amountOf1_Bills);
		System.out.println("Number of Quarters: " + amountOfQuarters);
		System.out.println("Number of Dimes: " + amountOfDimes);
		System.out.println("Number of Nickles: " + amountOfNickels);
		System.out.println("Number of Pennies: " + amountOfPennies);
	}

}
