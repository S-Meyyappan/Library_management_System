package com.library.dto;

import com.library.enums.AttendanceStatus;

import java.time.LocalDate;

public record EventRegistrationDto(
        long id,
        long eventId,
        String eventName,
        LocalDate eventDate,
        long memberId,
        String memberName,
        String memberEmail,
        AttendanceStatus attendanceStatus
) {
}
