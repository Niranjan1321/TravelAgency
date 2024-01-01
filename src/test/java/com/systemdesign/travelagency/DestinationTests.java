package com.systemdesign.travelagency;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DestinationTests {

	private Destination destination;
	private Destination destination2;
	private Activity activity1;
	private Activity activity2;
	private Activity activity3;
	private Activity activity4;
	private Activity activity5;

	@Before
	public void setUp() {

		activity1 = new Activity("Activity 1", "Description 1", 100, 10);
		activity2 = new Activity("Activity 2", "Description 2", 200, 11);

		destination = new Destination("Destination1", List.of(activity1, activity2));
	}

	@Test
	public void destinationInitialization_withActivities() {
		Assert.assertEquals("Destination1", destination.getName());
		Assert.assertEquals(2, destination.getActivities().size());
	}

	@Test
	public void setName_shouldSetDestinationName() {
		destination.setName("New Destination");
		Assert.assertEquals("New Destination", destination.getName().toString());
	}

	@Test
	public void setActivities_shouldSetNewActivities() {
		List<Activity> newActivities = List.of(new Activity("New Activity", "New Description", 300, 12));

		destination.setActivities(newActivities);
		Assert.assertEquals(1, destination.getActivities().size());
		Assert.assertEquals("New Activity", destination.getActivities().get(0).getName());

	}

	@Test
	public void creatingADestination_shouldSetDestinationInActivities() {
		activity3 = new Activity("Activity 3", "Description 3", 50.0, 3);
		activity4 = new Activity("Activity 4", "Description 4", 50.0, 3);

		destination2 = new Destination("Destination2", List.of(activity3, activity4));
		Assert.assertEquals(2, destination2.getActivities().size());

		Assert.assertEquals("Destination2", activity3.getDestination().getName());
		Assert.assertEquals("Destination2", activity4.getDestination().getName());

	}

	@Test
	public void addActivityToTheExistingActivitiesOfDestination() {

		Destination destination3 = new Destination("Destination2",
				List.of(new Activity("Sample Activity", "Sample Description", 100, 100)));

		Assert.assertEquals(1, destination3.getActivities().size());

		activity5 = new Activity("Activity 5", "Description 5", 20.0, 4);

		destination3.addActivityToTheDestination(activity5);
		Assert.assertEquals(2, destination.getActivities().size());
		Assert.assertEquals("Destination2", activity5.getDestination().getName());
	}

}
