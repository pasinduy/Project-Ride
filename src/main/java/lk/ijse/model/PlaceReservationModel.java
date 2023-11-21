package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.ReservationDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class PlaceReservationModel {
    private ReservationModel reservationModel = new ReservationModel();
    private TrainModel trainModel = new TrainModel();
    private ReservationDetailModel reservationDetailModel = new ReservationDetailModel();


    public boolean placeReservation(ReservationDto placeReservationDto) throws SQLException, ClassNotFoundException {
        String reservationId = placeReservationDto.getReservationId();
        LocalDate orderDate = placeReservationDto.getOrderDate();
        String passengerId = placeReservationDto.getPassengerId();

        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isReservationSaved = ReservationModel.saveOrder(reservationId, passengerId, orderDate);
            if (isReservationSaved){
                boolean isUpdated = trainModel.updateTrains(placeReservationDto.getReservationTmList());
                if (isUpdated){
                    boolean isReservationDetailSaved = reservationDetailModel.saveOrderDetails(placeReservationDto.getReservationTmList(), reservationId);
                    if (isReservationDetailSaved){
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
