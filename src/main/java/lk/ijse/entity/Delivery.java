package lk.ijse.entity;

import java.time.LocalDate;

public class Delivery {
    private String deliveryId;
    private String passengerId;
    private LocalDate date;

    public Delivery(){
    }
    public Delivery(String deliveryId, String passengerId, LocalDate date) {
        this.deliveryId = deliveryId;
        this.passengerId = passengerId;
        this.date = date;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
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
        return "Delivery{" +
                "deliveryId='" + deliveryId + '\'' +
                ", passengerId='" + passengerId + '\'' +
                ", date=" + date +
                '}';
    }
}
