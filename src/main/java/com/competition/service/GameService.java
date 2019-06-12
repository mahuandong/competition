package com.competition.service;

import com.competition.entity.Game;

import java.util.List;

public interface GameService{

    int deleteByPrimaryKey(Integer cId);

    int insert(Game record);

    int insertSelective(Game record);

    Game selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Game record);

    int updateByPrimaryKey(Game record);

    List<Game> findAll(int page,int limit);

    long findAllTotal();
}
