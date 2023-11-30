package lk.ijse.model;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.ReservationDto;

import java.sql.*;
import java.time.LocalDate;

public class ReservationModel {

    public static String generateNextOrderId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT reservationId FROM reservation ORDER BY reservationId DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    private static String splitOrderId(String currentReservationId) {
        if(currentReservationId != null) {
            String[] split = currentReservationId.split("O0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "O00" + id;
        } else {
            return "O001";
        }
    }

    public static boolean saveOrder(String reservationId, String passengerId, LocalDate date) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO reservation VALUES(?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, reservationId);
        pstm.setString(2, passengerId);
        pstm.setDate(3, Date.valueOf(date));

        return pstm.executeUpdate() > 0;
    }
}
