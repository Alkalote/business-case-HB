package fr.hb.jg.business_case.dto;

import fr.hb.jg.business_case.entity.Localisation;
import fr.hb.jg.business_case.entity.User;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLocalisationDTO {

    @NotNull
    private Boolean isBilling;

    @NotNull
    private Long localisationId;

    @NotBlank
    private String userId;

}