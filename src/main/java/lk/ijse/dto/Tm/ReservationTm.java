package lk.ijse.dto.Tm;

import lombok.*;

import java.awt.*;
import javafx.scene.control.Button;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationTm {
    private String trainId;
    private String type;
    private String noOfSeats;
    private String ticketPrice;
    private String tot;
    private Button btn;
}
