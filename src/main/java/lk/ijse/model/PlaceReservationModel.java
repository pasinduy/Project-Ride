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

    public boolean placeReservation(ReservationDto reservationDto) throws SQLException {
        System.out.println(reservationDto);

        String reservationId = reservationDto.getReservationId();
        String passengerId = reservationDto.getPassengerId();
        LocalDate date = reservationDto.getOrderDate();

        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isReservationSaved = reservationModel.saveOrder(reservationId, passengerId, date);
            if (isReservationSaved) {
                boolean isUpdated = trainModel.updateTrains(reservationDto.getReservationTmList());
                if(isUpdated) {
                    boolean isReservationDetailSaved = reservationDetailModel.saveOrderDetails(reservationDto.getReservationId(), reservationDto.getReservationTmList());
                    if (isReservationDetailSaved) {
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
