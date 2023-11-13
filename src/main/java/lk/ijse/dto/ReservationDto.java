package lk.ijse.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationDto {
    String id;
    String passengerId;
    String trainId;
}
