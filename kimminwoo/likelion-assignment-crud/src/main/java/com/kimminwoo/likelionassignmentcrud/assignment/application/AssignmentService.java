package com.kimminwoo.likelionassignmentcrud.assignment.application;


import com.kimminwoo.likelionassignmentcrud.assignment.api.dto.request.AssignmentSaveRequestDto;
import com.kimminwoo.likelionassignmentcrud.assignment.api.dto.response.AssignmentInfoResponseDto;
import com.kimminwoo.likelionassignmentcrud.assignment.api.dto.response.AssignmentListResponseDto;
import com.kimminwoo.likelionassignmentcrud.assignment.domain.Assignment;
import com.kimminwoo.likelionassignmentcrud.assignment.domain.repository.AssignmentRepository;
import com.kimminwoo.likelionassignmentcrud.student.domain.Student;
import com.kimminwoo.likelionassignmentcrud.student.domain.repository.StudentRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AssignmentService {

    private final StudentRepository studentRepository;
    private final AssignmentRepository assignmentRepository;

    @Transactional
    public void assignmentSave(AssignmentSaveRequestDto assignmentSaveRequestDto) {
        Student student = studentRepository.findById(assignmentSaveRequestDto.studentId())
                .orElseThrow(IllegalArgumentException::new);

        Assignment assignment = Assignment.builder()
                .title(assignmentSaveRequestDto.title())
                .content(assignmentSaveRequestDto.content())
                .student(student)
                .build();
        assignmentRepository.save(assignment);
    }

    public AssignmentListResponseDto assignmentFindMember(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(IllegalArgumentException::new);
        List<Assignment> assignments = assignmentRepository.findAllByStudent(student);
        List<AssignmentInfoResponseDto> assignmentInfoResponseDtos = assignments.stream()
                .map(AssignmentInfoResponseDto::from)
                .toList();

        return AssignmentListResponseDto.from(assignmentInfoResponseDtos);
    }

}
