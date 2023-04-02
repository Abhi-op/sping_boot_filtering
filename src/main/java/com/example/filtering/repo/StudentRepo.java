package com.example.filtering.repo;

import com.example.filtering.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
       //Select * from student where name = ?
        Student findByName(String name);


        List<Student> findByAddressCity(String city);


        List<Student> findBySubjectsName(String subjectName);

}
