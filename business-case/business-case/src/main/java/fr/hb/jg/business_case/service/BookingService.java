package fr.hb.jg.business_case.service;

import fr.hb.jg.business_case.dto.BookingDTO;
import fr.hb.jg.business_case.entity.Booking;
import fr.hb.jg.business_case.entity.enumerations.Status;
import fr.hb.jg.business_case.exception.UpgradedEntityNotFoundException;
import fr.hb.jg.business_case.repository.BookingRepository;
import fr.hb.jg.business_case.service.interfaces.ServiceListInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class BookingService implements ServiceListInterface<Booking, String, BookingDTO, BookingDTO> {

    private BookingRepository bookingRepository;
    private UserService userService;


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



        return null;
    }

    @Override
    public Booking update(BookingDTO o, String id) {
        return null;
    }

    @Override
    public Boolean delete(String o) {
        return null;
    }

    @Override
    public Booking findOneById(String id) {
        return bookingRepository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }
}