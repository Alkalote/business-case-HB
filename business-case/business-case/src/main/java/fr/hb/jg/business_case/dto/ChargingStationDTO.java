package fr.hb.jg.business_case.dto;

import fr.hb.jg.business_case.entity.Localisation;
import fr.hb.jg.business_case.entity.Power;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChargingStationDTO {

    @NotBlank
    private Boolean onFoot;

    @NotNull
    private Long localisationId;

    @NotNull
    private Long powerId;

    @NotBlank
    private String name;

    private String accessibleDirectives;

}