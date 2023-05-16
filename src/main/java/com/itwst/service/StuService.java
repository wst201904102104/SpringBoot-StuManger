package com.itwst.service;

import com.itwst.domain.Stu;
import com.itwst.domain.Stu2_Score;
import com.itwst.domain.Stu_Score;

import java.util.ArrayList;
import java.util.List;

/**
 * name:Mir_Wang
 * Auther:1063383540@qq.com
 */
public interface StuService {
    List<Stu> findAll();

    void addStu(Stu stu);

    void delete(String id);

    int deleteWorkerSome(List<String> idList);

    Stu selById(Integer id);

    void updateStu(Stu stu);

    List<Stu> selByName(String name);

    List<Stu> selBySex(String sex);

    List<Stu> selByAge(Integer age);

    List<Stu> selByScore(String address);

    List<Stu> selByTel(String tel);

    List<Stu> selByClassId(String classid);

    List<Stu> selByMajor(String major);

    List<Stu_Score> selByMajorScore();

    void deleteByName(String name);

    void deleteWorkerSomeByName(ArrayList<String> nameList);

    List<Stu2_Score> selByMajorScore2();

    void addLikeStuScore(String name,Integer chinese,Integer math,Integer english,Integer physics,Integer chemistry,Integer biology);

    void addWenkeStuScore(String name, Integer chinese, Integer math, Integer english, Integer politics, Integer history, Integer geography);

    void deleteByWenKeName(String name);

    void deleteWorkerSomeByWenKeName(ArrayList<String> nameList);

    Stu_Score selByLikeName(String name);

    Stu2_Score selByWenkeName(String name);

    void updateLike(Stu_Score stu);

    void updateWenke(Stu2_Score stu);
}
