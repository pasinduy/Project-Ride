package lk.ijse.model;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.ReservationDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservationModel {

    public boolean addReservation(ReservationDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO reservation VALUES(?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getPassengerId());
        pstm.setString(3, dto.getTrainId());

        return pstm.executeUpdate() > 0;
    }
}
