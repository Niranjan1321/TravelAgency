package com.systemdesign.travelagency;

import java.util.ArrayList;
import java.util.List;

public class Destination {

	private String name;
	private List<Activity> activities;

	/*
	 * As per the specification of the software design, each destination comes with
	 * a name and a list of activities associated with it, hence the assumption we
	 * cannot create an instance of Destination without activities.
	 */
	/*
	 * Implicitly setting the destination of all the activities passed to the
	 * destination instantiation.
	 */
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
	 * An explicit method to add an activity to the existing activities of a
	 * destination and setting the destination of the added activity.
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
