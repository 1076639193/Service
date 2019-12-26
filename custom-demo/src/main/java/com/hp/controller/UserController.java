package com.hp.controller;


import com.hp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/custom")
public class UserController {
    @Autowired
    RestTemplate restTemplate;


    @Autowired
    private DiscoveryClient discoveryClient;
    //eureka客户端

    @GetMapping("/{i}")
    public User getUser(@PathVariable("i") Long id){
        String url="http://user-service/user/"+id;
        User user= restTemplate.getForObject(url,User.class);
        return user;
    }

//    @GetMapping("/{id}")
//    public User queryById(@PathVariable("id") Long id){
//        User user =restTemplate.getForObject("http://localhost:8089/user/"+id,User.class);
//        return user;
//    }

}
