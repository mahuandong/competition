package com.competition.controller;

import com.competition.entity.Schedule;
import com.competition.service.ScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    
    @Resource
    private ScheduleService scheduleService;

    @RequestMapping(value = "findAll.json",method = {RequestMethod.GET})
    public Map<String, Object> findAll(int page, int limit) throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<Schedule> scheduleList = this.scheduleService.findAll(page,limit);
        long total = this.scheduleService.findAllTotal();
        map.put("code", 0);
        map.put("msg", "成功");
        map.put("data", scheduleList);
        map.put("count",total);
        return map;
    }

    @RequestMapping(value = {"del.json"},method = {RequestMethod.POST})
    public int deleteByPrimaryKey(Integer scheduleId) throws Exception{
        return this.scheduleService.deleteByPrimaryKey(scheduleId);
    }

    @RequestMapping (value = {"insert.json"},method = {RequestMethod.POST})
    public int insertSelective(Integer scheduleId, Integer gameId, Integer playerId, String groupName, String title) throws Exception{
        Schedule param = new Schedule();
        param.setScheduleId(scheduleId);
        param.setGameId(gameId);
        param.setPlayerId(playerId);
        param.setGroupName(groupName);
        param.setTitle(title);
        return this.scheduleService.insertSelective(param);
    }

    @RequestMapping (value = {"update.json"},method = {RequestMethod.POST})
    public int updateByPrimaryKeySelective(Integer scheduleId, Integer gameId, Integer playerId, String groupName, String title) throws Exception{
        Schedule param = new Schedule();
        param.setScheduleId(scheduleId);
        param.setGameId(gameId);
        param.setPlayerId(playerId);
        param.setGroupName(groupName);
        param.setTitle(title);
        return this.scheduleService.updateByPrimaryKeySelective(param);
    }

    @RequestMapping (value = {"selectById.json"},method = {RequestMethod.GET})
    public Schedule selectByPrimaryKey(Integer scheduleId) throws Exception{
        return this.scheduleService.selectByPrimaryKey(scheduleId);
    }
}
