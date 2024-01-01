package com.systemdesign.travelagency;

import java.util.HashSet;
import java.util.Set;

public class Activity {

	private String name;
	private String description;
	private double cost;
	private int capacity;

	/*
	 * Each activity has an associated destination, which is initialized at the time
	 * of Destination instantiation or can be initialized by the method
	 * addActivityToTheDestination of Destination class.
	 */
	private Destination destination;

	/*
	 * Both the below members and their associated methods are declared static so
	 * they can store all the activities associated with all objects of Activity
	 * class.
	 */
	static Set<Activity> activities = new HashSet<Activity>();
	static Set<String> activityNames = new HashSet<String>();

	// To check if the activity still have spaces left
	boolean isAvailable() {
		return capacity > 0;
	}

	/*
	 * Sign up the passenger to the activity provided there are still spaces left in
	 * the activity and the passenger has sufficient balance left with him.
	 */
	public void signUpPassenger(Passenger passenger) {

		if (isAvailable()) {
			passenger.addActivity(this);
			--capacity;
		} else {
			System.out.println("Activity " + name + " is fully booked.");
		}
	}

	// Returns the discounted cost as per type of the passenger
	public double getDiscountedCost(Passenger passenger) {

		if (passenger instanceof GoldPassenger) {
			return cost * 0.9;
		}

		return cost;
	}

	/*
	 * Print the details of all the activities that still have spaces available,
	 * including how many spaces are available.
	 */
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

	// Every time Activity is instantiated, the instance is added to the list
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

	/*
	 * Instance of Activity is added to the list provided it's not a duplicate(Has
	 * the same name as that of an existing activity).
	 */
	public static void addActivity(Activity activity) {

		if (!activityNames.contains(activity.getName())) {
			activityNames.add(activity.getName());
			activities.add(activity);
		}
	}

	public static Set<Activity> getActivities() {
		return activities;
	}

	/* A new list of activities replaces the existing list of activities */
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
