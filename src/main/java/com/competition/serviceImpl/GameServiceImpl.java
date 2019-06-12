package com.competition.serviceImpl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.competition.mapper.GameMapper;
import com.competition.entity.Game;
import com.competition.service.GameService;

import java.util.List;

@Service
public class GameServiceImpl implements GameService{

    @Resource
    private GameMapper gameMapper;

    @Override
    public int deleteByPrimaryKey(Integer cId) {
        return gameMapper.deleteByPrimaryKey(cId);
    }

    @Override
    public int insert(Game record) {
        return gameMapper.insert(record);
    }

    @Override
    public int insertSelective(Game record) {
        return gameMapper.insertSelective(record);
    }

    @Override
    public Game selectByPrimaryKey(Integer cId) {
        return gameMapper.selectByPrimaryKey(cId);
    }

    @Override
    public int updateByPrimaryKeySelective(Game record) {
        return gameMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Game record) {
        return gameMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Game> findAll(int page, int limit) {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(page, limit);
        // 获取
        List<Game> gameList = gameMapper.findAll();
        return gameList;
    }

    @Override
    public long findAllTotal() {
        //查询总记录数
        long total = PageHelper.count(new ISelect() {
            @Override
            public void doSelect() {
                gameMapper.findAll();
            }
        });
        return total;
    }

}
