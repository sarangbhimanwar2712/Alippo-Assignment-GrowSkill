package com.example.AlippoAssignment.Controllers;

import com.example.AlippoAssignment.Models.User;
import com.example.AlippoAssignment.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService ;

    @PostMapping("/add_user")
    public String addUser(@RequestBody User user){
        String ans = userService.addUser(user) ;
        return ans ;
    }

    @GetMapping("/login_user")
    public User loginUser (@RequestParam("email") String email , @RequestParam("password") String password){
        User user = userService.loginUser(email,password) ;
        return user ;
    }
}
