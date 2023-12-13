package lk.ijse.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PassengerDto {
    private String id;
    private String name;
    private String age;
    private String gender;
    private String address;
    private String contact;

    public PassengerDto(String string) {
        this.id = string;
    }

}
