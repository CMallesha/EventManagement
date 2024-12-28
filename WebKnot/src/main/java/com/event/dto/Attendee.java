package com.event.dto;

public class Attendee {
	private int id;
    private String name;
    private String email;
    private int event_id;

    public int getEventId() {
		return event_id;
	}

	public void setEventId(int event_id) {
		this.event_id = event_id;
	}

	// Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
