package com.kimminwoo.likelionassignmentcrud.assignment.domain.repository;

import com.kimminwoo.likelionassignmentcrud.assignment.domain.Assignment;
import com.kimminwoo.likelionassignmentcrud.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findAllByStudent(Student student);
}
