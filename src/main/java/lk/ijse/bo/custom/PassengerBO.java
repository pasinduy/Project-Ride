package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AttendanceDto;
import lk.ijse.dto.PassengerDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PassengerBO extends SuperBO {
    ArrayList<PassengerDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(PassengerDto dto) throws SQLException, ClassNotFoundException;
    boolean update(PassengerDto dto) throws SQLException, ClassNotFoundException;
    boolean delete(PassengerDto dto) throws SQLException, ClassNotFoundException;
    boolean existRecord(String id) throws SQLException, ClassNotFoundException;
    String generateNewId() throws SQLException, ClassNotFoundException;
}
