package fr.hb.jg.business_case.controller_api;

import fr.hb.jg.business_case.dto.ChargingStationDTO;
import fr.hb.jg.business_case.entity.ChargingStation;
import fr.hb.jg.business_case.jsonview.JsonViews;
import fr.hb.jg.business_case.service.ChargingStationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/station")
public class ChargingStationRestController {

    private ChargingStationService Service;

    @GetMapping
    @JsonView(JsonViews.ChargingStationMinimalView.class)
    public List<ChargingStation> list() {
        return Service.list();
    }

    @PostMapping
    public ChargingStation create(@Valid @RequestBody ChargingStationDTO dto) {
        return Service.create(dto);
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.ChargingStationShow.class)
    public ChargingStation show(@PathVariable String id) {
        return Service.findOneById(id);
    }

    @PutMapping("/{id}")
    public ChargingStation update(@Valid @RequestBody ChargingStationDTO dto, @PathVariable String id) {
        return Service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        Service.delete(id);
        return true;
    }

}