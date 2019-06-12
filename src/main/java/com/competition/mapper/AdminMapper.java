package com.competition.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.competition.entity.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> findAllByRole(@Param("role")Integer role);

    Admin findAllByAccountAndRole(@Param("account")String account,@Param("role")Integer role);

}