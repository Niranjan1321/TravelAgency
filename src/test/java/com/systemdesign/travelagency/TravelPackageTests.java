package com.systemdesign.travelagency;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TravelPackageTests {

	private Activity activity;

	@Before
	public void setUp() {

		activity = new Activity("Scuba Diving", "Diving into the depth of Sea", 100, 100);

	}

	@Test
	public void Itinerary_shouldPrintCorrectDetailsForEmptyItinerary() {

		List<Destination> itinerary = new ArrayList<>();
		List<Passenger> passengers = new ArrayList<>();

		TravelPackage travelPackage = new TravelPackage("Empty Package", 5, itinerary, passengers);

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteArrayOutputStream));

		travelPackage.Itinerary();

		Assert.assertEquals("Travel Package name is Empty Package\n".trim(), byteArrayOutputStream.toString().trim());
		System.setOut(System.out);

	}

	@Test
	public void Itinerary_shouldPrintCorrectDetailsForNonEmptyItinerary() {

		Destination destination = new Destination("Destination1", List.of(activity));

		List<Passenger> passengers = new ArrayList<>();

		TravelPackage travelPackage = new TravelPackage("Package1", 5, List.of(destination), passengers);

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteArrayOutputStream));

		travelPackage.Itinerary();

		String expectedOutput = "Travel Package name is Package1\n" + "Destination is Destination1\n"
				+ "Activities associated with the destination Destination1 are below ,\n"
				+ "1. Activity name is Scuba Diving, cost : 100.0, capacity : 100, description : Diving into the depth of Sea\n";

		Assert.assertEquals(expectedOutput.replaceAll("\\s+", " ").trim(),
				byteArrayOutputStream.toString().replaceAll("\\s+", " ").trim());
		System.setOut(System.out);

	}

	@Test
	public void passengerList_shouldPrintCorrectDetailsForEmptyPassengerList() {

		List<Destination> itinerary = new ArrayList<>();
		List<Passenger> passengers = new ArrayList<>();

		TravelPackage travelPackage = new TravelPackage("Package1", 5, itinerary, passengers);

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteArrayOutputStream));

		travelPackage.passengerList();

		Assert.assertEquals(
				"Travel Package name is Package1, passenger capacity is 5 and number of passengers enrolled are 0\n"
						.trim(),
				byteArrayOutputStream.toString().trim());
		System.setOut(System.out);

	}

	@Test
	public void passengerList_shouldPrintCorrectDetailsForNonEmptyPassengerList() {

		List<Destination> itinerary = new ArrayList<>();
		Passenger passenger = new Passenger("Niranjan", 123);

		TravelPackage travelPackage = new TravelPackage("Package1", 5, itinerary, List.of(passenger));

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteArrayOutputStream));

		travelPackage.passengerList();

		String expectedOutput = "Travel Package name is Package1, passenger capacity is 5 and number of passengers enrolled are 1\n"
				+ "Passenger name is Niranjan and the passenger number is 123\n";

		Assert.assertEquals(expectedOutput.replaceAll("\\s+", " ").trim(),
				byteArrayOutputStream.toString().replaceAll("\\s+", " ").trim());
		System.setOut(System.out); // Reset System.out
	}

	@Test
	public void detailsOfPassenger_shouldPrintCorrectDetailsForStandardPassenger() {

		StandardPassenger standardPassenger = new StandardPassenger("Niranjan", 100, 100);
		Activity activity = new Activity("Trekking", "Climbing up the mountain", 10, 100);

		Destination destination = new Destination("Chikmaglur", List.of(activity));

		TravelPackage travelPackage = new TravelPackage("Package1", 100, List.of(destination),
				List.of(standardPassenger));

		activity.signUpPassenger(standardPassenger);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		travelPackage.detailsOfPassenger(standardPassenger);

		String expectedOutput = "Passenger name is Niranjan and the passenger number is 100\n"
				+ "Balance associated with Niranjan is 90.0\n"
				+ "The details of the activities booked by the passenger Niranjan are,\n"
				+ "1. Activity name is Trekking, taking place at Chikmaglur and price paid is 10.0\n";

		Assert.assertEquals(expectedOutput.replaceAll("\\s+", " ").trim(),
				outputStream.toString().replaceAll("\\s+", " ").trim());
		System.setOut(System.out);
	}

	@Test
	public void detailsOfPassenger_shouldPrintCorrectDetailsForGoldPassenger() {

		GoldPassenger goldPassenger = new GoldPassenger("Niranjan", 100, 100);
		Activity activity = new Activity("Trekking", "Climbing up the mountain", 10, 100);

		Destination destination = new Destination("Chikmaglur", List.of(activity));

		TravelPackage travelPackage = new TravelPackage("Package1", 100, List.of(destination), List.of(goldPassenger));

		activity.signUpPassenger(goldPassenger);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		travelPackage.detailsOfPassenger(goldPassenger);

		String expectedOutput = "Passenger name is Niranjan and the passenger number is 100\n"
				+ "Balance associated with Niranjan is 91.0\n"
				+ "The details of the activities booked by the passenger Niranjan are,\n"
				+ "1. Activity name is Trekking, taking place at Chikmaglur and price paid is 10.0\n";

		Assert.assertEquals(expectedOutput.replaceAll("\\s+", " ").trim(),
				outputStream.toString().replaceAll("\\s+", " ").trim());
		System.setOut(System.out);
	}

	@Test
	public void detailsOfPassenger_shouldPrintCorrectDetailsForPremiumPassenger() {

		PremiumPassenger premiumPassenger = new PremiumPassenger("Niranjan", 100);
		Activity activity = new Activity("Trekking", "Climbing up the mountain", 10, 100);

		Destination destination = new Destination("Chikmaglur", List.of(activity));

		TravelPackage travelPackage = new TravelPackage("Package1", 100, List.of(destination),
				List.of(premiumPassenger));

		activity.signUpPassenger(premiumPassenger);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		travelPackage.detailsOfPassenger(premiumPassenger);

		String expectedOutput = "Passenger name is Niranjan and the passenger number is 100\n"
				+ "The details of the activities booked by the passenger Niranjan are,\n"
				+ "1. Activity name is Trekking, taking place at Chikmaglur\n";

		Assert.assertEquals(expectedOutput.replaceAll("\\s+", " ").trim(),
				outputStream.toString().replaceAll("\\s+", " ").trim());
		System.setOut(System.out);
	}

}
