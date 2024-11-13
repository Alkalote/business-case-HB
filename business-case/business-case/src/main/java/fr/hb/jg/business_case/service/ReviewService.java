package fr.hb.jg.business_case.service;

import fr.hb.jg.business_case.dto.ReviewDTO;
import fr.hb.jg.business_case.entity.Review;
import fr.hb.jg.business_case.exception.UpgradedEntityNotFoundException;
import fr.hb.jg.business_case.repository.ReviewRepository;
import fr.hb.jg.business_case.service.interfaces.ServiceListInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class ReviewService implements ServiceListInterface<Review, Long, ReviewDTO, ReviewDTO> {

    private ReviewRepository repository;
    private UserService userService;
    private ChargingStationService chargingStationService;

    @Override
    public List<Review> list() {
        return repository.findAll();
    }

    @Override
    public Review create(ReviewDTO o) {

        Review review = new Review();

        review.setCreatedAt(LocalDateTime.now());
        review.setContent(o.getContent());
        review.setRating(o.getRating());
        review.setChargingStation(chargingStationService.findOneById(o.getChargingStationId()));
        review.setUser(userService.findOneById(o.getUserId()));

        return review;
    }

    @Override
    public Review update(ReviewDTO o, Long id) {
        Review review = findOneById(id);

        review.setUpdatedAt(LocalDateTime.now());
        review.setContent(o.getContent());
        review.setRating(o.getRating());
        review.setChargingStation(chargingStationService.findOneById(o.getChargingStationId()));
        review.setUser(userService.findOneById(o.getUserId()));

        return review;
    }

    @Override
    public Boolean delete(Long o) {
        try{
            repository.deleteById(o);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public Review findOneById(Long id) {
        return repository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }
}