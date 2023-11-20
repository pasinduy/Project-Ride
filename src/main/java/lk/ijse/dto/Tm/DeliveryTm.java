package lk.ijse.dto.Tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryTm {
    private String TrainId;
    private String date;
    private String time;
    private String weight;
    private String price;
}
