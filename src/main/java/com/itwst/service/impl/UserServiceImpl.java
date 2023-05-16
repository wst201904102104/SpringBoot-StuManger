package com.itwst.service.impl;

import com.itwst.domain.User;
import com.itwst.mapper.UserMapper;
import com.itwst.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * name:Mir_Wang
 * Auther:1063383540@qq.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public User selByuser(String username, String userpwd) {
        return userMapper.selByUser(username,userpwd);
    }

    @Override
    public void doEnroll(User user) {
        userMapper.insert(user);
    }

    @Override
    public User doCheck(String username) {
        User user = userMapper.selByUserName(username);
        return user;
    }
}
