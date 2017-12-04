package com.bocom.controller;

import com.bocom.dao.AccountMapper;
import com.bocom.po.Account;
import com.bocom.service.TransactionService;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;

@Controller
public class SampleController {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/getTransactionDetailByAccount" )
    @ResponseBody
    public String getDealDetailByAccount (String account) {
        return transactionService.getDealDetailByAccount(account);
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
