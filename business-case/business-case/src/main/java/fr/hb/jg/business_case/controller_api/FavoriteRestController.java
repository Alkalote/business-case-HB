package fr.hb.jg.business_case.controller_api;

import fr.hb.jg.business_case.dto.FavoriteDTO;
import fr.hb.jg.business_case.entity.Favorite;
import fr.hb.jg.business_case.entity.embeddable.UserChargingStationId;
import fr.hb.jg.business_case.service.FavoriteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/favorite")
public class FavoriteRestController {

    private FavoriteService favoriteService;

    @PostMapping
    public Boolean handleFavorite(@RequestBody UserChargingStationId data) {
        return favoriteService.handleFavorite(data);
    }

}