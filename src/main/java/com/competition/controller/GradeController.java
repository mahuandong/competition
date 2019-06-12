package com.competition.controller;

import com.competition.entity.Grade;
import com.competition.service.GradeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Resource
    private GradeService gradeService;

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
        List<Grade> gradeList = this.gradeService.findAll(page,limit);
        long total = this.gradeService.findAllTotal();
        map.put("code", 0);
        map.put("msg", "成功");
        map.put("data", gradeList);
        map.put("count",total);
        return map;
    }

    @RequestMapping(value = "findAllByGameIdAndPlayerId.json",method = {RequestMethod.GET})
    public Map<String, Object> findAllByGameIdAndPlayerId(int page, int limit, Integer gameId,Integer playerId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<Grade> gradeList = this.gradeService.findAllByGameIdAndPlayerId(page,limit,gameId,playerId);
        long total = this.gradeService.findAllByGameIdAndPlayerId(gameId,playerId);
        map.put("code", 0);
        map.put("msg", "成功");
        map.put("data", gradeList);
        map.put("count",total);
        return map;
    }

    @RequestMapping(value = "findAllByGameId.json",method = {RequestMethod.GET})
    public Map<String, Object> findAllByGameId(int page, int limit ,Integer gameId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<Grade> gradeList = this.gradeService.findAllByGameId(page,limit,gameId);
        long total = this.gradeService.findAllByGameIdTotal(gameId);
        map.put("code", 0);
        map.put("msg", "成功");
        map.put("data", gradeList);
        map.put("count",total);
        return map;
    }

    @RequestMapping(value = {"del.json"},method = {RequestMethod.POST})
    public int deleteByPrimaryKey(Integer gradeId) throws Exception{
        return this.gradeService.deleteByPrimaryKey(gradeId);
    }

    @RequestMapping (value = {"insert.json"},method = {RequestMethod.POST})
    public int insertSelective(Integer gradeId, Integer gameId, Integer playerId, Integer adminId, Double grade,
                 Integer category, String title) throws Exception{
        Grade param = new Grade();
        param.setGradeId(gradeId);
        param.setGameId(gameId);
        param.setPlayerId(playerId);
        param.setAdminId(adminId);
        param.setGrade(grade);
        return this.gradeService.insertSelective(param);
    }

    @RequestMapping (value = {"totalScore.json"},method = {RequestMethod.POST})
    public Double totalScore(Integer gameId, Integer playerId) throws Exception{
        return this.gradeService.totalGrade(gameId,playerId);
    }

    @RequestMapping (value = {"update.json"},method = {RequestMethod.POST})
    public int updateByPrimaryKeySelective(Integer gradeId, Integer gameId, Integer playerId, Integer adminId, Double grade,
               Integer category, String title) throws Exception{
        Grade param = new Grade();
        param.setGradeId(gradeId);
        param.setGameId(gameId);
        param.setPlayerId(playerId);
        param.setAdminId(adminId);
        param.setGrade(grade);
        return this.gradeService.updateByPrimaryKeySelective(param);
    }

    @RequestMapping (value = {"selectById.json"},method = {RequestMethod.GET})
    public Grade selectByPrimaryKey(Integer gradeId) throws Exception{
        return this.gradeService.selectByPrimaryKey(gradeId);
    }
}
