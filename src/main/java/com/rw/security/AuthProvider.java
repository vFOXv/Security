package com.rw.security;

import com.rw.models.User;
import com.rw.services.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProvider implements AuthenticationProvider {

    private final UserService userService;

    public AuthProvider(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        User user = userService.getByUsername(username);



        if(user == null){
            throw new UsernameNotFoundException("Dont find user name");
        }

        String password = authentication.getCredentials().toString();
        if(!password.equals(user.getPassword())){
            throw new BadCredentialsException("Bad credentials");
        }
        List<GrantedAuthority>authorities = new ArrayList<>();
        return new UsernamePasswordAuthenticationToken(user, null,authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
