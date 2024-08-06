package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.enums.TypeOfTeacher;

import java.util.Set;

@Entity
@Table(name = "teacher")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher extends BaseEmployee{
    @Enumerated(EnumType.ORDINAL)
    private TypeOfTeacher typeOfTeacher;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Lesson> courses;

}
