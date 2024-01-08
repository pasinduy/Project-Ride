package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBOImpl implements UserBO {
    @Override
    public ArrayList<UserDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(UserDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(UserDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(UserDto dto) throws SQLException, ClassNotFoundException {
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
