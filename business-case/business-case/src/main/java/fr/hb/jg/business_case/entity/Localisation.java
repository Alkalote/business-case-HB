package fr.hb.jg.business_case.entity;
import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.jg.business_case.jsonview.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Localisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonView(JsonViews.ChargingStationMinimalView.class)
    private String city;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @ManyToOne
    private User owner;

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private String streetNumber;

    @Column(nullable = false)
    private String zipcode;

    @OneToMany(mappedBy = "localisation")
    private List<UserLocalisation> userLocalisations = new ArrayList<>();

    @OneToMany(mappedBy = "localisation")
    private List<ChargingStation> chargingStations = new ArrayList<>();



}