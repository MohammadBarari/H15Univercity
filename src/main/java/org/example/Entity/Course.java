package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.Entity.baseEntity.BaseEntity;

import java.util.Set;

@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Course extends BaseEntity {

    @OneToMany(mappedBy = "course")
    private Set<Lesson> lessons;

    private String name;

    private String courseCode;

}
