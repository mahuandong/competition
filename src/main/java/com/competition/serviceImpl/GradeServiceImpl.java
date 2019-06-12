package com.competition.serviceImpl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.competition.mapper.GradeMapper;
import com.competition.entity.Grade;
import com.competition.service.GradeService;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService{

    @Resource
    private GradeMapper gradeMapper;

    @Override
    public int deleteByPrimaryKey(Integer gradeId) {
        return gradeMapper.deleteByPrimaryKey(gradeId);
    }

    @Override
    public int insert(Grade record) {
        return gradeMapper.insert(record);
    }

    @Override
    public int insertSelective(Grade record) {
        List<Grade> gradeList = this.gradeMapper.findAllByGameIdAndPlayerIdAndAdminId(record.getGameId(),record.getPlayerId(),record.getAdminId());
        if (gradeList.size()!=0){
            return 0;
        }else {
            return gradeMapper.insertSelective(record);
        }
    }

    @Override
    public Grade selectByPrimaryKey(Integer gradeId) {
        return gradeMapper.selectByPrimaryKey(gradeId);
    }

    @Override
    public int updateByPrimaryKeySelective(Grade record) {
        return gradeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Grade record) {
        return gradeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Grade> findAllByGameId(int page, int limit, Integer gameId) {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(page, limit);
        // 获取
        List<Grade> gradeList = gradeMapper.findAllByGameId(gameId);
        return gradeList;
    }

    @Override
    public List<Grade> findAllByGameIdAndPlayerId(int page, int limit, Integer gameId, Integer playerId) {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(page, limit);
        // 获取
        List<Grade> gradeList = gradeMapper.findAllByGameIdAndPlayerId(gameId,playerId);
        return gradeList;
    }

    @Override
    public List<Grade> findAll(int page, int limit) {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(page, limit);
        // 获取
        List<Grade> gradeList = gradeMapper.findAll();
        return gradeList;
    }

    @Override
    public long findAllByGameIdTotal(Integer gameId) {
        //查询总记录数
        long total = PageHelper.count(new ISelect() {
            @Override
            public void doSelect() {
                gradeMapper.findAllByGameId(gameId);
            }
        });
        return total;
    }

    @Override
    public long findAllByGameIdAndPlayerId(Integer gameId, Integer playerId) {
        //查询总记录数
        long total = PageHelper.count(new ISelect() {
            @Override
            public void doSelect() {
                gradeMapper.findAllByGameIdAndPlayerId(gameId,playerId);
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
                gradeMapper.findAll();
            }
        });
        return total;
    }

    @Override
    public Double totalGrade(Integer gameId, Integer playerId) {
        List<Grade> gradeList = gradeMapper.findAllByGameIdAndPlayerId(gameId,playerId);
        Double[] myList = new Double[gradeList.size()];
        for (int i=0;i<gradeList.size();i++){
            myList[i] =gradeList.get(i).getGrade();
        }
        //冒泡排序实现
        for(int i=0;i<myList.length-1;i++){
            for(int j=0;j<myList.length-i-1;j++){
                if(myList[j]>myList[j+1]){
                        Double temp = myList[j];
                        myList[j] = myList[j+1];
                        myList[j+1] = temp;
                    }
            }
        }
        Double total=0.0;
        //去掉最高分和最低分
        for (int i=1;i<myList.length-1;i++) {
            total += myList[i];
        }
        total = total/(myList.length-2);
//        Grade param = new Grade();
//        param.setGameId(gameId);
//        param.setPlayerId(playerId);
//        param.setAdminId(1);
//        param.setGrade(total);
        DecimalFormat df = new DecimalFormat("#.00");
        Double score = Double.valueOf(df.format(total));
        return score;
    }

}
