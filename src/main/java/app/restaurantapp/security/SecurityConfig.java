package app.restaurantapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/reservations/**").hasAnyRole("USER","ADMIN")
                                .requestMatchers("/restaurant/**").hasAnyRole("USER","ADMIN")
                                .requestMatchers("/ratings/**").hasAnyRole("USER","ADMIN")
                                .requestMatchers("/login/**").permitAll()
                                .requestMatchers("/users/**").permitAll()
                                .requestMatchers("/**").permitAll()
                                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }

//    @Bean
//    public PasswordEncoder encoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    UserDetailsService userDetailsService(){
//        UserDetails restaurator = User.builder()
        UserDetails restaurator = User.withDefaultPasswordEncoder()
                .username("geslerowa")
//                .password(encoder().encode("bestfood"))
                .password("bestfood")
                .roles("ADMIN")
                .build();
//        UserDetails client = User.builder()
        UserDetails client = User.withDefaultPasswordEncoder()
                .username("jasko")
//                .password(encoder().encode("12345"))
                .password("12345")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(restaurator,client);
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
