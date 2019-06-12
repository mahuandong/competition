package com.competition.controller;

import com.competition.entity.Game;
import com.competition.service.GameService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/game")
public class GameController {
    
    @Resource
    private GameService gameService;

    /**
     *
     * @Title: Map<String, Object> findAll
     * @Description: 获取设备列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findAll.json",method = {RequestMethod.GET})
    public Map<String, Object> findAll(int page, int limit) throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<Game> gameList = this.gameService.findAll(page,limit);
        long total = this.gameService.findAllTotal();
        map.put("code", 0);
        map.put("msg", "成功");
        map.put("data", gameList);
        map.put("count",total);
        return map;
    }

    @RequestMapping(value = {"del.json"},method = {RequestMethod.POST})
    public int deleteByPrimaryKey(Integer cId) throws Exception{
        return this.gameService.deleteByPrimaryKey(cId);
    }

    @RequestMapping (value = {"insert.json"},method = {RequestMethod.POST})
    public int insertSelective(Integer cId, String gameName, String startTime, String endTime, String details) throws Exception{
        Game param = new Game();
        param.setGameName(gameName);
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        param.setStartTime(formatter.parse(startTime));
        param.setEndTime(formatter.parse(endTime));
        param.setDetails(details);
        return this.gameService.insertSelective(param);
    }

    @RequestMapping (value = {"update.json"},method = {RequestMethod.POST})
    public int updateByPrimaryKeySelective(Integer cId, String gameName, String startTime, String endTime, String details) throws Exception{
        Game param = new Game();
        param.setcId(cId);
        param.setGameName(gameName);
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        if ( startTime == null || startTime == ""){ }else { param.setStartTime(formatter.parse(startTime)); }
        if ( endTime == null || endTime == ""){ }else { param.setEndTime(formatter.parse(endTime)); }
        param.setDetails(details);
        return this.gameService.updateByPrimaryKeySelective(param);
    }

    @RequestMapping (value = {"selectById.json"},method = {RequestMethod.GET})
    public Game selectByPrimaryKey(Integer cId) throws Exception{
        return this.gameService.selectByPrimaryKey(cId);
    }
}
