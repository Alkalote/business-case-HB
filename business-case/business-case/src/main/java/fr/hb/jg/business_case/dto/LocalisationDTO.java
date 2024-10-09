package fr.hb.jg.business_case.dto;

import fr.hb.jg.business_case.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocalisationDTO {

    @NotBlank
    private String city;

    @NotBlank
    private String latitude;

    @NotBlank
    private String longitude;

    @NotBlank
    private String ownerId;

    @NotBlank
    private String streetName;

    @NotBlank
    private String streetNumber;

    @NotBlank
    private String zipcode;


}