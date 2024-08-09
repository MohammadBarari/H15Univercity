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
@Table(name = "base_employee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseEmployee extends BaseEntity {
@Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String role;
@Column(nullable = false)
    private String phoneNumber;
    @Enumerated(EnumType.ORDINAL)
    private Degree degree;

    private String email;

    @Column(unique = true, nullable = false)
    private String username;

    @Column( nullable = false)
    private String password;

    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "employee")
    private Set<SalaryPaper> salaryPapers;
}
