package fr.hb.jg.business_case.controller_api;

import fr.hb.jg.business_case.dto.UserLocalisationDTO;
import fr.hb.jg.business_case.entity.UserLocalisation;
import fr.hb.jg.business_case.jsonview.JsonViews;
import fr.hb.jg.business_case.service.UserLocalisationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/userlocalisation")
public class UserLocalisationRestController {

    private UserLocalisationService Service;

    @GetMapping
    @JsonView(JsonViews.UserLocalisationMinimalView.class)
    public List<UserLocalisation> list() {
        return Service.list();
    }

    @PostMapping
    public UserLocalisation create(@Valid @RequestBody UserLocalisationDTO dto) {
        return Service.create(dto);
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.UserLocalisationShow.class)
    public UserLocalisation show(@PathVariable Long id) {
        return Service.findOneById(id);
    }

    @PutMapping("/{id}")
    public UserLocalisation update(@Valid @RequestBody UserLocalisationDTO dto, @PathVariable Long id) {
        return Service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        Service.delete(id);
        return true;
    }

}