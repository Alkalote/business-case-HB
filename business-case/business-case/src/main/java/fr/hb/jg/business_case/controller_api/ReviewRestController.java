package fr.hb.jg.business_case.controller_api;

import fr.hb.jg.business_case.dto.ReviewDTO;
import fr.hb.jg.business_case.entity.Review;
import fr.hb.jg.business_case.jsonview.JsonViews;
import fr.hb.jg.business_case.service.ReviewService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/review")
public class ReviewRestController {

    private ReviewService Service;

    @GetMapping
    @JsonView(JsonViews.ReviewMinimalView.class)
    public List<Review> list() {
        return Service.list();
    }

    @PostMapping
    public Review create(@Valid @RequestBody ReviewDTO dto) {
        return Service.create(dto);
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.ReviewShow.class)
    public Review show(@PathVariable Long id) {
        return Service.findOneById(id);
    }

    @PutMapping("/{id}")
    public Review update(@Valid @RequestBody ReviewDTO dto, @PathVariable Long id) {
        return Service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        Service.delete(id);
        return true;
    }

}