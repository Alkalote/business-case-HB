package fr.hb.jg.business_case.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class UserReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}