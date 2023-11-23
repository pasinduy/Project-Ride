package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {
    private String scheduleId;
    private String trainId;
    private String departure;
    private String arrival;
    private String departureTime;
    private String arrivalTime;
}
