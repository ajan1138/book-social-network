package com.ajan.book.auth;

import com.ajan.book.role.RoleRepository;
import com.ajan.book.user.User;
import com.ajan.book.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final RoleRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void registerUser(RegistrationRequest request) {
        var userRole = repository.findByName("USER")
                //better exception handling to do!
                .orElseThrow(() -> new IllegalStateException("User not found!"));

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isAccountLocked(false)
                .isEnabled(false)
                .roles(List.of(userRole))
                .build();

        userRepository.save(user);
    }
}
