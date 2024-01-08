package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AttendanceDto;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO extends SuperBO {
    ArrayList<UserDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(UserDto dto) throws SQLException, ClassNotFoundException;
    boolean update(UserDto dto) throws SQLException, ClassNotFoundException;
    boolean delete(UserDto dto) throws SQLException, ClassNotFoundException;
    boolean existRecord(String id) throws SQLException, ClassNotFoundException;
    String generateNewId() throws SQLException, ClassNotFoundException;
}
