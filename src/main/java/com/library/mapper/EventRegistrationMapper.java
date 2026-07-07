package com.library.mapper;

import com.library.dto.EventRegistrationDto;
import com.library.model.EventRegistration;

import java.time.LocalDate;

public class EventRegistrationMapper {

    public EventRegistrationDto mapEntityToDto(EventRegistration eventRegistration){
        EventRegistrationDto eventRegistrationDto = new EventRegistrationDto(
                eventRegistration.getId(),
                eventRegistration.getLibraryEvent().getId(),
                eventRegistration.getLibraryEvent().getTitle(),
                LocalDate.parse(eventRegistration.getLibraryEvent().getEventDate().toString().split("T")[0]),
                eventRegistration.getMember().getId(),
                eventRegistration.getMember().getName(),
                eventRegistration.getMember().getEmail(),
                eventRegistration.getAttendanceStatus()
        );
        return eventRegistrationDto;
    }

}
