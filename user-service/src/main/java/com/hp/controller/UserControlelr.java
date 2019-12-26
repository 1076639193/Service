package com.hp.controller;

import com.hp.pojo.User;
import com.hp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControlelr {
    @Autowired
     private UserService userService;

    /**
     * 测试
     * 根据id查询数据库
     */
    //get 方式提交
/*
    @GetMapping("/{id}")
    public User queryUserById(@PathVariable("id") int i ){
       User user = userService.queryUserById(i);
        return  user ;
    }
*/

    @GetMapping("/del/{ids}")
    @ResponseBody
    public String deleteUserById(@PathVariable("ids") Long i){
         userService.deleteUserById(i);
        return "success";
    }

    @GetMapping("list")
    public String queryAllUser(Model model){
        List<User> list =userService.queryAllUser();
        model.addAttribute("users",list);
         return "item";
    }



}
