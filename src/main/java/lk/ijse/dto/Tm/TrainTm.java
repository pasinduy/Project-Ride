package lk.ijse.dto.Tm;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TrainTm {
    private String trainId;
    private String type;
    private String noOfSeats;
    private String status;
    private String ticketPrice;
}
