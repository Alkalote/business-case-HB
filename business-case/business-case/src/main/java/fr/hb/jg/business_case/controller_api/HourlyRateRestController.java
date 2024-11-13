package fr.hb.jg.business_case.controller_api;

import fr.hb.jg.business_case.dto.HourlyRateDTO;
import fr.hb.jg.business_case.entity.HourlyRate;
import fr.hb.jg.business_case.jsonview.JsonViews;
import fr.hb.jg.business_case.service.HourlyRateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/hourlyRate")
public class HourlyRateRestController {

    private HourlyRateService Service;

    @GetMapping
    @JsonView(JsonViews.HourlyRateMinimalView.class)
    public List<HourlyRate> list() {
        return Service.list();
    }

    @PostMapping
    public HourlyRate create(@Valid @RequestBody HourlyRateDTO dto) {
        return Service.create(dto);
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.HourlyRateShow.class)
    public HourlyRate show(@PathVariable Long id) {
        return Service.findOneById(id);
    }

    @PutMapping("/{id}")
    public HourlyRate update(@Valid @RequestBody HourlyRateDTO dto, @PathVariable Long id) {
        return Service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        Service.delete(id);
        return true;
    }

}