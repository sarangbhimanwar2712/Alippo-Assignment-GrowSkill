package com.example.AlippoAssignment.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "recordings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recordings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private int classId ;
    private int courseId ;
    private LocalTime classTime ;
    private LocalDate classDate ;
}
