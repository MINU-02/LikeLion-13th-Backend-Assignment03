package com.kimminwoo.likelionassignmentcrud.student.application;


import com.kimminwoo.likelionassignmentcrud.student.api.dto.request.StudentSaveRequestDto;
import com.kimminwoo.likelionassignmentcrud.student.api.dto.response.StudentInfoResponseDto;
import com.kimminwoo.likelionassignmentcrud.student.api.dto.response.StudentListResponseDto;
import com.kimminwoo.likelionassignmentcrud.student.domain.Student;
import com.kimminwoo.likelionassignmentcrud.student.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public void studentSave(StudentSaveRequestDto studentSaveRequestDto) {
        Student student = Student.builder()
                .name(studentSaveRequestDto.name())
                .phoneNumber(studentSaveRequestDto.phoneNumber())
                .build();
        studentRepository.save(student);
    }

    public StudentListResponseDto studentFindAll() {
        List<Student> students = studentRepository.findAll();

        List<StudentInfoResponseDto> studentInfoResponseDtoList = students.stream()
                .map(StudentInfoResponseDto::from)
                .toList();
        return StudentListResponseDto.from(studentInfoResponseDtoList);
    }

    public StudentInfoResponseDto studentFindOne(Long studentId) {
        Student student = studentRepository
                .findById(studentId)
                .orElseThrow(IllegalArgumentException::new);
        return StudentInfoResponseDto.from(student);
    }
}
