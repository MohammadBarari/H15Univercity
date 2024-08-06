package org.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    @OneToOne
    private Lesson lesson;

    @ManyToOne
    private Student student;

    private Integer grade;
}
