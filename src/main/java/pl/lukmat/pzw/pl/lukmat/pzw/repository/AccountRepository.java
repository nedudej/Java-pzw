package pl.lukmat.pzw.pl.lukmat.pzw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukmat.pzw.pl.lukmat.pzw.entity.Account;

import java.util.List;

/**
 * Created by Lukasz M. on 01.03.2016.
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

    Account findByUsername(String username);


}
