package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Table(name = "salary")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class SalaryPaper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long salary;
    private LocalDate salaryUpdate;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private BaseEmployee employee;
}
