package fr.hb.jg.business_case.configuration;

import fr.hb.jg.business_case.entity.*;
import fr.hb.jg.business_case.repository.*;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
public class InitDataLoaderConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ChargingStationRepository chargingStationRepository;
    private final FavoriteRepository favoriteRepository;
    private final BookingRepository bookingRepository;
    private final HourlyRateRepository hourlyRateRepository;
    private final LocalisationRepository localisationRepository;
    private final MediaRepository mediaRepository;
    private final PowerRepository powerRepository;
    private final ReviewRepository reviewRepository;
    private final UserLocalisationRepository userLocalisationRepository;
    private final UserReviewRepository userReviewRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private final Faker faker;

    @Autowired
    public InitDataLoaderConfig(
      UserRepository userRepository,
      ChargingStationRepository chargingStationRepository,
      FavoriteRepository favoriteRepository,
      BookingRepository bookingRepository,
      HourlyRateRepository hourlyRateRepository,
      LocalisationRepository localisationRepository,
      MediaRepository mediaRepository,
      PowerRepository powerRepository,
      ReviewRepository reviewRepository,
      UserLocalisationRepository userLocalisationRepository,
      UserReviewRepository userReviewRepository,
      BCryptPasswordEncoder passwordEncoder
    )
    {
        this.userRepository = userRepository;
        this.chargingStationRepository = chargingStationRepository;
        this.favoriteRepository = favoriteRepository;
        this.bookingRepository = bookingRepository;
        this.hourlyRateRepository = hourlyRateRepository;
        this.localisationRepository = localisationRepository;
        this.mediaRepository = mediaRepository;
        this.powerRepository = powerRepository;
        this.reviewRepository = reviewRepository;
        this.userLocalisationRepository = userLocalisationRepository;
        this.userReviewRepository = userReviewRepository;
        this.passwordEncoder = passwordEncoder;
        this.faker = new Faker(Locale.of("fr"));
    }

    @Override
    public void run(String... args) throws Exception {

        createUsers();
        createLocalisation();
        createPower();
        createStations();

    }

    private void createUsers() {
        if (userRepository.count() <= 30) {
            for (long i = 1L; i <= 30L; i++) {
                User user = new User();
                user.setCreatedAt(LocalDateTime.now());
                user.setFirstName(faker.name().firstName());
                user.setLastName(faker.name().lastName());
                user.setEmail(faker.internet().emailAddress(
                        user.getFirstName() + "." + user.getLastName()
                ).toLowerCase());
                user.setPhone(faker.phoneNumber().cellPhone());
                user.setBirthedAt(generateRandomDate(
                        Instant.now().minusSeconds(999999999)
                                .minusSeconds(999999999)
                                .minusSeconds(999999999)).toLocalDate());
                user.setPassword(passwordEncoder.encode("12345"));
                String roles = "[\"ROLE_USER\"";
                if (i == 1L) {
                    roles += ", \"ROLE_ADMIN\"";
                }
                roles += "]";
                user.setRoles(roles);
                userRepository.save(user);
            }
            userRepository.flush();
        }
    }


    private void createLocalisation() {
        List<String> duplicates = new ArrayList<>();
        if (localisationRepository.count() == 0) {
            List<User> users = userRepository.findAll();
            for (long i = 1L; i <= 30L; i++) {
                Localisation localisation = new Localisation();
                localisation.setCity(faker.address().cityName());
                localisation.setLatitude(faker.address().latitude());
                localisation.setLongitude(faker.address().longitude());
                localisation.setStreetName(faker.address().streetName());
                localisation.setStreetNumber(faker.address().streetAddressNumber());
                localisation.setZipcode(faker.address().zipCode());
                Random random = new Random();
                if (random.nextBoolean()) {
                    User user;
                    do {
                        user = users.get(random.nextInt(1, 20));
                    } while (duplicates.contains(user.getUuid()));
                    duplicates.add(user.getUuid());
                    localisation.setOwner(user);
                }
                localisationRepository.save(localisation);
            }
            localisationRepository.flush();
        }
    }

    private void createPower() {
        if(powerRepository.count()<= 10){
            for(long i = 1L; i <= 10L; i++){
                Random random = new Random();
                Power power = new Power();
                power.setValue(random.nextFloat(2));
                powerRepository.save(power);
            }
            powerRepository.flush();

        }
    }

    private void createStations() {

        List<Localisation> localisations = localisationRepository.findAll();
        List<Power> powers = powerRepository.findAll();
        Random random = new Random();

        if(chargingStationRepository.count()<=20){

            for(long i = 1L; i <= 20L; i++){

                Localisation localisation = localisations.get(random.nextInt(1,30));
                Power power = powers.get(random.nextInt(1,10));
                ChargingStation chargingStation = new ChargingStation();
                chargingStation.setCreatedAt(generateRandomDate(Instant.now().minusSeconds(999999999)));
                chargingStation.setPower(power);
                chargingStation.setLocalisation(localisation);
                chargingStation.setName(faker.name().firstName());
                chargingStation.setOnFoot(random.nextBoolean());
                chargingStation.setAccessibleDirectives(faker.kaamelott().quote());
                chargingStationRepository.save(chargingStation);


            }
            chargingStationRepository.flush();
        }


    }


    private LocalDateTime generateRandomDate(Instant start) {
        Faker faker = new Faker();
        Instant randomDate = faker.timeAndDate().between(
                start,
                Instant.now());
        return randomDate.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}
