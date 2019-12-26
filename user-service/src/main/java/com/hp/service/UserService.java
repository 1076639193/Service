package com.hp.service;

import com.hp.mapper.UserMapper;
import com.hp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
   private UserMapper userMapper;


    //根据id查询数据
    public User queryUserById(int i) {
      return userMapper.selectByPrimaryKey(i);
    }

    /**
     * 删除
     * */
    @Transactional
    public void deleteUserById(Long i) {
        userMapper.deleteByPrimaryKey(i);
    }

    /**
     * 显示
     * */
    public List<User> queryAllUser() {
       return   userMapper.selectAll();
    }
}
