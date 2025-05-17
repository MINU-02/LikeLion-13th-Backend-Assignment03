package com.kimminwoo.likelionassignmentcrud.student.domain.repository;

import com.kimminwoo.likelionassignmentcrud.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
