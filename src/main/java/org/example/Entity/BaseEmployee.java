package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entity.baseEntity.BaseEntity;
import org.example.enums.Degree;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseEmployee extends BaseEntity {

    private String role;


    @Enumerated(EnumType.ORDINAL)
    private Degree degree;

    private String email;

    private String username;

    private String password;

    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "employee")
    private Set<SalaryPaper> salaryPapers;
}
