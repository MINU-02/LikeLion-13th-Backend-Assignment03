package com.kimminwoo.likelionassignmentcrud.assignment.api.dto.response;


import lombok.Builder;

import java.util.List;

@Builder
public record AssignmentListResponseDto(
        List<AssignmentInfoResponseDto> assignments
) {
    public static AssignmentListResponseDto from(List<AssignmentInfoResponseDto> assignments) {
        return AssignmentListResponseDto.builder()
                .assignments(assignments)
                .build();
    }
}
