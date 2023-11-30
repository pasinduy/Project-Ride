package lk.ijse.dto.Tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayrollTm {
    private String employeeId;
    private String salaryId;
    private String month;
    private String date;
    private String status;
    private String amount;
}
