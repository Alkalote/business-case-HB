package fr.hb.jg.business_case.service;

import fr.hb.jg.business_case.dto.HourlyRateDTO;
import fr.hb.jg.business_case.entity.HourlyRate;
import fr.hb.jg.business_case.exception.UpgradedEntityNotFoundException;
import fr.hb.jg.business_case.repository.HourlyRateRepository;
import fr.hb.jg.business_case.service.interfaces.ServiceListInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;


@Service
@AllArgsConstructor
public class HourlyRateService implements ServiceListInterface<HourlyRate, Long, HourlyRateDTO, HourlyRateDTO> {

    private HourlyRateRepository repository;
    private ChargingStationService chargingStationService;

    @Override
    public List<HourlyRate> list() {
        return repository.findAll();
    }

    @Override
    public HourlyRate create(HourlyRateDTO o) {

        HourlyRate hourlyRate = new HourlyRate();
        hourlyRate.setChargingStation(chargingStationService.findOneById(o.getChargingStationId()));
        hourlyRate.setValue(o.getValue());
        hourlyRate.setMinimalDuration(o.getMinimalDuration());

        return hourlyRate;
    }

    @Override
    public HourlyRate update(HourlyRateDTO o, Long id) {

        HourlyRate hourlyRate = findOneById(id);
        hourlyRate.setChargingStation(chargingStationService.findOneById(o.getChargingStationId()));
        hourlyRate.setValue(o.getValue());
        hourlyRate.setMinimalDuration(o.getMinimalDuration());

        return hourlyRate;
    }

    @Override
    public Boolean delete(Long o) {
        try{
            repository.deleteById(o);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public HourlyRate findOneById(Long id) {
        return repository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }
}