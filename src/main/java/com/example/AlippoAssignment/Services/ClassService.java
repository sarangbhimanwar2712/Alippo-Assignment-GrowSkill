package com.example.AlippoAssignment.Services;

import com.example.AlippoAssignment.Controllers.ClassController;
import com.example.AlippoAssignment.Models.Class;
import com.example.AlippoAssignment.Models.Course;
import com.example.AlippoAssignment.Repository.ClassRepository;
import com.example.AlippoAssignment.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassRepository classRepository ;

    @Autowired
    CourseRepository courseRepository ;
    public String addClass(Class cls, int courseId){

        Course course = courseRepository.findById(courseId).get();
        List<Class> classList = course.getClassList();
        classList.add(cls) ;

        cls.setCourse(course);

        classRepository.save(cls) ;
        return "classAdded" ;
    }



}

