package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayrollDto {
    private String employeeId;
    private String salaryId;
    private String month;
    private String date;
    private String status;
    private String amount;
}
