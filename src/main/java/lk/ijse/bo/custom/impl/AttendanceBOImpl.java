package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.AttendanceBO;
import lk.ijse.dao.custom.AttendanceDAO;
import lk.ijse.dto.AttendanceDto;
import lk.ijse.entity.Attendance;
import lk.ijse.factory.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceBOImpl implements AttendanceBO {
    AttendanceDAO dao = (AttendanceDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ATTENDANCE);
    @Override
    public ArrayList<AttendanceDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<AttendanceDto> dtos = new ArrayList<>();
        ArrayList<Attendance> attendances = dao.getAll();
        for (Attendance attendance : attendances){
            dtos.add(
                    new AttendanceDto(attendance.getAttId(), attendance.getEmpId(), attendance.getMonth(), attendance.getDate(), attendance.getStatus())
            );
        }
        return dtos;
    }
}
