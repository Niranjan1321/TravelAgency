package com.systemdesign.travelagency;

import java.util.ArrayList;
import java.util.List;

public class Destination {

	private String name;
	private List<Activity> activities;

	/*
	 * As per the specification of the system design, each destination comes with a
	 * name and a list of activities associates with it, hence I assume we cannot
	 * create a destination without activities
	 */
	// Implicitly setting the destination of the activities
	public Destination(String name, List<Activity> activities) {
		super();
		this.name = name;
		this.activities = activities;

		for (Activity activity : activities) {
			activity.setDestination(this);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	/*
	 * An Explicit method to add to the existing activities of a Destination and
	 * setting the destination of the activities
	 */
	public void addActivityToTheDestination(Activity activity) {

		List<Activity> newActivities = new ArrayList<>(this.getActivities());
		newActivities.add(activity);
		this.setActivities(newActivities);

		activity.setDestination(this);
	}

	@Override
	public String toString() {
		return "Destination [name=" + name + ", activities=" + activities + "]";
	}

}
