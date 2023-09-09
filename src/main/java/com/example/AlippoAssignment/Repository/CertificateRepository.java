package com.example.AlippoAssignment.Repository;


import com.example.AlippoAssignment.Models.Certificates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificates,Integer> {
}
