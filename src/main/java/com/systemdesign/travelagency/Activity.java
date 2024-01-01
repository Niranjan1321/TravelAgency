package com.systemdesign.travelagency;

import java.util.HashSet;
import java.util.Set;

public class Activity {

	private String name;
	private String description;
	private double cost;
	private int capacity;

	// Each activity has a linked destination, which gets initialized at the time of
	// destination instantiation
	private Destination destination;

	// Both the below members are declared static as they are on the class level
	static Set<Activity> activities = new HashSet<Activity>();
	static Set<String> activityNames = new HashSet<String>();

	boolean isAvailable() {
		return capacity > 0;
	}

	public void signUpPassenger(Passenger passenger) {

		if (isAvailable()) {
			passenger.addActivity(this);
			--capacity;
		} else {
			System.out.println("Activity " + name + " is fully booked.");
		}
	}

	public double getDiscountedCost(Passenger passenger) {

		if (passenger instanceof GoldPassenger) {
			return cost * 0.9;
		}

		return cost;
	}

	public static void activityDetails() {

		System.out.println("Activities that have spaces available are, ");

		for (Activity activity : getActivities()) {

			if (activity.getCapacity() > 0) {
				System.out.println(
						"Activity " + activity.getName() + " have " + activity.getCapacity() + " spaces left.");
			}

		}
	}

	public Activity() {

	}

	public Activity(String name, String description, double cost, int capacity) {
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.capacity = capacity;
		Activity.addActivity(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public static void addActivity(Activity activity) {

		// Logic to ensure duplicate Activities are not added
		if (!activityNames.contains(activity.getName())) {
			activityNames.add(activity.getName());
			activities.add(activity);
		}
	}

	public static Set<Activity> getActivities() {
		return activities;
	}

	public static void setActivities(Set<Activity> newActivities) {

		activities.clear();
		activityNames.clear();

		activities.addAll(newActivities);

		for (Activity activity : activities) {
			activityNames.add(activity.getName());
		}

	}

	@Override
	public String toString() {

		StringBuilder result = new StringBuilder(
				"name=" + name + ", description=" + description + ", cost=" + cost + ", capacity=" + capacity);
		if (destination != null) {
			result.append(", destination=" + destination.getName());
		}

		return result.toString();

	}

}
