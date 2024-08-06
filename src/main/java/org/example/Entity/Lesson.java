package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.enums.Days;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "lesson")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Enumerated(EnumType.ORDINAL)
    private Days days;

    private Integer numberOfUnit;

    private LocalTime startLesson;

    private LocalTime endLesson;

    private LocalDateTime dateOfExam;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
