package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.AttendanceDAO;
import lk.ijse.dto.AttendanceDto;
import lk.ijse.entity.Attendance;
import lk.ijse.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceDAOImpl implements AttendanceDAO {
    @Override
    public ArrayList<Attendance> getAll() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT * FROM attendance");

        ArrayList<Attendance> getAllAttendance = new ArrayList<>();

        while (set.next()){
            Attendance attendance = new Attendance(
                    set.getString("attId"),
                    set.getString("empId"),
                    set.getString("month"),
                    set.getString("date"),
                    set.getString("status")
            );
            getAllAttendance.add(attendance);
        }
        return getAllAttendance;
    }

    @Override
    public boolean save(AttendanceDto attendanceDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(AttendanceDto attendanceDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(AttendanceDto attendanceDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existRecord(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> load() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public AttendanceDto search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getNextID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
