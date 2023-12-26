package lk.ijse.entity;

public class ReservationDetail {
    private String reservationId;
    private String trainId;
    private String noOfSeats;
    private double price;

    public ReservationDetail() {
    }
    public ReservationDetail(String reservationId, String trainId, String noOfSeats, double price) {
        this.reservationId = reservationId;
        this.trainId = trainId;
        this.noOfSeats = noOfSeats;
        this.price = price;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(String noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ReservationDetail{" +
                "reservationId='" + reservationId + '\'' +
                ", trainId='" + trainId + '\'' +
                ", noOfSeats='" + noOfSeats + '\'' +
                ", price=" + price +
                '}';
    }
}
