package lk.ijse.dto;

import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {
    private String id;
    private String name;
    private String age;
    private String gender;
    private String address;
    private String contact;
}
