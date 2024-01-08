package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AttendanceDto;
import lk.ijse.dto.PayrollDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PayrollBO extends SuperBO {
    ArrayList<PayrollDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(PayrollDto dto) throws SQLException, ClassNotFoundException;
    boolean update(PayrollDto dto) throws SQLException, ClassNotFoundException;
    boolean delete(PayrollDto dto) throws SQLException, ClassNotFoundException;
    boolean existRecord(String id) throws SQLException, ClassNotFoundException;
    String generateNewId() throws SQLException, ClassNotFoundException;
}
