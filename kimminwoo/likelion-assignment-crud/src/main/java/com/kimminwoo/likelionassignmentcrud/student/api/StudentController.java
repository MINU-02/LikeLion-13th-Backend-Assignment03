package com.kimminwoo.likelionassignmentcrud.student.api;

import com.kimminwoo.likelionassignmentcrud.student.api.dto.request.StudentSaveRequestDto;
import com.kimminwoo.likelionassignmentcrud.student.api.dto.response.StudentInfoResponseDto;
import com.kimminwoo.likelionassignmentcrud.student.api.dto.response.StudentListResponseDto;
import com.kimminwoo.likelionassignmentcrud.student.application.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<String> saveStudent(@RequestBody StudentSaveRequestDto studentSaveRequestDto) {
        studentService.saveStudent(studentSaveRequestDto);
        return new ResponseEntity<>("학생 저장 완료!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<StudentListResponseDto> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> getStudentById(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }
}
