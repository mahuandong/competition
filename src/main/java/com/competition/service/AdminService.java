package com.competition.service;

import com.competition.entity.Admin;

import java.util.List;

public interface AdminService{


    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> findAllByRole(int page ,int limit, Integer role);

    Admin findAllByAccountAndRole(String account,Integer role);

    long findAllBytotal(Integer role);

}
