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

    @OneToMany
    private Set<CoursePreference> coursePreferences;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String studentNumber;
    private String userName;
    private String password;
    private String major;
    private Integer yearEnter;
    private Integer lastTermsAverage;

    @Enumerated(EnumType.ORDINAL)
    private Degree degree;
}
