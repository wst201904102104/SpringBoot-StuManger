package com.itwst.domain;

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
public class User {
    private Integer id;
    private String username;
    private String password;
    private String competence;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
