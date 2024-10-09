package fr.hb.jg.business_case.dto;

import fr.hb.jg.business_case.entity.User;
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
public class UserReviewDTO {

    private Float rating;

    @NotBlank
    private String content;

    @NotBlank
    private String userFrom;

    @NotBlank
    private String userTo;
}