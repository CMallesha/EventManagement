package com.event.dao;

import java.util.List;

import com.event.dto.Attendee;

public interface AttendeeDAO {
	
    // Method to add an attendee
    public boolean AddAttendee(Attendee a);

    // Method to get all attendees
    public List GetAllAttendees();

    // Method to delete an attendee
    public boolean DeleteAttendee(int attendeeId);

}
