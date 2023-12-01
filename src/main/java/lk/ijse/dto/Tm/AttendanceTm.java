package lk.ijse.dto.Tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceTm {
    private String attendanceId;
    private String empId;
    private String month;
    private String date;
    private String status;
}
