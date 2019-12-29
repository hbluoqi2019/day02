package com.offcn.mapper;

import com.offcn.pojo.User;

import java.util.List;

public interface UserMapper {
    User findByUser(User user);
    int update(User user);
    List<User> findByid(List<Integer> list);
}
