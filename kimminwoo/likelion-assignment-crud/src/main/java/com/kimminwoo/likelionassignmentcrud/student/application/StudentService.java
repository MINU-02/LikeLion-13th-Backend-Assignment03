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
    public void saveStudent(StudentSaveRequestDto studentSaveRequestDto) {
        Student student = Student.builder()
                .name(studentSaveRequestDto.name())
                .phoneNumber(studentSaveRequestDto.phoneNumber())
                .build();

        studentRepository.save(student);
    }

    public StudentListResponseDto getAllStudents() {
        List<Student> students = studentRepository.findAll();

        List<StudentInfoResponseDto> studentInfoList = students.stream()
                .map(StudentInfoResponseDto::from)
                .toList();

        return StudentListResponseDto.from(studentInfoList);
    }

    public StudentInfoResponseDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new IllegalArgumentException("해당 학생을 찾을 수 없습니다. ID: " + studentId));

        return StudentInfoResponseDto.from(student);
    }
}
