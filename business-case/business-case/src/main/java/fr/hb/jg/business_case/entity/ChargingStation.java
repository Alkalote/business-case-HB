package fr.hb.jg.business_case.entity;
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
    private Boolean onFoot;

    @Column
    private LocalDateTime createdAt;

    @ManyToOne
    private Localisation localisation;

    @ManyToOne
    private Power power;

    @Column
    private LocalDateTime updatedAt;

    @Column(nullable = false)
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