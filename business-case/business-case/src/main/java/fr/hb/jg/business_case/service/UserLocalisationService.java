package fr.hb.jg.business_case.service;

import fr.hb.jg.business_case.dto.UserLocalisationDTO;
import fr.hb.jg.business_case.entity.UserLocalisation;
import fr.hb.jg.business_case.exception.UpgradedEntityNotFoundException;
import fr.hb.jg.business_case.repository.UserLocalisationRepository;
import fr.hb.jg.business_case.service.interfaces.ServiceListInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;


@Service
@AllArgsConstructor
public class UserLocalisationService implements ServiceListInterface<UserLocalisation, Long, UserLocalisationDTO, UserLocalisationDTO> {

    private UserLocalisationRepository userLocalisationRepository;
    private UserService userService;
    private LocalisationService localisationService;

    @Override
    public List<UserLocalisation> list() {
        return userLocalisationRepository.findAll();
    }

    @Override
    public UserLocalisation create(UserLocalisationDTO o) {
        UserLocalisation ul = new UserLocalisation();

        ul.setLocalisation(localisationService.findOneById(o.getLocalisationId()));
        ul.setUser(userService.findOneById(o.getUserId()));
        ul.setIsBilling(o.getIsBilling());

        return userLocalisationRepository.saveAndFlush(ul);
    }

    @Override
    public UserLocalisation update(UserLocalisationDTO o, Long id) {
        UserLocalisation ul = findOneById(id);
        ul.setLocalisation(localisationService.findOneById(o.getLocalisationId()));
        ul.setUser(userService.findOneById(o.getUserId()));
        ul.setIsBilling(o.getIsBilling());
        return userLocalisationRepository.saveAndFlush(ul);
    }

    @Override
    public Boolean delete(Long o) {
        try{
            userLocalisationRepository.deleteById(o);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public UserLocalisation findOneById(Long id) {
        return userLocalisationRepository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }
}