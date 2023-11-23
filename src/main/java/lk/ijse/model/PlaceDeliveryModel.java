package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.DeliveryDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class PlaceDeliveryModel {
    private DeliveryModel deliveryModel = new DeliveryModel();
    private static TrainModel trainModel = new TrainModel();
    private DeliveryDetailModel deliveryDetailModel = new DeliveryDetailModel();
    public static boolean placeDelivery(DeliveryDto placeDeliveryDto) throws SQLException, ClassNotFoundException {
        String deliveryId = placeDeliveryDto.getDeliveryId();
        String passengerId = placeDeliveryDto.getPassengerId();

        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isDeliverySaved = DeliveryModel.saveOrder(deliveryId, passengerId);
            if (isDeliverySaved){
                boolean isUpdated = trainModel.updatesTrains(placeDeliveryDto.getDeliveryTmList());
                if (isUpdated){
                    boolean isDeliveryDetailSaved = DeliveryDetailModel.saveOrderDetails(placeDeliveryDto.getDeliveryTmList(), deliveryId);
                    if (isDeliveryDetailSaved){
                        connection.commit();
                    }
                }
            }
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
        return true;
    }
}
