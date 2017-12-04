package com.bocom.dao;

import com.bocom.po.Tranaction;
import com.bocom.vo.TransactionDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TranactionMapper {
    int deleteByPrimaryKey(Integer trid);

    int insert(Tranaction record);

    int insertSelective(Tranaction record);

    Tranaction selectByPrimaryKey(Integer trid);

    int updateByPrimaryKeySelective(Tranaction record);

    int updateByPrimaryKey(Tranaction record);

    List<TransactionDetail> selectByAccount(String account);
}
