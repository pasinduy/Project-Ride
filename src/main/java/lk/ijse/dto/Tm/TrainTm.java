package lk.ijse.dto.Tm;

import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainTm {
    private String trainId;
    private String type;
    private String noOfSeats;
    private String status;
}
