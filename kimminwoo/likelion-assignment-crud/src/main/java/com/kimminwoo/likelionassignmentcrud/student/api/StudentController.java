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
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<String> studentSave(@RequestBody StudentSaveRequestDto studentSaveRequestDto) {
        studentService.studentSave(studentSaveRequestDto);
        return new ResponseEntity<>("사용자 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<StudentListResponseDto> studentFindAll() {
        StudentListResponseDto studentListResponseDto = studentService.studentFindAll();
        return new ResponseEntity<>(studentListResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> studentFindOne(@PathVariable("studentId") Long studentId) {
        StudentInfoResponseDto studentInfoResponseDto = studentService.studentFindOne(studentId);
        return new ResponseEntity<>(studentInfoResponseDto, HttpStatus.OK);
    }
}