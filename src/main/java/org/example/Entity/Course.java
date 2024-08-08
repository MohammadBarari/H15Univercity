package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;
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
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    private Term term;
}
