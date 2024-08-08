package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.Entity.baseEntity.BaseEntity;
import org.example.enums.Degree;

import java.util.Set;
@Entity
@Table
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends BaseEntity {

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true ,mappedBy = "student")
    private Set<CoursePreference> coursePreferences;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String phoneNumber;
    private String email;
    @Column(nullable = false)
    private String studentNumber;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String major;
    @Column(nullable = false)
    private Integer yearEnter;
    @Column(nullable = false)
    private Integer lastTermsAverage;

    private Integer currentTerm;
    @Enumerated(EnumType.ORDINAL)
    private Degree degree;
}
