package fr.hb.jg.business_case.dto;

import fr.hb.jg.business_case.entity.ChargingStation;
import fr.hb.jg.business_case.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FavoriteDTO {

    @NotBlank
    private String chargingStationId;

    @NotBlank
    private String userId;


}