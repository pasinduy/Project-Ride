package lk.ijse.dto;

import lk.ijse.dto.Tm.ReservationTm;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationDto {
    private String reservationId;
    private String passengerId;
    private LocalDate orderDate;
    private List<ReservationTm> reservationTmList = new ArrayList<>();
}
