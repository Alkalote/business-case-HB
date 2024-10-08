package fr.hb.jg.business_case.repository;

import fr.hb.jg.business_case.entity.HourlyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HourlyRateRepository extends JpaRepository<HourlyRate, Long> {


}