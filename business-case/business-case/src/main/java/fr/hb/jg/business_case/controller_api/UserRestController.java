package fr.hb.jg.business_case.controller_api;

import fr.hb.jg.business_case.entity.User;
import fr.hb.jg.business_case.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {

    private UserService Service;

    @GetMapping("/me")
    public User show(Principal principal) {
        return Service.findUser(principal);
    }



}