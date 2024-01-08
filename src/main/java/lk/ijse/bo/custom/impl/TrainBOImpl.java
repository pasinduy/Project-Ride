package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.TrainBO;
import lk.ijse.dto.TrainDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrainBOImpl implements TrainBO {
    @Override
    public ArrayList<TrainDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(TrainDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(TrainDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(TrainDto dto) throws SQLException, ClassNotFoundException {
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
