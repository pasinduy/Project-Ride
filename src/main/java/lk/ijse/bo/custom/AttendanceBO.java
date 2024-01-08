package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AttendanceDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AttendanceBO extends SuperBO {
    ArrayList<AttendanceDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(AttendanceDto dto) throws SQLException, ClassNotFoundException;
    boolean update(AttendanceDto dto) throws SQLException, ClassNotFoundException;
    boolean delete(AttendanceDto dto) throws SQLException, ClassNotFoundException;
    boolean existRecord(String id) throws SQLException, ClassNotFoundException;
    String generateNewId() throws SQLException, ClassNotFoundException;
}
