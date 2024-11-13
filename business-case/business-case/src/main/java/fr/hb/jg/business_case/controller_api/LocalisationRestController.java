package fr.hb.jg.business_case.controller_api;

import fr.hb.jg.business_case.dto.LocalisationDTO;
import fr.hb.jg.business_case.entity.Localisation;
import fr.hb.jg.business_case.jsonview.JsonViews;
import fr.hb.jg.business_case.service.LocalisationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/localisation")
public class LocalisationRestController {

    private LocalisationService Service;

    @GetMapping
    @JsonView(JsonViews.LocalisationMinimalView.class)
    public List<Localisation> list() {
        return Service.list();
    }

    @PostMapping
    public Localisation create(@Valid @RequestBody LocalisationDTO dto) {
        return Service.create(dto);
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.LocalisationShow.class)
    public Localisation show(@PathVariable Long id) {
        return Service.findOneById(id);
    }

    @PutMapping("/{id}")
    public Localisation update(@Valid @RequestBody LocalisationDTO dto, @PathVariable Long id) {
        return Service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        Service.delete(id);
        return true;
    }

}