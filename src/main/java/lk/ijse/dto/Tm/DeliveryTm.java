package lk.ijse.dto.Tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryTm {
    private String TrainId;
    private LocalDate date;
    private double weight;
    private double price;
    private String total;
    private Button btn;
}
