package fr.hb.jg.business_case.controller_api;

import fr.hb.jg.business_case.dto.UserReviewDTO;
import fr.hb.jg.business_case.entity.UserReview;
import fr.hb.jg.business_case.jsonview.JsonViews;
import fr.hb.jg.business_case.service.UserReviewService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/userreview")
public class UserReviewRestController {

    private UserReviewService Service;

    @GetMapping
    @JsonView(JsonViews.UserReviewMinimalView.class)
    public List<UserReview> list() {
        return Service.list();
    }

    @PostMapping
    public UserReview create(@Valid @RequestBody UserReviewDTO dto) {
        return Service.create(dto);
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.UserReviewShow.class)
    public UserReview show(@PathVariable Long id) {
        return Service.findOneById(id);
    }

    @PutMapping("/{id}")
    public UserReview update(@Valid @RequestBody UserReviewDTO dto, @PathVariable Long id) {
        return Service.update(dto, id);
    }


}