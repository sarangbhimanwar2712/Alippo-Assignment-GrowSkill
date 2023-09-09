package com.example.AlippoAssignment.Services;

import com.example.AlippoAssignment.Models.User;
import com.example.AlippoAssignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository ;

    public String addUser(User user){
        userRepository.save(user) ;
        return "user add sucessfully" ;
    }
    public User getUser(int userId){
        User user = userRepository.findById(userId).get();
        return user ;
    }
    public User loginUser(String email ,String password){
        List<User> userList = userRepository.findAll() ;

        for(User user :userList){
            String userEmail = user.getEmail();
            String userPass = user.getPassword() ;
            if(userEmail==email && userPass==password){
                return user ;
            }
        }
        return null ;
    }
}
