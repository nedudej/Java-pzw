package pl.lukmat.pzw.pl.lukmat.pzw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukmat.pzw.pl.lukmat.pzw.entity.Account;
import pl.lukmat.pzw.pl.lukmat.pzw.entity.Role;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lukasz M. on 01.03.2016.
 */
@Service
public class InitDbService {

    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @PostConstruct
    public void init(){

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleService.save(roleAdmin);

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleService.save(roleUser);

        Role roleSysadmin = new Role();
        roleSysadmin.setName("ROLE_SYSADMIN");
        roleService.save(roleSysadmin);


        Account account = new Account();
        account.setEmail("test@test");
        account.setUsername("admin");
        account.setPassword("admin");
        List<Role> roles = new ArrayList<>();
        roles.add(roleAdmin);
        roles.add(roleSysadmin);
        account.setRoles(roles);
        accountService.save(account);

        Account account2 = new Account();
        account2.setEmail("test@test");
        account2.setUsername("user");
        account2.setPassword("user");
        List<Role> roles2 = new ArrayList<>();
        roles2.add(roleUser);
        account2.setRoles(roles2);
        accountService.save(account2);

        Account account3 = new Account();
        account3.setEmail("test@test");
        account3.setUsername("userd");
        account3.setPassword("userd");
        account3.setEnabled(false);
        List<Role> roles3 = new ArrayList<>();
        roles3.add(roleUser);
        account3.setRoles(roles3);
        accountService.save(account3);

        Account account4 = new Account();
        account4.setEmail("test@test");
        account4.setUsername("userl");
        account4.setPassword("userl");
        account4.setLocked(true);
        List<Role> roles4 = new ArrayList<>();
        roles4.add(roleUser);
        account4.setRoles(roles4);
        accountService.save(account4);

    }

}
