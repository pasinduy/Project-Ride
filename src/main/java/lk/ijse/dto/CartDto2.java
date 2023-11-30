package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto2 {
    private String deliveryId;
    private String trainId;
    private double weight;
    private double price;
}
