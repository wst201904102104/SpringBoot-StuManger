package com.itwst.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * name:Mir_Wang
 * Auther:1063383540@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Stu2_Score {
    private Integer id;
    private String name;
    private Integer chinese;
    private Integer math;
    private Integer english;
    private Integer politics;
    private Integer history;
    private Integer geography;
}
