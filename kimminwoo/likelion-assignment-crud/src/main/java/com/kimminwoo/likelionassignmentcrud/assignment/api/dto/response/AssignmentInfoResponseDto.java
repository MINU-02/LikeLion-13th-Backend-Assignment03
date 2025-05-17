package com.kimminwoo.likelionassignmentcrud.assignment.api.dto.response;

import com.kimminwoo.likelionassignmentcrud.assignment.domain.Assignment;
import lombok.Builder;

@Builder
public record AssignmentInfoResponseDto(
        Long assignmentId,
        String title,
        String content,
        Long studentId
) {
    public static AssignmentInfoResponseDto from(Assignment assignment) {
        return AssignmentInfoResponseDto.builder()
                .assignmentId(assignment.getAssignmentId())
                .title(assignment.getTitle())
                .content(assignment.getContent())
                .studentId(assignment.getStudent().getStudentId())
                .build();
    }
}
