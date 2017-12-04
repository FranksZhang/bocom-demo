package com.bocom.controller;

import com.bocom.dao.AccountMapper;
import com.bocom.po.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/getTransactionDetailByAccount" )
    @ResponseBody
    public String getDealDetailByAccount (String accout) {

        return "nihao";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        Account account = new Account();
        account.setAcno("001");
        account.setAcname("diaolao");
        accountMapper.insert(account);
        return account.getAcno().toString();
    }

}
