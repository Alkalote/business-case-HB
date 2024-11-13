package fr.hb.jg.business_case.entity;
import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.jg.business_case.jsonview.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Power {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonView(JsonViews.ChargingStationMinimalView.class)
    private Float value;
}