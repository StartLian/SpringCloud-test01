package com.homepage_user.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.homepage.common.UserInfo;
import com.homepage_user.service.IUserService;
import com.homepage_user.vo.CreateUserRequest;
import com.homepage_user.vo.UserCourseInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * <h1>用户对外服务接口</h1>
 * Created by Qinyi.
 */
@Slf4j
@RestController
public class HomepageUserController {
	Logger log = (Logger) LoggerFactory.getLogger(HomepageUserController.class);
    /** 用户服务 */
    private final IUserService userService;

    @Autowired
    public HomepageUserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * <h2>创建用户</h2>
     * 127.0.0.1:7000/homepage-user/create/user
     * 127.0.0.1:9000/imooc/homepage-user/create/user
     * {
     * 	"username": "qinyi_01",
     * 	"email": "qinyi_01@imooc.com"
     * }
     * */
    @PostMapping("/create/user")
    public UserInfo createUser(@RequestBody CreateUserRequest request) {
    	HashMap<String,Object> hashMap = new HashMap<>();
        log.info("<homepage-user>: create user -> {}", JSON.toJSONString(request));
        UserInfo createUser = userService.createUser(request);
        log.info("<homepage-user>: create user createUser-> {}", createUser.toString());
        hashMap.put("createUser", createUser);
        return createUser;
    }

    /**
     * <h2>获取用户信息</h2>
     * 127.0.0.1:7000/homepage-user/get/user?id=
     * 127.0.0.1:9000/imooc/homepage-user/get/user?id=
     * */
    @GetMapping("/get/user")
    public UserInfo getUserInfo(Long id) {

        log.info("<homepage-user>: get user -> {}", id);
        return userService.getUserInfo(id);
    }

    /**
     * <h2>获取用户课程信息</h2>
     * 127.0.0.1:7000/homepage-user/get/user/course?id=
     * 127.0.0.1:9000/imooc/homepage-user/get/user/course?id=
     * */
    @GetMapping("/get/user/course")
    public UserCourseInfo getUserCourseInfo(Long id) {

        log.info("<homepage-user>: get user course info -> {}", id);
        return userService.getUserCourseInfo(id);
    }
}

