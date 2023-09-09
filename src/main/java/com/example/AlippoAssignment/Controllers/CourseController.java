package com.example.AlippoAssignment.Controllers;



import com.example.AlippoAssignment.Models.Course;
import com.example.AlippoAssignment.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService ;

    @PostMapping("/add_course")
    public String addCourse(@RequestBody Course course){
        String ans = courseService.addCourse(course) ;
        return ans ;
    }

    @GetMapping("/get_courses")
    public List<Course> getCourses(){
        return courseService.getCourses() ;
    }

    @GetMapping("/get_course")
    private Course getCourse(@RequestParam("courseId") int courseId){
        return courseService.getCourse(courseId) ;
    }
}
