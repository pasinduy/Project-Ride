package lk.ijse.dto.Tm;

import lombok.*;

import java.awt.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationTm {
    private String trainId;
    private String type;
    private int noOfSeats;
    private double ticketPrice;
    private double tot;
    private Button btn;

}
