package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AttendanceDto;
import lk.ijse.dto.ScheduleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ScheduleBO extends SuperBO {
    ArrayList<ScheduleDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(ScheduleDto dto) throws SQLException, ClassNotFoundException;
    boolean update(ScheduleDto dto) throws SQLException, ClassNotFoundException;
    boolean delete(ScheduleDto dto) throws SQLException, ClassNotFoundException;
    boolean existRecord(String id) throws SQLException, ClassNotFoundException;
    String generateNewId() throws SQLException, ClassNotFoundException;
}
