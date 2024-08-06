package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer buildYear;

    @OneToOne(fetch = FetchType.LAZY)
    private Term term;
}
