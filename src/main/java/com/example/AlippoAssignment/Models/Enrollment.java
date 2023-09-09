package com.example.AlippoAssignment.Models;

import com.example.AlippoAssignment.Enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "enrollment")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

//    private int userId ;
//    private int courseId ;
    private LocalDate entrollmentDate;
    private PaymentStatus paymentStatus ;

    //Enrollment is child wrt user
    @ManyToOne
    @JoinColumn
    private User user ;

    //Enrollment is child wrt Course
    @ManyToOne
    @JoinColumn
    private Course course ;
}
