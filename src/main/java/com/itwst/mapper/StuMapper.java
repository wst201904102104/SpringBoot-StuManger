package com.itwst.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itwst.domain.Stu;
import com.itwst.domain.Stu2_Score;
import com.itwst.domain.Stu_Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * name:Mir_Wang
 * Auther:1063383540@qq.com
 */
@Mapper
public interface StuMapper extends BaseMapper<Stu> {

    @Select("select * from stu")
    List<Stu> findAll();

    @Select("select * from stu where name=#{name}")
    List<Stu> findByName(String name);

    @Select("select * from stu where sex=#{sex}")
    List<Stu> findBySex(String sex);

    @Select("select * from stu where age=#{age}")
    List<Stu> findByAge(Integer age);

    @Select("select * from stu where address=#{address}")
    List<Stu> findByScore(String address);

    @Select("select * from stu where tel like CONCAT('%',#{tel},'%')")
    List<Stu> findByTel(String tel);

    @Select("select * from stu where classid=#{classid}")
    List<Stu> findByClassId(String classid);

    @Select("select * from stu where major=#{major}")
    List<Stu> findByMajor(String major);

    @Select("select * from stu_score")
    List<Stu_Score> findByMajorScore();

    @Select("select * from stu2_score")
    List<Stu2_Score> findByMajorScore2();

    @Update("delete from stu_score where name=#{name}")
    void delByName(String name);

    @Update("delete from stu2_score where name=#{name}")
    void delByWenkeName(String name);

    @Update("INSERT INTO `stu_score`(`name`, `chinese`, `math`, `english`, `physics`, `chemistry`, `biology`) VALUES (#{name}, #{chinese}, #{math}, #{english}, #{physics}, #{chemistry}, #{biology})")
    void insertLikeScore(@Param("name") String name,@Param("chinese") Integer chinese,@Param("math") Integer math,@Param("english") Integer english,@Param("physics") Integer physics,@Param("chemistry") Integer chemistry,@Param("biology") Integer biology);

    @Update("INSERT INTO `stu2_score`(`name`, `chinese`, `math`, `english`, `politics`, `history`, `geography`) VALUES (#{name}, #{chinese}, #{math}, #{english}, #{politics}, #{history}, #{geography})")
    void insertWenkeScore(@Param("name") String name,@Param("chinese") Integer chinese,@Param("math") Integer math,@Param("english") Integer english,@Param("politics") Integer politics,@Param("history") Integer history,@Param("geography") Integer geography);

    @Select("select * from stu_score where name=#{name}")
    Stu_Score findLikeName(String name);

    @Select("select * from stu2_score where name=#{name}")
    Stu2_Score findWenkeName(String name);

    @Update("update stu_score set name=#{name},chinese=#{chinese},math=#{math},english=#{english},physics=#{physics},chemistry=#{chemistry},biology=#{biology} where id=#{id}")
    void updateByLike(Stu_Score stu);

    @Update("update stu2_score set name=#{name},chinese=#{chinese},math=#{math},english=#{english},politics=#{politics},history=#{history},geography=#{geography} where id=#{id}")
    void updateByWenke(Stu2_Score stu);
}
