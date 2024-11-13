package fr.hb.jg.business_case.controller_api;

import fr.hb.jg.business_case.dto.BookingDTO;
import fr.hb.jg.business_case.entity.Booking;
import fr.hb.jg.business_case.jsonview.JsonViews;
import fr.hb.jg.business_case.service.BookingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/")
public class BookingRestController {

    private BookingService Service;

    @GetMapping
    @JsonView(JsonViews.BookingMinimalView.class)
    public List<Booking> list() {
        return Service.list();
    }

    @PostMapping
    public Booking create(@Valid @RequestBody BookingDTO dto) {
        return Service.create(dto);
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.BookingShow.class)
    public Booking show(@PathVariable String id) {
        return Service.findOneById(id);
    }


    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        Service.delete(id);
        return true;
    }

}