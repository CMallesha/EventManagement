package com.event.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.event.connector.ConnectionFactory;
import com.event.dto.Event;

public class EventDAOImpl implements EventDAO {
    
    private Connection con;
    
    public EventDAOImpl() {
        this.con = ConnectionFactory.requestConnection();
    }

    @Override
    public boolean createEvent(Event e) {
        String sql = "INSERT INTO events (name, description, location, date) VALUES (?, ?, ?, SYSDATE())";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, e.getName());
            pstmt.setString(2, e.getDescription());
            pstmt.setString(3, e.getLocation());
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Event event = new Event();
                event.setId(rs.getInt("id"));
                event.setName(rs.getString("name"));
                event.setDescription(rs.getString("description"));
                event.setLocation(rs.getString("location"));
                event.setDate(rs.getDate("date"));
                events.add(event);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return events;
    }

    @Override
    public boolean updateEvent(Event event) {
        String sql = "UPDATE events SET name = ?, description = ?, location = ?, date = SYSDATE(), WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getDescription());
            pstmt.setString(3, event.getLocation());

            pstmt.setInt(5, event.getId());
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEvent(int eventId) {
        String sql = "DELETE FROM events WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
