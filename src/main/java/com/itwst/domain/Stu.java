package com.itwst.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * name:Mir_Wang
 * Auther:1063383540@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stu {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String address;
    private String tel;
    private String classid;

    private String major;

    public Stu(String name, String sex, Integer age, String address, String tel, String classid,String major) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.tel = tel;
        this.classid = classid;
        this.major = major;
    }
}
