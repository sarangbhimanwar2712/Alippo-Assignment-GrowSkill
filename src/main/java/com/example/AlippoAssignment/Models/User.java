package com.example.AlippoAssignment.Models;


import com.example.AlippoAssignment.Enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName ;
    @Column(unique = true)
    private String email ;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Roles roles ;

    //Many to many relationship between User and Course
    @ManyToMany
    @JoinColumn
    private List<Course> courses = new ArrayList<>() ;

    //User is parent wrt enrollment
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Enrollment> enrollmentList = new ArrayList<>() ;

    //User is parent wrt Payment
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Payment> paymentList = new ArrayList<>() ;

    //user is parent wrt certificates
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Certificates> certificatesList = new ArrayList<>() ;

}
