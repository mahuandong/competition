package com.competition.serviceImpl;

import com.competition.entity.Grade;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.competition.mapper.PlayerMapper;
import com.competition.entity.Player;
import com.competition.service.PlayerService;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Resource
    private PlayerMapper playerMapper;

    @Override
    public int deleteByPrimaryKey(Integer playerId) {
        return playerMapper.deleteByPrimaryKey(playerId);
    }

    @Override
    public int insert(Player record) {
        return playerMapper.insert(record);
    }

    @Override
    public int insertSelective(Player record) {
        return playerMapper.insertSelective(record);
    }

    @Override
    public Player selectByPrimaryKey(Integer playerId) {
        return playerMapper.selectByPrimaryKey(playerId);
    }

    @Override
    public int updateByPrimaryKeySelective(Player record) {
        return playerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Player record) {
        return playerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Player> findAll(int page, int limit) {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(page, limit);
        // 获取
        List<Player> playerList = playerMapper.findAll();
        return playerList;
    }

    @Override
    public long findAll() {
        //查询总记录数
        long total = PageHelper.count(new ISelect() {
            @Override
            public void doSelect() {
                playerMapper.findAll();
            }
        });
        return total;
    }

}
