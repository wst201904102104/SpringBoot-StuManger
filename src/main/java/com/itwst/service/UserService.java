package com.itwst.service;

import com.itwst.domain.User;

/**
 * name:Mir_Wang
 * Auther:1063383540@qq.com
 */
public interface UserService {
    User selByuser(String username, String userpwd);

    void doEnroll(User user);

    User doCheck(String username);
}
