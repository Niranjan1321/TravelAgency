package com.systemdesign.travelagency;

import java.util.ArrayList;
import java.util.List;

public class Passenger {

	private String name;
	private int passengerNumber;
	private List<Activity> bookedActivities;

	public Passenger(String name, int passengerNumber) {
		super();
		this.name = name;
		this.passengerNumber = passengerNumber;
		this.bookedActivities = new ArrayList<>();
		;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassengerNumber() {
		return passengerNumber;
	}

	public void setPassengerNumber(int passengerNumber) {
		this.passengerNumber = passengerNumber;
	}

	public List<Activity> getBookedActivities() {
		return bookedActivities;
	}

	public void setBookedActivities(List<Activity> bookedActivities) {
		this.bookedActivities = bookedActivities;
	}

	public void addActivity(Activity activity) {
		bookedActivities.add(activity);
	}

	public String toString() {
		StringBuilder result = new StringBuilder("Passenger: " + name + " Passenger Number: " + passengerNumber);
		if (!bookedActivities.isEmpty()) {
			result.append("\nBooked Activities:\n");
			for (Activity activity : bookedActivities) {
				result.append(activity.toString()).append("\n");
			}
		}
		return result.toString();
	}

}

class StandardPassenger extends Passenger {

	private double balance;

	public StandardPassenger(String name, int passengerNumber, double balance) {
		super(name, passengerNumber);
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public void addActivity(Activity activity) {
		double cost = activity.getDiscountedCost(this);

		if (balance >= cost) {
			super.addActivity(activity);
			balance -= cost;
		} else {
			System.out.println("No sufficient Balance to book the activity " + activity.getName());
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Balance: " + balance;
	}
}

class GoldPassenger extends Passenger {

	private double balance;

	public GoldPassenger(String name, int passengerNumber, double balance) {
		super(name, passengerNumber);
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public void addActivity(Activity activity) {
		double cost = activity.getDiscountedCost(this);

		if (balance >= cost) {
			super.addActivity(activity);
			balance -= cost;
		} else {
			System.out.println("No sufficient Balance to book the activity " + activity.getName());
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Balance: " + balance;
	}
}

class PremiumPassenger extends Passenger {

	public PremiumPassenger(String name, int passengerNumber) {
		super(name, passengerNumber);
	}

	@Override
	public void addActivity(Activity activity) {

		super.addActivity(activity);

	}

	@Override
	public String toString() {
		return super.toString();
	}

}
