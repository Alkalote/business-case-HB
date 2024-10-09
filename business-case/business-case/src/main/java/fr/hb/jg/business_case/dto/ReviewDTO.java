package fr.hb.jg.business_case.dto;

import fr.hb.jg.business_case.entity.ChargingStation;
import fr.hb.jg.business_case.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewDTO {

    private Float rating;

    @NotBlank
    private String chargingStationId;

    @NotBlank
    private String userId;

    @NotBlank
    private String content;
}