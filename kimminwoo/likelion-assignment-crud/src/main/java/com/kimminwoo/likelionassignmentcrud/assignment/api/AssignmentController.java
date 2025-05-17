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
@RequestMapping("/assignment")
public class AssignmentController {
    private final AssignmentService assignmentService;

    @PostMapping("/save")
    public ResponseEntity<String> assignmentSave(@RequestBody AssignmentSaveRequestDto assignmentSaveRequestDto) {
            assignmentService.assignmentSave(assignmentSaveRequestDto);
            return new ResponseEntity<>("assignment 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<AssignmentListResponseDto> myAssignmentFindAll(@PathVariable("studentId") Long studentId) {
        AssignmentListResponseDto assignmentListResponseDto = assignmentService.assignmentFindMember(studentId);
        return new ResponseEntity<>(assignmentListResponseDto, HttpStatus.OK);
    }
}
