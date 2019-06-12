package com.competition.controller;

import com.competition.entity.Player;
import com.competition.service.PlayerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/player")
public class PlayerController {
    
    @Resource
    private PlayerService playerService;

    @RequestMapping(value = "findAll.json",method = {RequestMethod.GET})
    public Map<String, Object> findAll(int page, int limit) throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<Player> playerList = this.playerService.findAll(page,limit);
        long total = this.playerService.findAll();
        map.put("code", 0);
        map.put("msg", "成功");
        map.put("data", playerList);
        map.put("count",total);
        return map;
    }

    @RequestMapping(value = {"del.json"},method = {RequestMethod.POST})
    public int deleteByPrimaryKey(@Param("playerId") Integer playerId) throws Exception{
        return this.playerService.deleteByPrimaryKey(playerId);
    }

    @RequestMapping (value = {"insert.json"},method = {RequestMethod.POST})
    public int insertSelective(Integer playerId, String name, Integer age, String phone) throws Exception{
        Player param = new Player();
        param.setName(name);
        param.setAge(age);
        param.setPhone(phone);
        return this.playerService.insertSelective(param);
    }

    @RequestMapping (value = {"update.json"},method = {RequestMethod.POST})
    public int updateByPrimaryKeySelective(Integer playerId, String name, Integer age, String phone) throws Exception{
        Player param = new Player();
        param.setPlayerId(playerId);
        param.setName(name);
        param.setAge(age);
        param.setPhone(phone);
        return this.playerService.updateByPrimaryKeySelective(param);
    }

    @RequestMapping (value = {"selectById.json"},method = {RequestMethod.GET})
    public Player selectByPrimaryKey(Integer playerId) throws Exception{
        return this.playerService.selectByPrimaryKey(playerId);
    }
}
