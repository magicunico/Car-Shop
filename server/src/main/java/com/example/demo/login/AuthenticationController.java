package com.example.demo.login;

import com.example.demo.login.entity.ApiResponse;
import com.example.demo.login.entity.AuthenticationRequest;
import com.example.demo.login.entity.JwtAuthenticationResponse;
import com.example.demo.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/")
    public ResponseEntity<?> login(@Valid @RequestBody AuthenticationRequest request) {

        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(request.getUsername());
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AuthenticationRequest signUpRequest) {

        if (userRepository.findById(signUpRequest.getUsername()).isPresent()) {
            return new ResponseEntity<>(ApiResponse.builder()
                    .success(false)
                    .message("Username is already taken!")
                    .build(),
                    HttpStatus.BAD_REQUEST);
        }
        User user = new User(signUpRequest.getUsername(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("User registered successfully")
                        .build()
        );
    }
}
