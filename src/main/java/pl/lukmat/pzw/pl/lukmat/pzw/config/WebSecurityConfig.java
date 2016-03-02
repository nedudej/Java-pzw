package pl.lukmat.pzw.pl.lukmat.pzw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.lukmat.pzw.pl.lukmat.pzw.security.AccountDetailsService;

/**
 * Created by Lukasz M. on 01.03.2016.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   private AccountDetailsService accountDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/", "/index", "/resources/**", "/webjars/**").permitAll()
                    // tu można dodać kolejne .antMatchers
                    .antMatchers("/admin").hasRole("ADMIN")
                    .antMatchers("/accounts").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                .formLogin().loginPage("/login").permitAll()
                    .and()
                .logout()
                .permitAll();


    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountDetailsService);
    }
}
