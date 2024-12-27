package com.event.dto;

import java.sql.Date;

public class Task {
	private int id;
    private String name;
    private Date deadline;
    private String status; // Pending or Completed
    private Attendee assignedAttendee;

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

    public Attendee getAssignedAttendee() {
        return assignedAttendee;
    }

    public void setAssignedAttendee(Attendee assignedAttendee) {
        this.assignedAttendee = assignedAttendee;
    }
}
