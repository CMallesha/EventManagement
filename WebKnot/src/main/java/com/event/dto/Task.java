package com.event.dto;

import java.sql.Date;

public class Task {
	private int id;
    private String name;
    private Date deadline;
    private String status; // Pending or Completed
    private int attendee_id;
    private int event_id;

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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public int getAttendee_id() {
		return attendee_id;
	}

	public void setAttendee_id(int attendee_id) {
		this.attendee_id = attendee_id;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

 
}
