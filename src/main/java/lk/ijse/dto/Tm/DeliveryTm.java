package lk.ijse.dto.Tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryTm {
    private String TrainId;
    private String date;
    private String weight;
    private String price;
    private String total;
    private Button btn;
}
