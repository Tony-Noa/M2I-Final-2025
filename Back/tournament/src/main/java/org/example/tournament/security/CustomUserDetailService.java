package org.example.tournament.security;

import org.example.tournament.entity.UserAccount;
import org.example.tournament.repository.UserAccountRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service

public class CustomUserDetailService implements UserDetailsService {

    private final UserAccountRepository userRepository;

    public CustomUserDetailService(UserAccountRepository userAccountRepository) {
        this.userRepository = userAccountRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserAccount> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()){
            UserAccount user = userOptional.get();
            Set<GrantedAuthority> authorities = new HashSet<>();
            if (user.getRole().toString().equals("ADMIN")) authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            else authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            return new User(user.getEmail(), user.getPassword(),authorities);
        }
        return null;
    }
}
