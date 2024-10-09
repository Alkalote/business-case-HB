package fr.hb.jg.business_case.entity;
import fr.hb.jg.business_case.entity.enumerations.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime finishedAt;

    @Column(nullable = false)
    private LocalDateTime startedAt;

    @ManyToOne
    private UserLocalisation userLocalisation;

    @ManyToOne
    private ChargingStation chargingStation;

    @Column(nullable = false)
    private Status status;

    @ManyToOne
    private User user;

}