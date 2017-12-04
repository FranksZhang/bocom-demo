package com.bocom.dao;

import com.bocom.po.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    int insert(Account record);

    int insertSelective(Account record);
}
