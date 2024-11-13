package fr.hb.jg.business_case.entity;
import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.jg.business_case.jsonview.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class ChargingStation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Column
    @JsonView(JsonViews.ChargingStationMinimalView.class)
    private Boolean onFoot;

    @Column
    private LocalDateTime createdAt;

    @ManyToOne
    @JsonView(JsonViews.ChargingStationMinimalView.class)
    private Localisation localisation;

    @ManyToOne
    @JsonView(JsonViews.ChargingStationMinimalView.class)
    private Power power;

    @Column
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    @JsonView(JsonViews.ChargingStationMinimalView.class)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String accessibleDirectives;

    @OneToMany(mappedBy = "chargingStation")
    private List<Favorite> favorites = new ArrayList<>();

    @OneToMany(mappedBy = "chargingStation")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "chargingStation")
    private List<Booking> bookings  = new ArrayList<>();

    @OneToMany(mappedBy = "chargingStation")
    private List<HourlyRate> hourlyRates = new ArrayList<>();

    @OneToMany(mappedBy = "chargingStation")
    private List<Media> medias = new ArrayList<>();

}