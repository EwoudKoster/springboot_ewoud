package nl.novi.springboot.first_demo.Config;

import nl.novi.springboot.first_demo.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()

                // Admin role acces GET / POST / PUT / DELETE / PATCH op alles wat door de ** is aangegeven
                .antMatchers(HttpMethod.GET, "/v1/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/v1/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/v1/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/v1/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/v1/admin/**").hasRole("ADMIN")

                .antMatchers("/v1/users/**").hasRole("ADMIN")
                .antMatchers("/v1/emplyee/**").hasRole("USER")
                .antMatchers("/v1/customers/**").hasRole("USER")
//                .antMatchers(HttpMethod.GET, "/users/**").hasRole("USER") // per user authorization in UserService
                .antMatchers(HttpMethod.GET,"/authenticated/**").authenticated()
//                .anyRequest().authenticated()
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .formLogin().disable();

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}