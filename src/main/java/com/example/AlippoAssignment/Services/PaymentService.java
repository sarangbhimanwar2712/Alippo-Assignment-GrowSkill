package com.example.AlippoAssignment.Services;

import com.example.AlippoAssignment.Models.Course;
import com.example.AlippoAssignment.Models.Payment;
import com.example.AlippoAssignment.Models.User;
import com.example.AlippoAssignment.Repository.CourseRepository;
import com.example.AlippoAssignment.Repository.PaymentRepository;
import com.example.AlippoAssignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository ;

    @Autowired
    UserRepository userRepository ;

    @Autowired
    CourseRepository courseRepository ;
    public String addPayment(Payment payment , int userId , int courseId){
        User user = userRepository.findById(userId).get() ;
        Course course = courseRepository.findById(courseId).get() ;

        List<Payment> paymentList = user.getPaymentList();
        paymentList.add(payment) ;
        user = userRepository.save(user) ;

        List<Payment> paymentList1 = course.getPaymentList() ;
        paymentList1.add(payment) ;
        course = courseRepository.save(course) ;

        payment.setUser(user);
        payment.setCourse(course);

        paymentRepository.save(payment) ;
        return "Done Payment" ;
    }

    public Payment getPaymentDetail(int paymentId){
        Payment payment = paymentRepository.findById(paymentId).get() ;
        return payment ;
    }
}
