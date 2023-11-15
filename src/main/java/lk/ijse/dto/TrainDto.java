package lk.ijse.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrainDto {
    private String trainId;
    private String type;
    private String noOfSeats;
    private String status;
    private String ticketPrice;
}