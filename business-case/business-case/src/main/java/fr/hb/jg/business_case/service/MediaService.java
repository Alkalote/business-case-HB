package fr.hb.jg.business_case.service;

import fr.hb.jg.business_case.dto.MediaDTO;
import fr.hb.jg.business_case.entity.ChargingStation;
import fr.hb.jg.business_case.entity.Media;
import fr.hb.jg.business_case.exception.UpgradedEntityNotFoundException;
import fr.hb.jg.business_case.repository.MediaRepository;
import fr.hb.jg.business_case.service.interfaces.ServiceListInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;


@Service
@AllArgsConstructor
public class MediaService implements ServiceListInterface<Media, String, MediaDTO, MediaDTO> {

    private MediaRepository repository;
    private ChargingStationService chargingStationService;

    @Override
    public List<Media> list() {
        return repository.findAll();
    }

    @Override
    public Media create(MediaDTO o) {

        Media media = new Media();
        media.setChargingStation(chargingStationService.findOneById(o.getChargingStationId()));
        media.setExtension(o.getExtension());
        media.setName(o.getName());

        return media;
    }

    @Override
    public Media update(MediaDTO o, String id) {
        Media media = findOneById(id);
        media.setChargingStation(chargingStationService.findOneById(o.getChargingStationId()));
        media.setExtension(o.getExtension());
        media.setName(o.getName());

        return media;
    }

    @Override
    public Boolean delete(String o) {

        try{
            repository.deleteById(o);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public Media findOneById(String id) {
        return repository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }
}