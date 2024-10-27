package com.Hibernate.Java.Hibernate.Controller;

import ch.qos.logback.classic.pattern.LineSeparatorConverter;
import com.Hibernate.Java.Hibernate.Entity.UserEntity;
import com.Hibernate.Java.Hibernate.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/tests")
    public String testAPI(){
        return "This is a test";
    }

    @GetMapping("/get/tomcatEnv")
    public String getEnvironment(){
        return userService.getEnv();
    }

    @GetMapping("/allUsers")
    public List<UserEntity> getAllUser(){
        return userService.getUsers();
    }

    @GetMapping("/getUser/{userId}")
    public UserEntity getUser(@PathVariable Long userId){
        return userService.getuser(userId);
    }
    @PostMapping("/addUser")
    public UserEntity addUser(@RequestBody UserEntity user){
        return userService.addUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public boolean deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }

    @GetMapping("/login/data")
    public List<UserEntity> getUserbyUsernameAndPassword(@RequestParam String username, @RequestParam String password){
        return userService.getUsersBy(username, password);
    }

    @GetMapping("/custom/getuserbyUsername")
    public List<UserEntity> getUserByusername(@RequestParam String username){
        return userService.getUserByCustomQuery(username);
    }
}
