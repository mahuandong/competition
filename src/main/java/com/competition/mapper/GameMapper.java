package com.competition.mapper;
import java.util.List;

import com.competition.entity.Game;

public interface GameMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Game record);

    int insertSelective(Game record);

    Game selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Game record);

    int updateByPrimaryKey(Game record);

    List<Game> findAll();

}