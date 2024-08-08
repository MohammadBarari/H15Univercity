package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entity.baseEntity.BaseEntity;


@Entity
@Table(name = "coursePrefrence")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CoursePreference extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    @JoinColumn(nullable = true)
    private Student student;

    private Integer grade;
}
