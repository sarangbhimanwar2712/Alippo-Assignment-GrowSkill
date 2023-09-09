package com.example.AlippoAssignment.Services;

import com.example.AlippoAssignment.Models.Certificates;
import com.example.AlippoAssignment.Models.Course;
import com.example.AlippoAssignment.Models.User;
import com.example.AlippoAssignment.Repository.CertificateRepository;
import com.example.AlippoAssignment.Repository.CourseRepository;
import com.example.AlippoAssignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService {
    @Autowired
    CertificateRepository certificateRepository ;

    @Autowired
    CourseRepository courseRepository ;

    @Autowired
    UserRepository userRepository ;

    public String createCertificate(Certificates certificates ,int userId , int courseId){

        User user = userRepository.findById(userId).get() ;
        List<Certificates> certificatesList = user.getCertificatesList();
        certificatesList.add(certificates) ;
        user = userRepository.save(user) ;

        Course course = courseRepository.findById(courseId).get() ;
        List<Certificates> certificatesList1 = course.getCertificatesList();
        certificatesList1.add(certificates) ;
        course = courseRepository.save(course) ;

        certificates.setUser(user);
        certificates.setCourse(course);

        certificateRepository.save(certificates) ;
        return "Certificate is created" ;
    }

    public String downloadCertificate(int certificateId){
        Certificates certificates = certificateRepository.findById(certificateId).get() ;
        return certificates.getDownloadLink() ;
    }
}
