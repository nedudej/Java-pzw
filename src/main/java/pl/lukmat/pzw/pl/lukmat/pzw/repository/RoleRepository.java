package pl.lukmat.pzw.pl.lukmat.pzw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukmat.pzw.pl.lukmat.pzw.entity.Account;
import pl.lukmat.pzw.pl.lukmat.pzw.entity.Role;

import java.util.List;

/**
 * Created by Lukasz M. on 01.03.2016.
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

    List<Role> findByAccountsId(Long id);

    List<Role> findByAccounts(Account account);


}
