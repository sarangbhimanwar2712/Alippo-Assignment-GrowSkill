package com.example.AlippoAssignment.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "certificates")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Certificates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
//    private int userId;
//    private int courseId ;
    private LocalDate issueDate ;
    private String downloadLink ;

    //certificates is child wrt user
    @ManyToOne
    @JoinColumn
    private User user ;

    //certificate is also child wrt course
    @ManyToOne
    @JoinColumn
    private Course course ;
}
