package lk.ijse.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String empId;
    private String name;
    private String age;
    private String gender;
    private String address;
    private String contact;
}
