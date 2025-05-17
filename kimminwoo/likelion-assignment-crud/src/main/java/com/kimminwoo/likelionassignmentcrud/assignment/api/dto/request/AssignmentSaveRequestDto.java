package com.kimminwoo.likelionassignmentcrud.assignment.api.dto.request;

public record AssignmentSaveRequestDto(
        String title,
        String content,
        Long studentId
) {
}
