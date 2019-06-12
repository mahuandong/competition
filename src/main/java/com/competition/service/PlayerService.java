package com.competition.service;

import com.competition.entity.Player;

import java.util.List;

public interface PlayerService{

    int deleteByPrimaryKey(Integer playerId);

    int insert(Player record);

    int insertSelective(Player record);

    Player selectByPrimaryKey(Integer playerId);

    int updateByPrimaryKeySelective(Player record);

    int updateByPrimaryKey(Player record);

    List<Player> findAll(int page,int limit);

    long findAll();
}
