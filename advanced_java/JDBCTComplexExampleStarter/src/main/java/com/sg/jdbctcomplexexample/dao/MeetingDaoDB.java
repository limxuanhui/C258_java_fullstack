package com.sg.jdbctcomplexexample.dao;
/* Created by limxuanhui on 7/7/22 */

import com.sg.jdbctcomplexexample.entity.Employee;
import com.sg.jdbctcomplexexample.entity.Meeting;
import com.sg.jdbctcomplexexample.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MeetingDaoDB implements MeetingDao {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Meeting> getAllMeetings() {
        return null;
    }

    @Override
    public Meeting getMeetingByid(int id) {
        try {
            final String SELECT_MEETING_BY_ID = "SELECT * FROM meeting WHERE id = ?";
            Meeting meeting = jdbc.queryForObject(SELECT_MEETING_BY_ID, new MeetingMapper(), id);
            meeting.setRoom(getRoomForMeeting(meeting));
            meeting.setAttendees(getEmployeesForMeeting(meeting));
            return meeting;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public Meeting addMeeting(Meeting meeting) {
        return null;
    }

    @Override
    public void updateMeeting(Meeting meeting) {

    }

    @Override
    public void deleteMeetingById(int id) {

    }

    @Override
    public List<Meeting> getMeetingsForRoom(Room room) {
        return null;
    }

    @Override
    public List<Meeting> getMeetingsForEmployee(Employee employee) {
        return null;
    }


    public static final class MeetingMapper implements RowMapper<Meeting> {

        @Override
        public Meeting mapRow(ResultSet resultSet, int i) throws SQLException {
            Meeting meet = new Meeting();
            meet.setId(resultSet.getInt("id"));
            meet.setName(resultSet.getString("name"));
            meet.setTime(resultSet.getTimestamp("time").toLocalDateTime());
            return meet;
        }
    }
}
