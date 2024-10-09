package fr.hb.jg.business_case.service;

import fr.hb.jg.business_case.dto.UserLoginDTO;
import fr.hb.jg.business_case.dto.UserRegisterDTO;
import fr.hb.jg.business_case.dto.UserUpdateDTO;
import fr.hb.jg.business_case.entity.User;
import fr.hb.jg.business_case.exception.UpgradedEntityNotFoundException;
import fr.hb.jg.business_case.repository.UserRepository;
import fr.hb.jg.business_case.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class UserService implements ServiceListInterface<User, String, UserRegisterDTO, UserUpdateDTO>, UserDetailsService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserRegisterDTO o) {

        User u = new User();

        if(!o.getPassword().equals(o.getPassword2())){
            return null;
        }

        u.setEmail(o.getEmail());
        u.setFirstName(o.getFirstName());
        u.setLastName(o.getLastName());
        u.setPassword(passwordEncoder.encode(o.getPassword()));
        u.setPhone(o.getPhone());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime t = LocalDate.parse(o.getBirthedAt(), formatter).atStartOfDay();
        u.setBirthedAt(t);
        u.setRoles("[\"ROLE_USER\"]");
        u.setActivationCode(UUID.randomUUID().toString());
        u.setCreatedAt(LocalDateTime.now());

        return userRepository.saveAndFlush(u);
    }

    @Override
    public User update(UserUpdateDTO o, String id) {
        User u =findOneById(id);

        if(u==null){
            return null;
        }

        u.setFirstName(o.getFirstName());
        u.setLastName(o.getLastName());
        u.setPassword(passwordEncoder.encode(o.getPassword()));
        u.setPhone(o.getPhone());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime t = LocalDate.parse(o.getBirthedAt(), formatter).atStartOfDay();
        u.setBirthedAt(t);

        return userRepository.saveAndFlush(u);
    }

    @Override
    public Boolean delete(String o) {

        try {
            User user = findOneById(o);
            user.setPhone(null);
            user.setBirthedAt(null);
            user.setLastName(null);
            user.setFirstName(null);
            user.setEmail("Utilisateur supprimé");
            userRepository.saveAndFlush(user);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public User findOneById(String id) {
        return userRepository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("L'éléphant est dans le magasin porcelaine"));

        return new org.springframework.security.core.userdetails.User(u.getEmail(),u.getPassword(),userGrantedAuthorities(u.getRoles()));
    }

    private List<GrantedAuthority> userGrantedAuthorities(String jsonRoles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if (jsonRoles.contains("ADMIN")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        //});
        return authorities;
    }

    public User findOneByEmail(String email) {
        return userRepository.findUserByEmailAndActivationCodeIsNull(email)
                .orElseThrow(EntityNotFoundException::new);
    }

}