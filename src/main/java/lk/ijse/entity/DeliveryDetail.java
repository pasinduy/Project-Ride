package lk.ijse.entity;

public class DeliveryDetail {
    private String deliveryId;
    private String trainId;
    private int weight;
    private double price;

    public DeliveryDetail() {
    }

    public DeliveryDetail(String deliveryId, String trainId, int weight, double price) {
        this.deliveryId = deliveryId;
        this.trainId = trainId;
        this.weight = weight;
        this.price = price;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DeliveryDetail{" +
                "deliveryId='" + deliveryId + '\'' +
                ", trainId='" + trainId + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
