package com.itwst.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.itwst.domain.Stu;
import com.itwst.domain.Stu2_Score;
import com.itwst.domain.Stu_Score;
import com.itwst.mapper.StuMapper;
import com.itwst.service.StuService;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * name:Mir_Wang
 * Auther:1063383540@qq.com
 */
@Service
public class StuServiceImpl implements StuService {

    @Resource
    private StuMapper stuMapper;
    @Override
    public List<Stu> findAll() {
        return stuMapper.findAll();
    }

    @Override
    public void addStu(Stu stu) {
        stuMapper.insert(stu);
    }

    @Override
    public void delete(String id) {
        int rows = stuMapper.deleteById(id);
        System.out.println(rows+"行 受响应");
    }

    @Override
    public int deleteWorkerSome(List<String> idList) {
        return stuMapper.deleteBatchIds(idList);
    }

    @Override
    public Stu selById(Integer id) {
        return stuMapper.selectById(id);
    }

    @Override
    public void updateStu(Stu stu) {
        int rows = stuMapper.updateById(stu);
        System.out.println(rows+"行 受响应");
    }

    @Override
    public List<Stu> selByName(String name) {
        return stuMapper.findByName(name);
    }

    @Override
    public List<Stu> selBySex(String sex) {
        return stuMapper.findBySex(sex);
    }

    @Override
    public List<Stu> selByAge(Integer age) {
        return stuMapper.findByAge(age);
    }

    @Override
    public List<Stu> selByScore(String address) {
        return stuMapper.findByScore(address);
    }

    @Override
    public List<Stu> selByTel(String tel) {
        return stuMapper.findByTel(tel);
    }

    @Override
    public List<Stu> selByClassId(String classid) {
        return stuMapper.findByClassId(classid);
    }

    @Override
    public List<Stu> selByMajor(String major) {
        return stuMapper.findByMajor(major);
    }

    @Override
    public List<Stu_Score> selByMajorScore() {
        return stuMapper.findByMajorScore();
    }

    @Override
    public void deleteByName(String name) {
        stuMapper.delByName(name);
    }

    @Override
    public void deleteWorkerSomeByName(ArrayList<String> nameList) {
        for (String s : nameList) {
            stuMapper.delByName(s);
        }
    }

    @Override
    public List<Stu2_Score> selByMajorScore2() {
        return stuMapper.findByMajorScore2();
    }

    @Override
    public void addLikeStuScore(String name,Integer chinese,Integer math,Integer english,Integer physics,Integer chemistry,Integer biology) {
        stuMapper.insertLikeScore(name,chinese,math,english,physics,chemistry,biology);
    }

    @Override
    public void addWenkeStuScore(String name, Integer chinese, Integer math, Integer english, Integer politics, Integer history, Integer geography) {
        stuMapper.insertWenkeScore(name,chinese,math,english,politics,history,geography);
    }

    @Override
    public void deleteByWenKeName(String name) {
        stuMapper.delByWenkeName(name);
    }

    @Override
    public void deleteWorkerSomeByWenKeName(ArrayList<String> nameList) {
        for (String s : nameList) {
            stuMapper.delByWenkeName(s);
        }
    }

    @Override
    public Stu_Score selByLikeName(String name) {
        return stuMapper.findLikeName(name);
    }

    @Override
    public Stu2_Score selByWenkeName(String name) {
        return stuMapper.findWenkeName(name);
    }

    @Override
    public void updateLike(Stu_Score stu) {
        stuMapper.updateByLike(stu);
    }

    @Override
    public void updateWenke(Stu2_Score stu) {
        stuMapper.updateByWenke(stu);
    }
}
