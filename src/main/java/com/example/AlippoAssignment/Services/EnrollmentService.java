package com.example.AlippoAssignment.Services;

import com.example.AlippoAssignment.Enums.PaymentStatus;
import com.example.AlippoAssignment.Models.Course;
import com.example.AlippoAssignment.Models.Enrollment;
import com.example.AlippoAssignment.Models.Payment;
import com.example.AlippoAssignment.Models.User;
import com.example.AlippoAssignment.Repository.CourseRepository;
import com.example.AlippoAssignment.Repository.EnrollmentRepository;
import com.example.AlippoAssignment.Repository.PaymentRepository;
import com.example.AlippoAssignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    EnrollmentRepository enrollmentRepository ;

    @Autowired
    UserRepository userRepository ;

    @Autowired
    CourseRepository courseRepository ;

    @Autowired
    PaymentRepository paymentRepository ;

    public String addEnrollment(int userId , int courseId , int paymentId){
        Enrollment enrollment = new Enrollment() ;
        Payment payment = paymentRepository.findById(paymentId).get();

        enrollment.setPaymentStatus(payment.getPaymentStatus());

        //setting attributes for user
        User user = userRepository.findById(userId).get() ;
        List<Enrollment> enrollmentList = user.getEnrollmentList() ;
        enrollmentList.add(enrollment) ;
        user = userRepository.save(user) ;

        //setting attributes for course
        Course course = courseRepository.findById(courseId).get() ;
        List<Enrollment> enrollmentList1 = course.getEnrollmentList() ;
        enrollmentList1.add(enrollment) ;
        course = courseRepository.save(course) ;

        enrollment.setUser(user);
        enrollment.setCourse(course);

        enrollmentRepository.save(enrollment) ;
        return "Course is Enrolled" ;
    }
}
