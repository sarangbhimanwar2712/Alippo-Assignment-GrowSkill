package com.example.AlippoAssignment.Models;

import com.example.AlippoAssignment.Enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "payment")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
//    private int userId ;
//    private int courseId ;
    private int amount ;
    private LocalDate paymentDate ;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus ;

    //payment is child wrt User
    @ManyToOne
    @JoinColumn
    private User user ;

    //payment is child wrt course
    @ManyToOne
    @OneToMany
    private Course course ;
}
