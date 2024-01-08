package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PayrollBO;
import lk.ijse.dto.PayrollDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class PayrollBOImpl implements PayrollBO {
    @Override
    public ArrayList<PayrollDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(PayrollDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(PayrollDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(PayrollDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existRecord(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
