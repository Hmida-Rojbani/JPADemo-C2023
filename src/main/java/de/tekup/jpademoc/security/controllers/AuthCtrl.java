package de.tekup.jpademoc.security.controllers;


import de.tekup.jpademoc.security.models.LoginRequest;
import de.tekup.jpademoc.security.services.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuthCtrl {

    private final AuthenticationManager authManager;
    private TokenService tokenService;

    @PostMapping("/token")
    public String token(@RequestBody LoginRequest loginRequest) throws AuthenticationException {
        Authentication authentication = authManager
                        .authenticate(new UsernamePasswordAuthenticationToken
                                (loginRequest.getUsername(),loginRequest.getPassword()));

        return tokenService.generateToken(authentication);
    }
}
