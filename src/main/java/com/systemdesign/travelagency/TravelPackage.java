package com.systemdesign.travelagency;

import java.util.List;

public class TravelPackage {

	private String name;
	private int passengerCapacity;
	private List<Destination> itinerary;
	private List<Passenger> passengers;

	public TravelPackage() {

	}

	public TravelPackage(String name, int passengerCapacity, List<Destination> itinerary, List<Passenger> passengers) {
		super();
		this.name = name;
		this.passengerCapacity = passengerCapacity;
		this.itinerary = itinerary;
		this.passengers = passengers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public List<Destination> getItinerary() {
		return itinerary;
	}

	public void setItinerary(List<Destination> itinerary) {
		this.itinerary = itinerary;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "TravelPackage [name=" + name + ", passengerCapacity=" + passengerCapacity + ", itinerary=" + itinerary
				+ ", passengers=" + passengers + "]";
	}

	/*
	 * 1. Print itinerary of the travel package including: a. travel package name,
	 * b. destinations and details of the activities available at each destination,
	 * like name, cost, capacity and description.
	 */
	public void Itinerary() {

		System.out.println("Travel Package name is " + name);

		for (Destination destination : itinerary) {

			System.out.println("Destination is " + destination.getName());

			System.out.println("Activities associated with the destination " + destination.getName() + " are below , ");

			int counter = 1;

			for (Activity activity : destination.getActivities()) {

				System.out.println(counter++ + ". Activity name is " + activity.getName() + "," + " cost : "
						+ activity.getCost() + "," + " capacity : " + activity.getCapacity() + "," + " description : "
						+ activity.getDescription());

			}

		}

	}

	/*
	 * 2. Print the passenger list of the travel package including: a. package name,
	 * b. passenger capacity, c. number of passengers currently enrolled and d. name
	 * and number of each passenger
	 */
	public void passengerList() {

		System.out.println("Travel Package name is " + name + ", passenger capacity is " + passengerCapacity
				+ " and number of passengers enrolled are " + passengers.size());

		for (Passenger passenger : passengers) {

			System.out.println("Passenger name is " + passenger.getName() + " and the passenger number is "
					+ passenger.getPassengerNumber());

		}

	}

	/*
	 * 3. Print the details of an individual passenger including their 1. name, 2.
	 * passenger number, 3. balance (if applicable), 4. list of each activity they
	 * have signed up for, including the destination the at which the activity is
	 * taking place and the price the passenger paid for the activity.
	 */
	public void detailsOfPassenger(Passenger passenger) {

		System.out.println("Passenger name is " + passenger.getName() + " and the passenger number is "
				+ passenger.getPassengerNumber());

		if (passenger instanceof StandardPassenger) {
			StandardPassenger standardPassenger = (StandardPassenger) passenger;
			System.out.println(
					"Balance associated with " + passenger.getName() + " is " + standardPassenger.getBalance());
		}

		if (passenger instanceof GoldPassenger) {
			GoldPassenger goldPassenger = (GoldPassenger) passenger;
			System.out.println("Balance associated with " + passenger.getName() + " is " + goldPassenger.getBalance());
		}

		if (passenger.getBookedActivities().size() > 0) {

			System.out
					.println("The details of the activities booked by the passenger " + passenger.getName() + " are,");

			int counter = 1;

			for (Activity activity : passenger.getBookedActivities()) {

				System.out.print(counter++ + ". Activity name is " + activity.getName() + ", " + "taking place at "
						+ activity.getDestination().getName());

				if (!(passenger instanceof PremiumPassenger)) {

					System.out.println(" and price paid is " + activity.getCost());
				}
			}

		}

	}

}
