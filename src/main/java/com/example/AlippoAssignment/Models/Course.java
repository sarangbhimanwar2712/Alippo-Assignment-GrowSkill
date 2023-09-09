package com.example.AlippoAssignment.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String courseName ;
    private String instructorName ;
    private int price ;
    private String description ;

    //Many to many relationship between User and Course
    @ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private List<User> userList = new ArrayList<>() ;

    //course is parent wrt class
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Class> classList = new ArrayList<>() ;

    //course is parent wrt enrollment
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Enrollment> enrollmentList = new ArrayList<>() ;

    //course is parent wrt payment
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Payment> paymentList = new ArrayList<>() ;

    //course is also parent wrt certificates
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Certificates> certificatesList = new ArrayList<>() ;
}