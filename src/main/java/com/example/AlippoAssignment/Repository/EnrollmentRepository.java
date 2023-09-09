package com.example.AlippoAssignment.Repository;

import com.example.AlippoAssignment.Models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {
}
