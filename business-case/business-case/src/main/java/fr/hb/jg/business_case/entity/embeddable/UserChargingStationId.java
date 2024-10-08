package fr.hb.jg.business_case.entity.embeddable;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserChargingStationId {

    @Column(name = "charging_station_id")
    private String chargingStationId;

    @Column(name = "user_id")
    private String userId;


}
