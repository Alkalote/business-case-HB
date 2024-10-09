package fr.hb.jg.business_case.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {

    @NotBlank
    private String finishedAt;

    @NotBlank
    private String startedAt;

    @NotNull
    private Long userLocalisationId;

    @NotBlank
    private String chargingStationId;

    @NotBlank
    private String userId;

}