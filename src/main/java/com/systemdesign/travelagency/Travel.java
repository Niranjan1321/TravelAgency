package com.systemdesign.travelagency;

import java.util.List;

public class Travel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Activity activity1 = new Activity("Scuba Diving", "Diving into the depth of Sea", 25.5, 100);
		Activity activity2 = new Activity("Trekking", "Climbing up the mountain", 25, 2);
		Activity activity3 = new Activity("Snorkling", "Rolling down in the ballon on water", 25, 100);

		Destination destination = new Destination("Murudeshwara", List.of(activity1, activity2));
		
		destination.addActivityToTheDestination(activity3);
		
		System.out.println(activity1.getDestination().getName());
		System.out.println(activity3.getDestination().getName());
//		destination.addActivityToTheDestination(activity3);
//		
//		System.out.println(activity1);
//		
//		System.out.println(destination);
//
//		StandardPassenger passenger = new StandardPassenger("Nira", 12, 100);
//		GoldPassenger passenger2 = new GoldPassenger("Dam", 100, 100);
//
//		activity1.signUpPassenger(passenger);
//		activity2.signUpPassenger(passenger2);
//		activity2.signUpPassenger(passenger);
//		
//		//System.out.println(passenger);
//
//		TravelPackage package1 = new TravelPackage("Sample", 2, List.of(destination), List.of(passenger, passenger2));
//
//		package1.Itinerary();
//
		//package1.passengerList();
//
		//package1.detailsOfPassenger(passenger);

//		Activity activity = new Activity();
//		activity.activityDetails();
		
		//System.out.println(package1);

	}

}
