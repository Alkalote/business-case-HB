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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Column(nullable = false)
    private LocalDateTime birthedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private String activationCode;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "userFrom")
    private List<UserReview> reviewsWritten = new ArrayList<>();

    @OneToMany(mappedBy = "userTo")
    private List<UserReview> reviewsReceived = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "owner")
    private List<Localisation> localisations = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserLocalisation> userLocalisations = new ArrayList<>();
}