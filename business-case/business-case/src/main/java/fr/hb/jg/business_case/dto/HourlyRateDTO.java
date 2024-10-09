package fr.hb.jg.business_case.dto;

import fr.hb.jg.business_case.entity.ChargingStation;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HourlyRateDTO {

    private Float minimalDuration;

    private Integer value;

    @NotBlank
    private String chargingStationId;


}