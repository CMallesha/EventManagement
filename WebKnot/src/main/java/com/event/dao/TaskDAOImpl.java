package com.event.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.event.connector.ConnectionFactory;
import com.event.dto.Task;

public class TaskDAOImpl implements TaskDAO {
    private Connection con;

    public TaskDAOImpl() {
        this.con = ConnectionFactory.requestConnection();
    }

    @Override
    public boolean CreateTask(Task t) {
        String query = "INSERT INTO tasks (name, deadline, status, attendee_id, event_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, t.getName());
            pstmt.setDate(2, t.getDeadline());
            pstmt.setString(3, t.getStatus());
            pstmt.setInt(4, t.getAttendee_id());
            pstmt.setInt(5, t.getEvent_id());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Task> GetTasksForEvent(int eventId) {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks WHERE event_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, eventId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Task task = new Task();
                    task.setId(rs.getInt("id"));
                    task.setName(rs.getString("name"));
                    task.setDeadline(rs.getDate("deadline"));
                    task.setStatus(rs.getString("status"));
                    task.setAttendee_id(rs.getInt("attendee_id"));
                    task.setEvent_id(rs.getInt("event_id"));
                    tasks.add(task);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public boolean UpdateTaskStatus(int taskId) {
        String query = "UPDATE tasks SET status = 'Completed' WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, taskId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
