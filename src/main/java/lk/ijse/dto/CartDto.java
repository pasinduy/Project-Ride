package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private String trainId;
    private String type;
    private int noOfSeats;
    private double ticketPrice;
    private double total;
}
