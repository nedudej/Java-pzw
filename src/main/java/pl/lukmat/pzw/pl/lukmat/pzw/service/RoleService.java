package pl.lukmat.pzw.pl.lukmat.pzw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukmat.pzw.pl.lukmat.pzw.entity.Role;
import pl.lukmat.pzw.pl.lukmat.pzw.repository.RoleRepository;

/**
 * Created by Lukasz M. on 01.03.2016.
 */

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void save(Role role){
        roleRepository.save(role);
    }



}
