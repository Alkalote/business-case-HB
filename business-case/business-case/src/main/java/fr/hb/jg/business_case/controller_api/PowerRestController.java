package fr.hb.jg.business_case.controller_api;

import fr.hb.jg.business_case.dto.PowerDTO;
import fr.hb.jg.business_case.entity.Power;
import fr.hb.jg.business_case.jsonview.JsonViews;
import fr.hb.jg.business_case.service.PowerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/power")
public class PowerRestController {

    private PowerService Service;

    @GetMapping
    @JsonView(JsonViews.PowerMinimalView.class)
    public List<Power> list() {
        return Service.list();
    }

    @PostMapping
    public Power create(@Valid @RequestBody PowerDTO dto) {
        return Service.create(dto);
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.PowerShow.class)
    public Power show(@PathVariable Long id) {
        return Service.findOneById(id);
    }

    @PutMapping("/{id}")
    public Power update(@Valid @RequestBody PowerDTO dto, @PathVariable Long id) {
        return Service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        Service.delete(id);
        return true;
    }

}