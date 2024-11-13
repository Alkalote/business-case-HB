package fr.hb.jg.business_case.service;

import fr.hb.jg.business_case.dto.BookingDTO;
import fr.hb.jg.business_case.entity.Booking;
import fr.hb.jg.business_case.entity.enumerations.Status;
import fr.hb.jg.business_case.exception.UpgradedEntityNotFoundException;
import fr.hb.jg.business_case.repository.BookingRepository;
import fr.hb.jg.business_case.service.interfaces.ServiceListInterface;
import fr.hb.jg.business_case.service.interfaces.ServiceListInterfaceCRD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class BookingService implements ServiceListInterfaceCRD<Booking, String, BookingDTO> {

    private BookingRepository bookingRepository;
    private UserService userService;
    private UserLocalisationService userLocalisationService;
    private ChargingStationService chargingStationService;


    @Override
    public List<Booking> list() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking create(BookingDTO o) {

        Booking b = new Booking();
        b.setCreatedAt(LocalDateTime.now());
        b.setStatus(Status.PENDING_ANSWER);
        b.setUser(userService.findOneById(o.getUserId()));
        b.setChargingStation(chargingStationService.findOneById(o.getChargingStationId()));
        b.setUserLocalisation(userLocalisationService.findOneById(o.getUserLocalisationId()));
        b.setFinishedAt(b.getFinishedAt());
        b.setStartedAt(b.getStartedAt());



        return b;
    }

    @Override
    public Boolean delete(String o) {
        try{
            bookingRepository.deleteById(o);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public Booking findOneById(String id) {
        return bookingRepository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }
}