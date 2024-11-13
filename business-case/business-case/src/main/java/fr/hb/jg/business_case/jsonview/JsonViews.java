package fr.hb.jg.business_case.jsonview;

import fr.hb.jg.business_case.repository.HourlyRateRepository;

public class JsonViews {

    public interface ChargingStationMinimalView {}

    public interface ChargingStationShow extends ChargingStationMinimalView {}

    public interface HourlyRateMinimalView {}

    public interface HourlyRateShow extends HourlyRateRepository {}

    public interface BookingMinimalView {}

    public interface BookingShow extends BookingMinimalView {}

    public interface LocalisationMinimalView {}

    public interface LocalisationShow extends LocalisationMinimalView {}

    public interface MediaMinimalView {}

    public interface MediaShow extends MediaMinimalView {}

    public interface PowerMinimalView {}

    public interface PowerShow extends PowerMinimalView {}

    public interface ReviewMinimalView {}

    public interface ReviewShow extends ReviewMinimalView {}

    public interface UserLocalisationMinimalView {}

    public interface UserLocalisationShow extends UserLocalisationMinimalView {}

    public interface UserReviewMinimalView {}

    public interface UserReviewShow extends UserReviewMinimalView {}



}
