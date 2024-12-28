package com.event.dao;

import java.util.List;

import com.event.dto.Task;

public interface TaskDAO {
	
    // Method to create a task
    public boolean CreateTask(Task t);

    // Method to get tasks for a specific event
    public List GetTasksForEvent(int eventId);

    // Method to update task status
    public boolean UpdateTaskStatus(int taskId);

}
