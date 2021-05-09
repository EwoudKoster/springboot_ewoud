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

                .antMatchers(HttpMethod.GET, "/v1/customers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/v1/customers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/v1/customers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/v1/customers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/v1/customers/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/v1/stock/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/v1/stock/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/v1/stock/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/v1/stock/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/v1/stock/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/v1/repair/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/v1/repair/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/v1/repair/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/v1/repair/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/v1/repair/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/v1/emplyee/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/v1/emplyee/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/v1/emplyee/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/v1/emplyee/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/v1/emplyee/**").hasRole("ADMIN")

                // customers kunnen alleen een get vragen op hun eigen informatie
                .antMatchers(HttpMethod.GET, "/v1/customers/1").hasRole("CUSTOMER_1")
                .antMatchers(HttpMethod.GET, "/v1/customers/2").hasRole("CUSTOMER_2")
                .antMatchers(HttpMethod.GET, "/v1/customers/3").hasRole("CUSTOMER_3")
                .antMatchers(HttpMethod.GET, "/v1/customers/4").hasRole("CUSTOMER_4")
                .antMatchers(HttpMethod.GET, "/v1/repair/**").hasRole("CUSTOMER_1")
                .antMatchers(HttpMethod.GET, "/v1/repair/**").hasRole("CUSTOMER_2")
                .antMatchers(HttpMethod.GET, "/v1/repair/**").hasRole("CUSTOMER_3")
                .antMatchers(HttpMethod.GET, "/v1/repair/**").hasRole("CUSTOMER_4")


                // de backoffice die de stock moet bijhouden
                .antMatchers(HttpMethod.GET, "/v1/stock/**").hasRole("BACKOFFICE")
                .antMatchers(HttpMethod.POST, "/v1/stock/**").hasRole("BACKOFFICE")
                .antMatchers(HttpMethod.PUT, "/v1/stock/**").hasRole("BACKOFFICE")
                .antMatchers(HttpMethod.DELETE, "/v1/stock/**").hasRole("BACKOFFICE")
                .antMatchers(HttpMethod.PATCH, "/v1/stock/**").hasRole("BACKOFFICE")

                // de mechanic (deze heeft al een pre-auth bij repair) / cashier
                .antMatchers(HttpMethod.GET, "/v1/repair/**").hasRole("CASHIER")
                .antMatchers(HttpMethod.GET, "/v1/repair/**").hasRole("MECHANIC")
                .antMatchers(HttpMethod.POST, "/v1/repair/**").hasRole("MECHANIC")
                .antMatchers(HttpMethod.PUT, "/v1/repair/**").hasRole("MECHANIC")
                .antMatchers(HttpMethod.DELETE, "/v1/repair/**").hasRole("MECHANIC")
                .antMatchers(HttpMethod.PATCH, "/v1/repair/**").hasRole("MECHANIC")

                // de administrator
                .antMatchers(HttpMethod.GET, "/v1/customers/**").hasRole("ADMINISTRATOR")
                .antMatchers(HttpMethod.POST, "/v1/customers/**").hasRole("ADMINISTRATOR")
                .antMatchers(HttpMethod.PUT, "/v1/customers/**").hasRole("ADMINISTRATOR")

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