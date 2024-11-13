package fr.hb.jg.business_case.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {

    @NotBlank
    private LocalDateTime finishedAt;

    @NotBlank
    private LocalDateTime startedAt;

    @NotNull
    private Long userLocalisationId;

    @NotBlank
    private String chargingStationId;

    @NotBlank
    private String userId;

}