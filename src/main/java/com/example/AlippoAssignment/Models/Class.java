package com.example.AlippoAssignment.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

@Entity
@Table(name = "class")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
//    private int courseId;
    private LocalDate localDate ;
    private LocalTime localTime ;
    private String topic ;
    private String zoomLink ;

    //Class is child wrt Course
    @ManyToOne
    @JoinColumn
    private Course course ;
}
