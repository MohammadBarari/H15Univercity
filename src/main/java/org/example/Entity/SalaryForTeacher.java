package org.example.Entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SalaryForTeacher extends SalaryPaper{
    private Integer numberOfUnitsForTeacher;
}
