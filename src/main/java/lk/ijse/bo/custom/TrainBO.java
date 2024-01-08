package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AttendanceDto;
import lk.ijse.dto.TrainDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TrainBO extends SuperBO {
    ArrayList<TrainDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(TrainDto dto) throws SQLException, ClassNotFoundException;
    boolean update(TrainDto dto) throws SQLException, ClassNotFoundException;
    boolean delete(TrainDto dto) throws SQLException, ClassNotFoundException;
    boolean existRecord(String id) throws SQLException, ClassNotFoundException;
    String generateNewId() throws SQLException, ClassNotFoundException;
}
