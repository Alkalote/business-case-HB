package fr.hb.jg.business_case.service;

import fr.hb.jg.business_case.dto.LocalisationDTO;
import fr.hb.jg.business_case.entity.Localisation;
import fr.hb.jg.business_case.exception.UpgradedEntityNotFoundException;
import fr.hb.jg.business_case.repository.LocalisationRepository;
import fr.hb.jg.business_case.service.interfaces.ServiceListInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;


@Service
@AllArgsConstructor
public class LocalisationService implements ServiceListInterface<Localisation, Long, LocalisationDTO, LocalisationDTO> {

    private LocalisationRepository localisationRepository;
    private UserService userService;

    @Override
    public List<Localisation> list() {
        return localisationRepository.findAll();
    }

    @Override
    public Localisation create(LocalisationDTO o) {

        Localisation l= new Localisation();

        l.setCity(o.getCity());
        l.setLongitude(o.getLongitude());
        l.setLatitude(o.getLatitude());
        l.setStreetName(o.getStreetName());
        l.setStreetNumber(o.getStreetNumber());
        l.setZipcode(o.getZipcode());
        l.setOwner(userService.findOneById(o.getOwnerId()));

        return localisationRepository.saveAndFlush(l);
    }

    @Override
    public Localisation update(LocalisationDTO o, Long id) {
        Localisation l= findOneById(id);

        l.setCity(o.getCity());
        l.setLongitude(o.getLongitude());
        l.setLatitude(o.getLatitude());
        l.setStreetName(o.getStreetName());
        l.setStreetNumber(o.getStreetNumber());
        l.setZipcode(o.getZipcode());
        l.setOwner(userService.findOneById(o.getOwnerId()));

        return localisationRepository.saveAndFlush(l);
    }

    @Override
    public Boolean delete(Long o) {
        try{
            localisationRepository.deleteById(o);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public Localisation findOneById(Long id) {
        return localisationRepository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }
}