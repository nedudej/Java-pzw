package pl.lukmat.pzw.pl.lukmat.pzw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukmat.pzw.pl.lukmat.pzw.entity.Account;
import pl.lukmat.pzw.pl.lukmat.pzw.repository.AccountRepository;

import java.util.List;

/**
 * Created by Lukasz M. on 01.03.2016.
 */

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void save(Account account){
        accountRepository.save(account);
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public Account findByUsername(String username){
        return accountRepository.findByUsername(username);
    }

    public Account findOne(Long id){
        return accountRepository.findOne(id);
    }
}
