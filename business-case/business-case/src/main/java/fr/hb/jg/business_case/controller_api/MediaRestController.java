package fr.hb.jg.business_case.controller_api;

import fr.hb.jg.business_case.dto.MediaDTO;
import fr.hb.jg.business_case.entity.Media;
import fr.hb.jg.business_case.jsonview.JsonViews;
import fr.hb.jg.business_case.service.MediaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/media")
public class MediaRestController {

    private MediaService Service;

    @GetMapping
    @JsonView(JsonViews.MediaMinimalView.class)
    public List<Media> list() {
        return Service.list();
    }

    @PostMapping
    public Media create(@Valid @RequestBody MediaDTO dto) {
        return Service.create(dto);
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.MediaShow.class)
    public Media show(@PathVariable String id) {
        return Service.findOneById(id);
    }

    @PutMapping("/{id}")
    public Media update(@Valid @RequestBody MediaDTO dto, @PathVariable String id) {
        return Service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        Service.delete(id);
        return true;
    }

}