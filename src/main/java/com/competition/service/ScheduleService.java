package com.competition.service;

import com.competition.entity.Schedule;
import java.util.List;

public interface ScheduleService{


    int deleteByPrimaryKey(Integer scheduleId);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(Integer scheduleId);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);

    List<Schedule> findAllByGameId(int page,int limit, Integer gameId);

    List<Schedule> findAll(int page,int limit);

    long findAllByGameIdTotal(Integer gameId);

    long findAllTotal();

}
