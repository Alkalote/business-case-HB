package fr.hb.jg.business_case.service;

import fr.hb.jg.business_case.entity.Favorite;
import fr.hb.jg.business_case.entity.embeddable.UserChargingStationId;
import fr.hb.jg.business_case.repository.FavoriteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FavoriteService {

    private FavoriteRepository favoriteRepository;

    public Boolean handleFavorite(UserChargingStationId o) {
        System.out.println(o);
        Optional<Favorite> optionalFavorite = favoriteRepository.findById(o);
        if (optionalFavorite.isEmpty()) {
            Favorite favorite = new Favorite();
            favorite.setId(o);
            favorite.setCreatedAt(LocalDateTime.now());
            favoriteRepository.saveAndFlush(favorite);
            return true;
        }
        favoriteRepository.delete(optionalFavorite.get());
        return false;
    }


}
