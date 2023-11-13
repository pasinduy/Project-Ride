package lk.ijse.dto.Tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationTm {
    private String id;
    private String passengerId;
    private String trainId;
}
