package com.competition.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.competition.entity.Schedule;

public interface ScheduleMapper {
    int deleteByPrimaryKey(Integer scheduleId);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(Integer scheduleId);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);

    List<Schedule> findAllByGameId(@Param("gameId")Integer gameId);

    List<Schedule> findAll();

}