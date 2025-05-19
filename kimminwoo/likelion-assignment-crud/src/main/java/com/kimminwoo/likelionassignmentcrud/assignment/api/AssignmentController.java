package com.kimminwoo.likelionassignmentcrud.assignment.api;

import com.kimminwoo.likelionassignmentcrud.assignment.api.dto.request.AssignmentSaveRequestDto;
import com.kimminwoo.likelionassignmentcrud.assignment.api.dto.response.AssignmentListResponseDto;
import com.kimminwoo.likelionassignmentcrud.assignment.application.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<String> saveAssignment(@RequestBody AssignmentSaveRequestDto requestDto) {
        assignmentService.saveAssignment(requestDto);
        return new ResponseEntity<>("과제 저장 완료", HttpStatus.CREATED);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<AssignmentListResponseDto> getAssignmentsByStudentId(@PathVariable Long studentId) {
        return new ResponseEntity<>(assignmentService.getAssignmentsByStudentId(studentId), HttpStatus.OK);
    }
}
