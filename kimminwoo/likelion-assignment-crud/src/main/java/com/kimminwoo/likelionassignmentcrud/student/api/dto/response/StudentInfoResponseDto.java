package com.kimminwoo.likelionassignmentcrud.student.api.dto.response;

import com.kimminwoo.likelionassignmentcrud.student.domain.Student;
import lombok.Builder;

@Builder
public record StudentInfoResponseDto(
        Long studentId,
        String name,
        String phoneNumber
) {
    public static StudentInfoResponseDto from(Student student) {
        return StudentInfoResponseDto.builder()
                .studentId(student.getStudentId())
                .name(student.getName())
                .phoneNumber(student.getPhoneNumber())
                .build();
    }
}
