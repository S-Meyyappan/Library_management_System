package com.library.model;

import com.library.enums.AttendanceStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "event_registrations")
public class EventRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "library_event_id")
    private LibraryEvent libraryEvent;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus attendanceStatus;

    @CreationTimestamp
    private Instant registeredAt;

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LibraryEvent getLibraryEvent() {
        return libraryEvent;
    }

    public void setLibraryEvent(LibraryEvent libraryEvent) {
        this.libraryEvent = libraryEvent;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public AttendanceStatus getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(AttendanceStatus attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public Instant getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Instant registeredAt) {
        this.registeredAt = registeredAt;
    }

    @Override
    public String toString() {
        return "EventRegistration [id=" + id + ", libraryEvent=" + libraryEvent + ", member=" + member
                + ", attendanceStatus=" + attendanceStatus + ", registeredAt=" + registeredAt +"]";
    }
}
