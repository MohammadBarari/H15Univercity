package org.example.Menu;

import org.example.Entity.Course;
import org.example.Entity.Student;

public interface StudentMenuInterface {
    boolean validate(Student token);
    Course findAllCourse();
    Course findCourseByCodeOrName(String code, String name);
}
