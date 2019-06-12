package com.competition.controller;

import com.competition.entity.Admin;
import com.competition.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class AdminController {

    @Resource
    private AdminService adminService;

    @RequestMapping(value = {"login.json"},method = {RequestMethod.POST})
    public @ResponseBody
    Map<String,Object> login(String account, String password, Integer role) throws Exception{
        Map<String,Object> map = new HashMap<>();
        Admin admin = this.adminService.findAllByAccountAndRole(account,role);
        if (admin == null){
            map.put("result",4041);
            map.put("message","用户名不存在");
        }else if (password.equals(admin.getPassword())){
            //登陆成功
            map.put("result",2001);
            map.put("user",admin);
            map.put("message","登录成功");
        } else {
            map.put("result",4042);
            map.put("message","密码错误");
        }
        return map;
    }

    /**
     *
     * @Title: Map<String, Object> findAll
     * @Description: 获取设备列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findAllByRole.json",method = {RequestMethod.GET})
    public Map<String, Object> findAllByRole(int page, int limit, Integer role) throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<Admin> userList = this.adminService.findAllByRole(page,limit,role);
        long total = this.adminService.findAllBytotal(role);
        map.put("code", 0);
        map.put("msg", "成功");
        map.put("data", userList);
        map.put("count",total);
        return map;
    }

    @RequestMapping(value = {"del.json"},method = {RequestMethod.POST})
    public @ResponseBody
    int deleteByPrimaryKey(Integer id) throws Exception{
        return this.adminService.deleteByPrimaryKey(id);
    }

    @RequestMapping (value = {"insert.json"},method = {RequestMethod.POST})
    public @ResponseBody
    int insertSelective(Integer id, String name, String account, String password, Integer role) throws Exception{
        Admin param = new Admin();
        param.setAdminName(name);
        param.setAccount(account);
        param.setPassword(password);
        param.setRole(role);
        return this.adminService.insertSelective(param);
    }

    @RequestMapping (value = {"update.json"},method = {RequestMethod.POST})
    public @ResponseBody
    int updateByPrimaryKeySelective(Integer id, String name, String account, String password, Integer role) throws Exception{
        Admin param = new Admin();
        param.setId(id);
        param.setAdminName(name);
        param.setAccount(account);
        param.setPassword(password);
        param.setRole(role);
        return this.adminService.updateByPrimaryKeySelective(param);
    }

    @RequestMapping (value = {"selectById.json"},method = {RequestMethod.GET})
    public @ResponseBody
    Admin selectByPrimaryKey(Integer userId) throws Exception{
        return this.adminService.selectByPrimaryKey(userId);
    }
}
