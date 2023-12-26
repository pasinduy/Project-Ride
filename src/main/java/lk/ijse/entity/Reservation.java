package lk.ijse.entity;

import java.time.LocalDate;

public class Reservation {
    private String reservationId;
    private String passengerId;
    private LocalDate date;

    public Reservation() {
    }

    public Reservation(String reservationId, String passengerId, LocalDate date) {
        this.reservationId = reservationId;
        this.passengerId = passengerId;
        this.date = date;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", passengerId='" + passengerId + '\'' +
                ", date=" + date +
                '}';
    }
}
