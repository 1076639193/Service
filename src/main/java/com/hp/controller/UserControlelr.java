package com.hp.controller;

import com.hp.pojo.User;
import com.hp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("hello")
public class UserControlelr {
    @Autowired
     private UserService userService;

   @RequestMapping("word")
   @ResponseBody
    public String say(){
       System.out.println("123");
      return "success";
   }

    /**
     * 测试
     * 根据id查询数据库
     */
    //get 方式提交
    @GetMapping("/{id}")
   // @RequestMapping( value = "user/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User queryUserById(@PathVariable("id") int i ){
       User user = userService.queryUserById(i);
     //   User user =new User(1,"123",15,"123","1");
        return  user ;
    }

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
