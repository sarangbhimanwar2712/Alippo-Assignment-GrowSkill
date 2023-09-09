package com.example.AlippoAssignment.Repository;

import com.example.AlippoAssignment.Models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class,Integer> {
}
