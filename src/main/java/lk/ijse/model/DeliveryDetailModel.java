package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.Tm.DeliveryTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeliveryDetailModel {
    public static boolean saveOrderDetails(List<DeliveryTm> deliveryTmList, String deliveryId) throws SQLException {
        for (DeliveryTm tm : deliveryTmList) {
            if (!saveOrderDetails(deliveryId, tm)) {
                return false;
            }
        }
        return true;
    }

    private static boolean saveOrderDetails(String deliveryId, DeliveryTm tm) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO delivery_details VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, deliveryId);
        pstm.setString(2, tm.getTrainId());
        pstm.setString(3, tm.getDate());
        pstm.setInt(4, Integer.parseInt(tm.getWeight()));

        return pstm.executeUpdate() > 0;
    }
    }
