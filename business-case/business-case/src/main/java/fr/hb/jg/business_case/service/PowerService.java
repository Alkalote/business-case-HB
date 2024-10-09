package fr.hb.jg.business_case.service;

import fr.hb.jg.business_case.dto.PowerDTO;
import fr.hb.jg.business_case.entity.Power;
import fr.hb.jg.business_case.exception.UpgradedEntityNotFoundException;
import fr.hb.jg.business_case.repository.PowerRepository;
import fr.hb.jg.business_case.service.interfaces.ServiceListInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;


@Service
@AllArgsConstructor
public class PowerService implements ServiceListInterface<Power, Long, PowerDTO, PowerDTO> {

    private PowerRepository powerRepository;

    @Override
    public List<Power> list() {
        return powerRepository.findAll();
    }

    @Override
    public Power create(PowerDTO o) {

        Power p = new Power();

        p.setValue(o.getValue());

        return powerRepository.saveAndFlush(p);
    }

    @Override
    public Power update(PowerDTO o, Long id) {
        Power p = findOneById(id);

        p.setValue(o.getValue());

        return powerRepository.saveAndFlush(p);
    }

    @Override
    public Boolean delete(Long o) {
        try{
            powerRepository.deleteById(o);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public Power findOneById(Long id) {
        return powerRepository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }
}