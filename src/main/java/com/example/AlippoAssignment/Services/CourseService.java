package com.example.AlippoAssignment.Services;


import com.example.AlippoAssignment.Models.Course;
import com.example.AlippoAssignment.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository ;

    public String addCourse(Course course){
        courseRepository.save(course) ;
        return "Course added successfully" ;
    }

    public List<Course> getCourses(){
        List<Course> courseList = courseRepository.findAll();
        return courseList ;
    }
    public Course getCourse(int courseId){
        Course course = courseRepository.findById(courseId).get() ;
        return course ;
    }
}
