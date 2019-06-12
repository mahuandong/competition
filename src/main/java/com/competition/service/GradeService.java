package com.competition.service;

import com.competition.entity.Grade;

import java.util.List;

public interface GradeService{


    int deleteByPrimaryKey(Integer gradeId);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer gradeId);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);

    List<Grade> findAllByGameId(int page,int limit, Integer gameId);

    List<Grade> findAllByGameIdAndPlayerId(int page,int limit, Integer gameId,Integer playerId);

    List<Grade> findAll(int page,int limit);

    long findAllByGameIdTotal(Integer gameId);

    long findAllByGameIdAndPlayerId(Integer gameId,Integer playerId);

    long findAllTotal();

    Double totalGrade(Integer gameId,Integer playerId);

}
