package com.example.AlippoAssignment.Controllers;

import com.example.AlippoAssignment.Enums.PaymentStatus;
import com.example.AlippoAssignment.Models.Enrollment;
import com.example.AlippoAssignment.Services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    @Autowired
    EnrollmentService enrollmentService ;

    @PostMapping("/enroll")
    public String enrollCourse(@RequestParam("userId") int userId , @RequestParam("courseId")int courseId ,
                               @RequestParam("paymentId") int paymentId){
        return enrollmentService.addEnrollment( userId , courseId ,paymentId) ;
    }
}
