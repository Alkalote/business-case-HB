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
public class MediaDTO {

    @NotBlank
    private String chargingStationId;

    @NotBlank
    private String extension;

    @NotBlank
    private String name;


}