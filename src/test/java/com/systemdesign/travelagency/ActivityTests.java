package com.systemdesign.travelagency;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActivityTests {

	private Activity activity;
	private Passenger passenger;
	private GoldPassenger goldPassenger;
	private StandardPassenger standardPassenger;

	@Before
	public void setUp() {

		activity = new Activity("Test Activity", "Test Description", 50.0, 3);
		passenger = new Passenger("Niranjan", 100);
		goldPassenger = new GoldPassenger("Gold DA", 101, 500);
		standardPassenger = new StandardPassenger("Standard DA", 102, 500);

	}

	@Test
	public void isAvailable_returnsTrueWhenCapacityIsGreaterThanZero() {

		Assert.assertTrue(activity.isAvailable());
	}

	@Test
	public void isAvailable_returnsFalseWhenCapacityIsZero() {

		activity.setCapacity(0);
		Assert.assertFalse(activity.isAvailable());
	}

	@Test
	public void signUpPassenger_shouldAddPassengerIfActivityIsAvailable() {

		activity.signUpPassenger(passenger);
		Assert.assertEquals(1, passenger.getBookedActivities().size());
		Assert.assertEquals(2, activity.getCapacity());
	}

	@Test
	public void signUpPassenger_shouldNotAddPassengerIfActivityIsFull() {

		activity.setCapacity(0);
		activity.signUpPassenger(passenger);
		Assert.assertEquals(0, passenger.getBookedActivities().size());
	}

	@Test
	public void getCost_returnsDiscountedCostForGoldPassenger() {

		double Cost = activity.getDiscountedCost(goldPassenger);
		Assert.assertEquals(45.0, Cost, 0.01);
	}

	@Test
	public void getCost_returnsDiscountCostForStandardPassenger() {

		double Cost = activity.getDiscountedCost(standardPassenger);
		Assert.assertEquals(50.0, Cost, 0.01);
	}

	@Test
	public void addActivity_shouldAddActivityToActivities() {

		Assert.assertEquals(1, Activity.getActivities().size());

		@SuppressWarnings("unused")
		Activity newActivity = new Activity("New Activity", "New Description", 105, 100);

		Assert.assertEquals(2, Activity.getActivities().size());

	}

	@Test
	public void activityDetails_getActivityDetails() {

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		Set<Activity> emptyActivities = new HashSet<Activity>();

		Activity.setActivities(emptyActivities);

		activity = new Activity("Test Activity", "Test Description", 50.0, 3);

		Activity.activityDetails();

		String expectedOutput = "Activities that have spaces available are, \n"
				+ "Activity Test Activity have 3 spaces left.\n";
		Assert.assertEquals(expectedOutput.replaceAll("\\s+", " ").trim(),
				outputStream.toString().replaceAll("\\s+", " ").trim());

		System.setOut(System.out);
	}

}
