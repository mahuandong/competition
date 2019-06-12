package com.competition.serviceImpl;

import com.competition.entity.Game;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.competition.entity.Admin;
import com.competition.mapper.AdminMapper;
import com.competition.service.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Resource
    private AdminMapper adminMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public Admin selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Admin> findAllByRole(int page ,int limit, Integer role) {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(page, limit);
        // 获取
        List<Admin> adminList = adminMapper.findAllByRole(role);
        return adminList;
    }

    @Override
    public Admin findAllByAccountAndRole(String account, Integer role) {
        return adminMapper.findAllByAccountAndRole(account,role);
    }

    @Override
    public long findAllBytotal(Integer role) {
        //查询总记录数
        long total = PageHelper.count(new ISelect() {
            @Override
            public void doSelect() {
                adminMapper.findAllByRole(role);
            }
        });
        return total;
    }

}
