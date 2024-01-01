package com.systemdesign.travelagency;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PassengerTests {

	private Activity activity;

	@Before
	public void setUp() {
		activity = new Activity("Activity", "Description", 100, 5);
	}

	@Test
	public void fieldChecksForPassenger() {

		Passenger passenger = new Passenger("Niranjan", 100);

		Assert.assertEquals("Niranjan", passenger.getName());
		Assert.assertEquals(100, passenger.getPassengerNumber());

	}

	@Test
	public void addActivity_shouldAddActivityToBookedActivities() {
		Passenger passenger = new Passenger("Niranjan", 123);
		Activity activity = new Activity("Test Activity", "Test Desc", 50.0, 3);

		passenger.addActivity(activity);

		Assert.assertEquals(1, passenger.getBookedActivities().size());
		Assert.assertEquals("Test Activity", passenger.getBookedActivities().get(0).getName());
	}

	@Test
	public void signUpStandardPassenger_Successfull() {

		StandardPassenger standardPassenger = new StandardPassenger("Niranjan", 1, 100);
		standardPassenger.addActivity(activity);

		Assert.assertEquals(1, standardPassenger.getBookedActivities().size());
	}

	@Test
	public void signUpStandardPassenger_UnSuccessfull() {

		StandardPassenger standardPassenger = new StandardPassenger("Niranjan", 1, 90);
		standardPassenger.addActivity(activity);

		Assert.assertTrue(standardPassenger.getBookedActivities().isEmpty());
	}

	@Test
	public void signUpGoldPassenger_Successfull() {

		GoldPassenger goldPassenger = new GoldPassenger("Niranjan", 1, 90);
		goldPassenger.addActivity(activity);

		Assert.assertEquals(1, goldPassenger.getBookedActivities().size());
	}

	@Test
	public void signUpGoldPassenger_UnSuccessfull() {

		GoldPassenger goldPassenger = new GoldPassenger("Niranjan", 1, 80);
		goldPassenger.addActivity(activity);

		Assert.assertTrue(goldPassenger.getBookedActivities().isEmpty());
	}

	@Test
	public void signUpPremiumPassenger_Successfull() {

		PremiumPassenger premiumPassenger = new PremiumPassenger("Niranjan", 100);
		premiumPassenger.addActivity(activity);

		Assert.assertEquals(1, premiumPassenger.getBookedActivities().size());
	}

}
