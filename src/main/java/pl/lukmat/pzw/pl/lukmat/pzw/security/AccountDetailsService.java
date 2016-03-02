package pl.lukmat.pzw.pl.lukmat.pzw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.lukmat.pzw.pl.lukmat.pzw.entity.Account;
import pl.lukmat.pzw.pl.lukmat.pzw.entity.Role;
import pl.lukmat.pzw.pl.lukmat.pzw.service.AccountService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Lukasz M. on 01.03.2016.
 */

@Service
public class AccountDetailsService implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByUsername(username);
        if(account == null){
            throw new UsernameNotFoundException("User"+ username + " not found.");
        }
        if(account.getRoles() == null || account.getRoles().isEmpty()) {
            throw new UsernameNotFoundException("User not authorized");
        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (Role role : account.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<GrantedAuthority> getAuthorities() {
                return grantedAuthorities;
            }

            @Override
            public String getPassword() {
                return account.getPassword();
            }

            @Override
            public String getUsername() {
                return account.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return !account.isLocked();
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return account.isEnabled();
            }
        };

        return userDetails;

    }
}
