package com.kimminwoo.likelionassignmentcrud.student.api.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record StudentListResponseDto(
        List<StudentInfoResponseDto> students
) {
    public static StudentListResponseDto from(List<StudentInfoResponseDto> students) {
        return StudentListResponseDto.builder()
                .students(students)
                .build();
    }
}