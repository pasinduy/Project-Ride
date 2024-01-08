package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ScheduleBO;
import lk.ijse.dto.ScheduleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleBOImpl implements ScheduleBO {
    @Override
    public ArrayList<ScheduleDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(ScheduleDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ScheduleDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(ScheduleDto dto) throws SQLException, ClassNotFoundException {
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
