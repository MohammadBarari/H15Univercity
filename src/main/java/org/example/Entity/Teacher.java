package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.enums.TypeOfTeacher;

import java.util.Set;

@Entity
@Table(name = "teacher")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Teacher extends BaseEmployee {
    @Enumerated(EnumType.ORDINAL)
    private TypeOfTeacher typeOfTeacher;

    @OneToMany(cascade = {CascadeType.ALL} , mappedBy = "teacher")
    private Set<Lesson> lessons;

    @Column(nullable = false)
    private String teacherNumber;

}
