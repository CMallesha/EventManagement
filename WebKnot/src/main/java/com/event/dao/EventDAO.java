package com.event.dao;

import java.util.List;

import com.event.dto.Event;

public interface EventDAO {
	
	// Abstract method to create an event
    public boolean createEvent(Event e);

    // Abstract method to get all events
    List<Event> getAllEvents();

    // Abstract method to update an event
    public boolean updateEvent(Event event);

    // Abstract method to delete an event
    public boolean deleteEvent(int eventId);

}
