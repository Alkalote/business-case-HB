package fr.hb.jg.business_case.service;

import fr.hb.jg.business_case.dto.ChargingStationDTO;
import fr.hb.jg.business_case.entity.ChargingStation;
import fr.hb.jg.business_case.exception.UpgradedEntityNotFoundException;
import fr.hb.jg.business_case.repository.ChargingStationRepository;
import fr.hb.jg.business_case.service.interfaces.ServiceListInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class ChargingStationService implements ServiceListInterface<ChargingStation, String, ChargingStationDTO, ChargingStationDTO> {

    private ChargingStationRepository repository;
    private LocalisationService localisationService;
    private PowerService powerService;

    @Override
    public List<ChargingStation> list() {
        return repository.findAll();
    }

    @Override
    public ChargingStation create(ChargingStationDTO o) {

        ChargingStation chargingStation = new ChargingStation();
        chargingStation.setCreatedAt(LocalDateTime.now());
        chargingStation.setName(o.getName());
        chargingStation.setAccessibleDirectives(o.getAccessibleDirectives());
        chargingStation.setLocalisation(localisationService.findOneById(o.getLocalisationId()));
        chargingStation.setPower(powerService.findOneById(o.getPowerId()));
        chargingStation.setOnFoot(o.getOnFoot());

        return chargingStation;
    }

    @Override
    public ChargingStation update(ChargingStationDTO o, String id) {
        ChargingStation chargingStation = findOneById(id);
        chargingStation.setUpdatedAt(LocalDateTime.now());
        chargingStation.setName(o.getName());
        chargingStation.setAccessibleDirectives(o.getAccessibleDirectives());
        chargingStation.setLocalisation(localisationService.findOneById(o.getLocalisationId()));
        chargingStation.setPower(powerService.findOneById(o.getPowerId()));
        chargingStation.setOnFoot(o.getOnFoot());

        return chargingStation;
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
    public ChargingStation findOneById(String id) {
        return repository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }
}