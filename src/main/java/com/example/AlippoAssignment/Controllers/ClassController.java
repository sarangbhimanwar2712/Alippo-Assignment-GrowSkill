package com.example.AlippoAssignment.Controllers;

import com.example.AlippoAssignment.Models.Class;
import com.example.AlippoAssignment.Services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    ClassService classService ;


    @PostMapping("add_class")
    public String addClass(@RequestBody Class cls, @RequestParam("courseId")int courseId){
        String ans= classService.addClass(cls, courseId);
        return ans;
    }
}
