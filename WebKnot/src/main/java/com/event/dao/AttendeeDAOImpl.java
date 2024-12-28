package com.event.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.event.connector.ConnectionFactory;
import com.event.dto.Attendee;

public class AttendeeDAOImpl implements AttendeeDAO {
    
    private Connection con;
    
    public AttendeeDAOImpl() {
        this.con = ConnectionFactory.requestConnection();
    }

    @Override
    public boolean AddAttendee(Attendee a) {
        String query = "INSERT INTO attendees (name, email, event_id) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, a.getName());
            pstmt.setString(2, a.getEmail());
            pstmt.setInt(3, a.getEventId());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Attendee> GetAllAttendees() {
        List<Attendee> attendees = new ArrayList<>();
        String query = "SELECT * FROM attendees";
        try (PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Attendee attendee = new Attendee();
                attendee.setId(rs.getInt("id"));
                attendee.setName(rs.getString("name"));
                attendee.setEmail(rs.getString("email"));
                attendee.setEventId(rs.getInt("event_id"));
                attendees.add(attendee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendees;
    }

    @Override
    public boolean DeleteAttendee(int attendeeId) {
        String query = "DELETE FROM attendees WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, attendeeId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
