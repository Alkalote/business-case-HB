package fr.hb.jg.business_case.entity;
import fr.hb.jg.business_case.entity.embeddable.UserChargingStationId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Favorite {


    @EmbeddedId
    private UserChargingStationId userChargingStationId;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "charging_station_id", insertable = false, updatable = false)
    private ChargingStation chargingStation;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

}