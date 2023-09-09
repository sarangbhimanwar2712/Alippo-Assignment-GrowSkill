package com.example.AlippoAssignment.Controllers;

import com.example.AlippoAssignment.Models.Certificates;
import com.example.AlippoAssignment.Services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    @Autowired
    CertificateService certificateService ;

    @PostMapping("/create_certificate")
    public String createCertificate(@RequestBody Certificates certificates , @RequestParam("userId")int userId ,
                                    @RequestParam("courseId") int courseId ){
        return certificateService.createCertificate(certificates ,userId,courseId) ;
    }

    @GetMapping("/get-certificates")
    public String downloadCertificate(@RequestParam("certificateId") int certificateId){
        return certificateService.downloadCertificate(certificateId) ;
    }
}
