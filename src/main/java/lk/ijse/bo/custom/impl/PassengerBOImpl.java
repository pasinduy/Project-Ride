package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PassengerBO;
import lk.ijse.dto.PassengerDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class PassengerBOImpl implements PassengerBO {
    @Override
    public ArrayList<PassengerDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(PassengerDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(PassengerDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(PassengerDto dto) throws SQLException, ClassNotFoundException {
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
