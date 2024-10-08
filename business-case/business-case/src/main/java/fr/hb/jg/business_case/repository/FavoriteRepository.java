package fr.hb.jg.business_case.repository;

import fr.hb.jg.business_case.entity.Favorite;
import fr.hb.jg.business_case.entity.embeddable.UserChargingStationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, UserChargingStationId> {


}