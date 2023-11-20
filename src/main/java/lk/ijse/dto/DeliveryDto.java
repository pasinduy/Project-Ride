package lk.ijse.dto;

import lk.ijse.dto.Tm.DeliveryTm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDto {
    private String deliveryId;
    private String passengerId;
    private List<DeliveryTm> deliveryTmList = new ArrayList<>();
}
