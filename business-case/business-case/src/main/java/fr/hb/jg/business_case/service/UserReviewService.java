package fr.hb.jg.business_case.service;

import fr.hb.jg.business_case.dto.UserReviewDTO;
import fr.hb.jg.business_case.entity.UserReview;
import fr.hb.jg.business_case.exception.UpgradedEntityNotFoundException;
import fr.hb.jg.business_case.repository.UserReviewRepository;
import fr.hb.jg.business_case.service.interfaces.ServiceListInterfaceCR;
import fr.hb.jg.business_case.service.interfaces.ServiceListInterfaceCRU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class UserReviewService implements ServiceListInterfaceCRU<UserReview, Long, UserReviewDTO,UserReviewDTO> {

    private UserReviewRepository repository;
    private UserService userService;

    @Override
    public List<UserReview> list() {
        return repository.findAll();
    }

    @Override
    public UserReview create(UserReviewDTO o) {

        UserReview userReview = new UserReview();
        userReview.setCreatedAt(LocalDateTime.now());
        userReview.setUserTo(userService.findOneById(o.getUserTo()));
        userReview.setUserFrom(userService.findOneById(o.getUserFrom()));
        userReview.setContent(o.getContent());
        userReview.setRating(o.getRating());

        return userReview;
    }

    @Override
    public UserReview update(UserReviewDTO o, Long id) {

        UserReview userReview = findOneById(id);
        userReview.setUpdatedAt(LocalDateTime.now());
        userReview.setUserTo(userService.findOneById(o.getUserTo()));
        userReview.setUserFrom(userService.findOneById(o.getUserFrom()));
        userReview.setContent(o.getContent());
        userReview.setRating(o.getRating());

        return userReview;
    }

    @Override
    public UserReview findOneById(Long id) {
        return repository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }


}