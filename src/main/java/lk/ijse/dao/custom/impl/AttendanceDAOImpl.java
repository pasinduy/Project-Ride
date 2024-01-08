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
        return CrudUtil.execute("INSERT INTO attendance (attId, empId, month, date, status) VALUES(?,?,?,?,?)",attendanceDto.getAttendanceId(), attendanceDto.getEmpId(), attendanceDto.getMonth(), attendanceDto.getDate(), attendanceDto.getStatus());
    }

    @Override
    public boolean update(AttendanceDto attendanceDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE INTO attendance (attId, empId, month, date, status) VALUES(?,?,?,?,?)",attendanceDto.getAttendanceId(), attendanceDto.getEmpId(), attendanceDto.getMonth(), attendanceDto.getDate(), attendanceDto.getStatus());
    }

    @Override
    public boolean delete(AttendanceDto attendanceDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM attendance WHERE attId = ?", attendanceDto.getAttendanceId());
    }

    @Override
    public boolean existRecord(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT attId FROM attendance WHERE attId=?", id);
        return resultSet.next();
    }

    @Override
    public ArrayList<String> load() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT * FROM attendance");
        ArrayList<String> list = new ArrayList<>();
        while (set.next()){
            list.add(
                    set.getString(1)
            );
        }
        return list;
    }

    @Override
    public Attendance search(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT * FROM attendance WHERE attId = ?",id+" ");
        set.next();
        Attendance attendance = new Attendance(id + "", set.getString("empId"), set.getString("month"), set.getString("date"), set.getString("status"));
        return attendance;
    }

    @Override
    public String getNextID() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT attId FROM attendance ORDER BY attId DESC LIMIT 1");
        if (set.next()) {
            String id = set.getString(1);
            int newAttendanceId = Integer.parseInt(id.replace("A00", "")) + 1;
            return String.format("A%03d", newAttendanceId);
        } else {
            return "A001";
        }
    }
}
