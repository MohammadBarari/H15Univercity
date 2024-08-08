package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entity.baseEntity.BaseEntity;
import org.example.enums.Days;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "lesson")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Lesson extends BaseEntity {

    private String title;

    @Enumerated(EnumType.ORDINAL)
    private Days days;

    private Integer numberOfUnit;

    private LocalTime startLesson;

    private LocalTime endLesson;

    private LocalDateTime dateOfExam;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToOne(mappedBy = "lesson" , cascade = CascadeType.PERSIST)
    CoursePreference coursePreference;
    private String courseCode;
}
