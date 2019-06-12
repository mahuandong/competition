package com.competition.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.competition.entity.Grade;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer gradeId);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer gradeId);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);

    List<Grade> findAllByGameId(@Param("gameId")Integer gameId);

    List<Grade> findAllByGameIdAndPlayerId(@Param("gameId")Integer gameId,@Param("playerId")Integer playerId);

    List<Grade> findAll();

    List<Grade> findAllByGameIdAndPlayerIdAndAdminId(@Param("gameId")Integer gameId,@Param("playerId")Integer playerId,@Param("adminId")Integer adminId);

}