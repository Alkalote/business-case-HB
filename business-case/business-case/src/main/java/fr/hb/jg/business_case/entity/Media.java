package fr.hb.jg.business_case.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @ManyToOne
    private ChargingStation chargingStation;

    @Column(nullable = false)
    private String extension;

    @Column(nullable = false)
    private String name;

}