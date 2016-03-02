package pl.lukmat.pzw.pl.lukmat.pzw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lukmat.pzw.pl.lukmat.pzw.entity.Account;
import pl.lukmat.pzw.pl.lukmat.pzw.entity.Role;
import pl.lukmat.pzw.pl.lukmat.pzw.service.AccountService;

/**
 * Created by admin on 01.03.2016.
 */

@Controller
public class IndexController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = {"/", "index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "index";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("accounts", accountService.findAll());
        return "test";
    }

    @RequestMapping("/accounts")
    public String accounts(Model model){
        Account account = accountService.findOne(1L);
        model.addAttribute("account", account);
        return "accounts";
    }

}