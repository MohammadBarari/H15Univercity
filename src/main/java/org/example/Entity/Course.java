package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.Entity.baseEntity.BaseEntity;

import java.util.Set;

@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class Course extends BaseEntity {

    @OneToMany(mappedBy = "course")
    private Set<Lesson> lessons;
    @Column(nullable = true , unique = true)
    private String name;
    @Column(unique = true, nullable = true)
    private String courseCode;

}
