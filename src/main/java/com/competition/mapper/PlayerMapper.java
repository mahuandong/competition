package com.competition.mapper;
import java.util.List;

import com.competition.entity.Player;

public interface PlayerMapper {
    int deleteByPrimaryKey(Integer playerId);

    int insert(Player record);

    int insertSelective(Player record);

    Player selectByPrimaryKey(Integer playerId);

    int updateByPrimaryKeySelective(Player record);

    int updateByPrimaryKey(Player record);

    List<Player> findAll();

}