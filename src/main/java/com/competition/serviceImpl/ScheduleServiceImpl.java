package com.competition.serviceImpl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.competition.entity.Schedule;
import com.competition.mapper.ScheduleMapper;
import com.competition.service.ScheduleService;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Resource
    private ScheduleMapper scheduleMapper;

    @Override
    public int deleteByPrimaryKey(Integer scheduleId) {
        return scheduleMapper.deleteByPrimaryKey(scheduleId);
    }

    @Override
    public int insert(Schedule record) {
        return scheduleMapper.insert(record);
    }

    @Override
    public int insertSelective(Schedule record) {
        return scheduleMapper.insertSelective(record);
    }

    @Override
    public Schedule selectByPrimaryKey(Integer scheduleId) {
        return scheduleMapper.selectByPrimaryKey(scheduleId);
    }

    @Override
    public int updateByPrimaryKeySelective(Schedule record) {
        return scheduleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Schedule record) {
        return scheduleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Schedule> findAllByGameId(int page, int limit, Integer gameId) {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(page, limit);
        // 获取
        List<Schedule> scheduleList = scheduleMapper.findAllByGameId(gameId);
        return scheduleList;
    }

    @Override
    public List<Schedule> findAll(int page, int limit) {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(page, limit);
        // 获取
        List<Schedule> scheduleList = scheduleMapper.findAll();
        return scheduleList;
    }

    @Override
    public long findAllByGameIdTotal(Integer gameId) {
        //查询总记录数
        long total = PageHelper.count(new ISelect() {
            @Override
            public void doSelect() {
                scheduleMapper.findAllByGameId(gameId);
            }
        });
        return total;
    }

    @Override
    public long findAllTotal() {
        //查询总记录数
        long total = PageHelper.count(new ISelect() {
            @Override
            public void doSelect() {
                scheduleMapper.findAll();
            }
        });
        return total;
    }

}
